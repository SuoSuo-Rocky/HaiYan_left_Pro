from builtins import print

from django.shortcuts import render,HttpResponse,redirect

from shiwei.admin import authorDetail
from shiwei.models import  *

# Create your views here.

def panda(request):
    # 概念解析：
    # 子表: 存有三种关系字段之一(量多的一方)的表， 主表相反
    # 正向: 存有三种关系字段之一的表对象 ------》获得关联表对象。子表 --》主表
    # 反向: 自身不存在关系字段， 但通过语法获得 被关联表对象     主表---》子表

    # 定义：
    # OnetoOneField : 单键
    # ForeignKey: 外键
    # ManytoManyField : 超键


# OnetoOne 正向:
# 基本操作：
    # obj = Author.objects.all()
    # #获得 子表所有对象，结果为QuerySet ， 元素为表对象
    # < QuerySet[ < Author: 莫言 >, < Author: 王安石· >, < Author: 忽而覆盖 >,] >

    # obj = Author.objects.get(aid__in=range(2,5))
    # get()----> z只能匹配一个对象， 若匹配结果超过一个，或无匹配结果， 则报错
    # 报错：  get() returned more than one Author
    # 正确情况下 返回结果为 一个表对象。

    # 一对一  ,子表记录 与 主表记录 建立互为一对一的 映射，创建对象 默认可不用指定 id 字段。
    # detail = AuthorDetail.objects.create(id=20,birthday="1997-08-02",qq=2145788956,addr="hunan badajie")
    # obj = Author.objects.create(aid=11,name="shiwei222",age="100",authorDetail=detail)
    # create() -----> 添加字段， 不用 save()

    #此种创对象的方式 一定 要 save(), 才可将数据保存到数据库。
    # au = AuthorDetail(id=21,birthday="1298-12-02",qq=1245785,addr="guangxi de dazita")
    # au.save()
    # obj = Author(a)id=12,name="liping",age=45,authorDetail=au)
    # obj.save()

    # update() 对一个 QuerySet 对象集体更新
    # obj = Author.objects.filter(aid__in=range(6, 13)).update(age=1200)

    #  dleete() 删除 QuerySet 集合中的 所有对象
    # obj = Author.objects.filter(aid__in=range(8,12))
    # obj = obj.delete()

