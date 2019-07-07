from django.shortcuts import render,HttpResponse,redirect
from django.http import JsonResponse


from django.urls import reverse
from repository.models import *
from web.myforms.account import  RegisterForm,LoginForm
# Create your views here.

import re
#  NON_FIELD_ERRORS = '__all__'
from django.core.exceptions import ValidationError,NON_FIELD_ERRORS
from io import BytesIO
from utils.check_code import create_validate_code
from django.db.models import Count
# 自定义验证规则
def mobile_validate(value):
    mobile_re = re.compile(r'^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&?*]).{6,18}$')
    if not mobile_re.match(value):
        raise ValidationError('密码格式错误')

msg = {
    'status':False,
    'user':'',
}
def index(request,*args,**kwargs):
    if kwargs:
        print("KWARGS['MAIN_CLASS]=", kwargs['main_class'])
        path = reverse('index', kwargs=kwargs)
        blog_list = Blog.objects.filter(main_class=kwargs['main_class'])
        if kwargs['main_class'] == '0':
            blog_list = Blog.objects.all()
    else:
        path = '/'
        kwargs['main_class'] = 0
        blog_list = Blog.objects.all()
    for item in blog_list:
        support = sp_tread.objects.filter(bid=item, type=1).__len__()
        item.support = support
        dis = Discuss.objects.filter(bid=item).__len__()
        item.dis = dis
    print("blog_list=",blog_list)
    # print('args=', args, '\nkwargs=', kwargs)
    main_class = Blog.choice_type
    kwargs['main_class'] = int(kwargs['main_class']) # 为了模板语言的 数字比较，故转换类型。

    if msg['status']:
        user_id = int(request.session['uid'])
        obj = User.objects.filter(uid=user_id).first()
        msg['user'] = obj
    print('msg======',msg)
    print
    return render(request,'index.html',{
        'kwargs': kwargs,
        'blog_list': blog_list,
        'main_class': main_class,
        'msg': msg,
    })

def test(request):
    # obj = Blog.objects.all()
    # print('detail=',obj)
    # one = obj[0]
    # one.name = 'shiwei'
    # len = one.self_class.user.sp_tread_set.all().__len__()
    # print('support',len)

    user = User.objects.filter(uid=2).first()
    print('user=',user)
    print("site02=",user.user_info.first().site)
    return HttpResponse('OK')

#  验证流程，
# 1.先 逐一的 验证 每一个字段的 正则表达式 和 相应的 局部钩子方法
# 2.最后 再执行 全局的钩子方法
# 谁先来验证 不知道
# 故在 局部钩子方法中, 只能取 自己字段的值
# 遇到一个 匹配不成功，则后续的不再验证

def register(request):
    if request.method != 'POST':
        form_self = RegisterForm()
    else:
        form_self = RegisterForm(request.POST, request.FILES)
        # for name,fie in form_self.fields.items():
        #     value = fie.widget.value_from_datadict(form_self.data, form_self.files, form_self.add_prefix(name))
        #     print('name=',name,'||||||,value=',value)
        if form_self.is_valid():
            print("所有干净的字段为:",form_self.cleaned_data)

            # 要用相对地址， 前面没有 斜杆
            # with open('static/img/user_img/'+form_self.cleaned_data['img'].name,'wb') as f:
            #     for i in form_self.cleaned_data['img']:
            #         f.write(i)
            # print('图片为:',myimg)
            username = form_self.cleaned_data['username']
            email = form_self.cleaned_data['email']
            password = form_self.cleaned_data['pwd']
            vali = form_self.cleaned_data['validate']

            print("是否免登录：", request.POST.get('isfree'))
            if request.POST.get('isfree'):
                request.session.set_expiry(60 * 60 * 24 * 30)  #设置用户一个月免登录
            self_vali = request.session['check_code']
            print('Native=',self_vali,'>>>>>>> Input=',vali)
            # if self_vali != vali:
            #     form_self.errors['validate'] = '验证码输入错误'
            #     return render(request,'regis_test.html', {"form": form_self, })
            User.objects.create(username=username, pwd=password, email=email)

            return redirect('/')
        else:
            clean_error = form_self.errors.get("__all__")
            print('clean_error=',clean_error)
            print('所有错误的字段为:',form_self.errors)
        return render(request,'regis_test.html', {"form":form_self, })
    return render(request, 'regis_test.html', {"form":form_self, })

