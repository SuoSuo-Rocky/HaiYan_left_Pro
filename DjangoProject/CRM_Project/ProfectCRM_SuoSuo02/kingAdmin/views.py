
# Create your views here.
from django.shortcuts import render, HttpResponse, redirect
from django.http import JsonResponse
from django.views import View
from repository.models import  *
import json

# Django 自带验证
from django.contrib.auth import authenticate,login,logout
from django.contrib.auth.decorators import login_required
# 动态获取项目settings配置
from django import conf
import importlib

from kingAdmin import app_setup
app_setup.kingadmin_auto_discover()  # 全局 执行
from kingAdmin import new_site

from kingAdmin.admin_base import BaseKingAdmin

@login_required
def app_index(request):
    enabled_admins = new_site.site.enabled_admins

    # 从 配置文件中 读取路径
    return render(request, 'kingadmin/app_index.html', {"enabled_admins": enabled_admins})

@login_required
def table_obj_list(request,app_name,model_name):
    """  取出 指定 表中的数据 返回 到前端  """
    admin_class = new_site.site.enabled_admins[app_name][model_name]
    # print("app_name,model_name----->",model_name,admin_class)
    model_class = admin_class.model
    # print('model_class----->', model_class)
    querysets = model_class.objects.all()
    print('QuerySets------>',querysets)




    return render(request, 'kingadmin/table_obj_list.html', {
        "querysets": querysets,
        "admin_class": admin_class,
    })
    # return HttpResponse("ok")







class acc_login(View):
    error_msg = ''
    def get(self, request, *args, **kwargs):
        return render(request, 'kingadmin/login.html',locals())

    def post(self,request):
        username = request.POST.get('username')
        password = request.POST.get('password')
  # 第一步: 验证
        # 结果 为 从 DB 中 取出 的 user 对象，只是 单纯的 判断 数据 是否正确
        user = authenticate(username = username, password = password)
        if user:
            print("passed authentication ", user)
 # 第二步: 真正的 登录，生成 session
            # 自动 将  user 对象保存到 session 中 ， request.user = user
            login(request,user)
            # 登录成功的情况下 跳转到 初次 请求的页面
            return redirect(request.GET.get('next', '/kingadmin'))
        else:
            # 设置 错误提示消息
            error_msg = 'Wrong username or password! '

        print('username=',username,'\n password=',password,'\nuser=',user)
        # 在前端页面 使用 模板 语言 可以直接 调用 request  对象，
        # 在 后台若验证成功自动 封装 user  到 request 中
        return render(request, 'kingadmin/login.html', {'error_msg': error_msg})
        #  要加 斜杠   否则 报错
        # return redirect('/shiwei')
###############    或者 FBV  的 方式
# def login(request):
#     if request.method == "POST":
#         username = request.POST.get('username')
#         password = request.POST.get('password')
#         print('username=',username,'\n password=',password)
#     return render(request, 'login.html',locals())

def acc_logout(request):
    logout(request)   # 退出， 清空 session
    return redirect('/login')