#  万能的上下划线
    # obj = Author.objects.filter(aid__in=range(1,6))
    #注意： filter()  方法返回结果 为QuerySet, 元素为 表对象
    # < QuerySet[ < Author: 莫言 >, < Author: 王安石· >, < Author: 忽而覆盖 >,] >

    # obj = Author.objects.filter(aid__gt=2).values("aid","name","age")
    # values()----》 QuerySet , 元素为 包含指定字段为 键 的  字典
    # < QuerySet[{'aid': 3, 'name': '忽而覆盖', 'age': 80}, {'aid': 4, 'name': '但丁', 'age': 19},]>

    # obj = Author.objects.filter(aid__gt=2).values_list("aid","name","age")
    # values_list() ---->   QuerySet , 元素为包含指定字段的值的  元组
    # < QuerySet[(3, '忽而覆盖', 80), (4, '但丁', 19), (5, '胡海燕', 68)] >

    # obj = Author.objects.exclude(aid__in=range(1,4))
    # 此方法 为反过滤， 与 filter() 相反。
    # < QuerySet[ < Author: 但丁 >, < Author: 胡海燕 >, < Author: shiwei >,] >

    # obj = Author.objects.filter(name__contains="shi")
    # obj = Author.objects.filter(name__icontains="wang")
    # obj = Author.objects.filter(name__endswith="s")
    # obj = Author.objects.filter(name__iendswith="s")
    # obj = Author.objects.filter(name__startswith="wan")
    # obj = Author.objects.filter(name__istartswith="mei")

    # 排序
    # obj = Author.objects.filter(name="shiwei").order_by('aid')  # asc
    # obj = Author.objects.filter(name="shiwei").order_by('-aid') # desc

    # 分组
    from django.db.models import Max,Min,Count,Sum
    #对 values() 的 参数 'name' 进行分组，并且统计每组的行数，得到一个新的字段， 字段名 为 shi
    # obj = Author.objects.filter(aid__gt=1).values('name').annotate(shi=Count('age'))
    # 对values() 方法的 参数 为分组依据， 统计每组的年龄最大者为一个新的字段， 字段名为 wei
    # obj = Author.objects.filter(aid__gt=1).values('name').annotate(wei=Max("age"))
    # 对 values() 方法 的参数为分组依据，再根据一对一键 ，统计每组的关联字段的生日的 最小者。
    # obj = Author.objects.filter(aid__lt=10).values('name').annotate(wan=Min("authorDetail__birthday"))
    # 对 values() 方法 的参数为分组依据， 统计每组的 年龄总和，为一个新的字段， 字段名叫 shi
    # obj = Author.objects.all().values('name').annotate(shi=Sum('age'))

    # 正则表达式匹配，
    # obj = Author.objects.filter(name__regex=r' *.a')
    # 不区分大小写
    # obj = Author.objects.filter(name__iregex=r' *.li')

    # 使用关联字段
    # obj = Author.objects.filter(authorDetail__addr__contains='shi')
    # obj = Author.objects.filter(authorDetail__addr__regex=' *.s[a-z]+')
    # obj = Author.objects.filter(authorDetail__qq__gte=12458761)
    #
    # obj = Author.objects.filter(authorDetail__birthday='0216-02-03')
    # 查询 一对一关联表中 生日的年份 大于 3000 年的
    # obj = Author.objects.filter(authorDetail__birthday__year__gt=3000)
    # 查询 一对一关联表中 生日的 月份等于指定的
    # obj = Author.objects.filter(authorDetail__birthday__month=2)
    #  查询 一对一关联表中 生日的 月份 小于 3 月的， 为 1 月 和 2 月的
    # obj = Author.objects.filter(authorDetail__birthday__month__lt=3)
    # 查询 一对一关联表中 生日中 日份 等于指定值的
    # obj = Author.objects.filter(authorDetail__birthday__day=6)
    # 查询 一对一关联表中 生日 日份 小于 指定值的
    # obj = Author.objects.filter(authorDetail__birthday__day__lt=6)


    # obj = Author.objects.filter(name__in=['但丁','李克强']).values('authorDetail__id')
    # obj = Author.objects.all().values('authorDetail__id')
    # obj = Author.objects.filter(authorDetail__birthday__day_gt=3)





# OnetoOne 反向:
    # 通过 子表的 关联字段的 属性值 related_name="expand" ,
    # 若没有指定，默认为------》子表表名小写 + "_set"
    # obj = AuthorDetail.objects.filter(expand__aid__in=range(1,5))
    # < QuerySet[< AuthorDetail: 2464124454125 >, < AuthorDetail: 21454512124 >] >
    # 主表通过 单键 名 获取 年龄 大于 100 岁的
    # obj = AuthorDetail.objects.filter(expand__age__gt=100)
    # 主表通过 单键名 获取名字中包含指定字符 的
    # obj = AuthorDetail.objects.filter(expand__name__contains='li')
    # 主表通过 单键名 获取 id 值 属于 指定范围的
    # obj = AuthorDetail.objects.filter(expand__aid__range=(1,10))

##### obj = AuthorDetail.objects.filter(expand__age__exact=3838)

#######################################################################
# Book Table 正向操作：
    shiwei = Book.objects
    # filter 多条件， 与操作
    # obj = shiwei.filter(bid__in=range(1,100),title__contains='dfd')
    #  查询 书的价格 不在这个范围的
    # obj = shiwei.exclude(price__in=range(1,100))
    #  查询 书 的 id 小于12 的, 并且 价格 小于 12.23 的
    # obj = shiwei.filter(bid__lt=12,price__lt=12.23)