def login(request):
    # msg = {'status':True,'mseeage':'账号或密码错误！'}
    if request.method != 'POST':
        myform = LoginForm()
    else:
        myform = LoginForm(request.POST)
        if myform.is_valid():
            username = myform.cleaned_data['username']
            password = myform.cleaned_data['password']
            validate = myform.cleaned_data['validate']
            obj = User.objects.filter(username=username,pwd=password,)
            if len(obj) == 1:
                request.session['uid'] = obj.first().uid
                print('uid=',obj.first().uid)
                msg['status'] = True
                return redirect('/',)
            else:
                myform.errors['username'] = '账号或密码错误'
                print('dfdkfjkdf==',myform.errors)
                print('类型为=',type(myform.errors['username']))
                return render(request,'login.html',{"form": myform})
        else:
            myform = LoginForm()
            return render(request, 'login.html', {"form": myform})
    return render(request, 'login.html', {"form": myform})

def validation(request):
    return render(request,'validation.html',locals())

# HttpResponse 也可以返回字节， 可以返回字符串
def shiwei(request):    # 返回验证码图片
    # with open('static/img/blog_img/1.webp','rb') as f:
    #     data = f.read()

    one = BytesIO()  # 内存里面的 一块内存，
    img, code = create_validate_code()
    request.session['check_code'] = code
    img.save(one,'PNG')
      #  获取 内存中的所有值， 字节型
    return HttpResponse(one.getvalue())

def init_self(user,blog_list):
    """
    初始化博主的 阅读数量， 赞数， 踩数
    :param user:
    :return:
    """
    # blog_list = Blog.objects.filter(self_class__in=user.uid_class.all())
    for item in blog_list:
        item.comment_count = Discuss.objects.filter(uid=user,bid=item).__len__()
        item.up_count = sp_tread.objects.filter(uid=user,type=1,bid=item).__len__()
        item.down_count = sp_tread.objects.filter(uid=user,type=0,bid=item).__len__()

def master(request,site):
    """
    进入 个人 主站
    :param request:
    :param site: 主站前缀
    :return:
    """
    obj = UserInfo.objects.filter(site=site).first()
    user = obj.user
    class_list = user.uid_class.all()
    blog_list = Blog.objects.filter(self_class__in=class_list)
    init_self(user,blog_list)  #  统计 个人博客的 相关信息
    tag_list = user.uid_tag.all()

    # date_list = Blog.objects.raw(
    #     'select bid, count(bid) as num,strftime("%Y-%m",ctime) as times from Blog group by strftime("%Y-%m",ctime)')
    date_list = list(Blog.objects.filter(self_class__in=class_list).values('ctime').annotate(num=Count('ctime')))
    print('我的博客=',blog_list)


    return render(request,'master.html',{
        'obj': obj,
        'class_list': class_list,
        'tag_list': tag_list,
        'date_list': date_list,
        'blog_list': blog_list,
    })

def master_son(request,site,kind,cid):
    cid = int(cid)
    obj = UserInfo.objects.filter(site=site).first()
    user = obj.user
    class_list = user.uid_class.all()
    if kind == 'class':
        blog_list = Blog.objects.filter(self_class_id=cid)
    if kind == 'tag':
        blog_list = Blog.objects.filter(tag=Tag.objects.filter(id=cid).first())
    if kind == 'date':
        blog_list = Blog.objects.filter(ctime=cid,self_class__user=user)


    init_self(user, blog_list)  # 统计 个人博客的 相关信息
    tag_list = user.uid_tag.all()

    # date_list = Blog.objects.raw(
    #     'select bid, count(bid) as num,strftime("%Y-%m",ctime) as times from Blog group by strftime("%Y-%m",ctime)')
    date_list = list(Blog.objects.filter(self_class__in=class_list).values('ctime').annotate(num=Count('ctime')))
    print('我的博客=', blog_list)

    return render(request, 'master.html', {
        'obj': obj,
        'class_list': class_list,
        'tag_list': tag_list,
        'date_list': date_list,
        'blog_list': blog_list,
    })