# 外键操作
    # 查询 是由 id 为指定范围的所有出版社 所出 的所有书
    # obj = shiwei.filter(publisher__pid__in=range(1,10))
    # 查询 以指定字符串开头的 email 地址的出版社 所出版的所有书
    # obj = shiwei.filter(publisher__email__startswith='353fd')
    # Query 名字以指定字符串结尾的城市的出版社所出版的所有的书
    # obj = shiwei.filter(publisher__city__iendswith='fjdkfj')

    # 反向推导： 两次笛卡尔积，
    #    第一步： Query 出版了 价格为指定范围的书的所有的出版社集合
    #    第二步： Query 以第一步 的出版社的集合 所出版了的所有书
    # obj = shiwei.filter(publisher__pu_name__price__in=range(1,100))
    # 解释 上面的 一行代码 ，分为两步走。
    # one = Publisher.objects.filter(pu_name__price__in=range(1,100))
    # two = shiwei.filter(publisher__in=one)
    # print('one=',one,';;;;two=',two)




# 超键操作 ， Query 年龄 为指定值的作者所参与 出版过的所有书
    # obj = shiwei.filter(authors__age=15)
    #通过超键， Query 作者 是 指定的人所参与出版过的 所有的书
    # obj = shiwei.filter(authors__name__in=["胡海燕","但丁"])

# 通过 超键到 主表，再通过 单键 到主表
    # Query 家庭地址为 指定地址 的作者 所出的书
    # obj = shiwei.filter(authors__authorDetail__addr='sheweffjkd')
    # Query qq 为指定值的 作者 所出的书
    # obj = shiwei.filter(authors__authorDetail__qq__gt=12412124545456)
    # Query 出生日期的 年份小于 指定值的All 的作者所出的所有书
    # obj = shiwei.filter(authors__authorDetail__birthday__year__lt=6)
    # Query 出生日期的 月份 为指定区间的 All 的 作者 所出的所有书
    # obj = shiwei.filter(authors__authorDetail__birthday__month__in=range(1,6))

# 通过超键 到主表， 再 反向(子表的超键字段的 related_name 属性值)到子表
    # distinct()方法 去重。
    # obj = shiwei.filter(authors__au_name__bid__range=(1,100)).distinct()
    # 反向推导:第一步： 查询参与出版了 价格为指定范围的 书的 所有作者，
    #         第二步：  再查 :第一步的这些所有作者所参与出版了的所有书，
    # 最终的结果--》书的QuerySet集合，所有书的价格不一定都是第一步指定的范围。
    # obj = shiwei.filter(authors__au_name__price__in=range(1,200)).distinct()

# 性能相关：
    #pan = Author.objects.filter(aid__in=range(1,100)).select_related('authorDetail')
    # 犯错总结: filter() 方法的结果是QuerySet 集合对象，想要获取一个对象的 属性值值，
    # 则必须是 一个单独的对象 来调用属性， 而我刚才却用 QuerySet 来调用了，大错特错。
    # print(pan.first().authorDetail.addr)
    # 当想要通过外键获取 关联表中的 属性时，他才join 操作执行SQL 语句查询 关联表中的数据。
    # 就是其他表中的数据 ，需要就查， 不需要就不查。
    # print(pan.first().authorDetail.qq)

    # wan = Book.objects.filter(bid__in=range(1,100)).select_related('publisher')
    # print(wan)
    # print(wan.first().publisher.city)

    # prefetch_related
    # obj = Book.objects.prefetch_related("publisher")
####################
    # obj = Book.objects.filter(bid__in=range(1,100))
    


    









    print("obj=",obj)
    return HttpResponse("ok")




def ajax(request):
    obj = {'status':True,'message':''}
    print(request.POST)
    print(request.FILES)

    return render(request,"ajaxDemo.html",locals())