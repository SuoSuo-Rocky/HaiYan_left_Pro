from shiwei.models import *
from django.shortcuts import  HttpResponse,render,redirect
def shiwei(request):
# 基本操作：
    #  添加：
            # 一对一  ,子表记录 与 主表记录 建立互为一对一的 映射，创建对象 默认可不用指定 id 字段。
            # detail = AuthorDetail.objects.create(id=20,birthday="1997-08-02",qq=2145788956,addr="hunan badajie")
            # obj = Author.objects.create(aid=11,name="shiwei222",age="100",authorDetail=detail)
            # create()                                # 添加字段， 不用 save(),自动保存到 DB

            # 此种创建对象的方式 一定 要 save(), 才可将数据保存到数据库。相当DB中操作 Commit()
            # au = AuthorDetail(id=21,birthday="1298-12-02",qq=1245785,addr="guangxi de dazita")
            # au.save()
            # obj = Author(a)id=12,name="liping",age=45,authorDetail=au)
            # obj.save()
    # 更新：
            # update()                               #对一个 QuerySet 对象集体更新
            # obj = Author.objects.filter(aid__in=range(6 ,13)).update(age=1200)
            # obj = Author.objects.get(aid = 10)     # 获取单条数据
            # obj.name  = "panda"
            # obj.save()                             # 调用属性进行赋值，要将 改变值 保存到 DB ,  要sava()提交
    #删除：
            #  dleete()                              # 删除 QuerySet 集合中的 所有对象
            # obj = Author.objects.filter(aid__in=range(8,12)).delete()
    #查询：
            # obj = Author.objects.get(id=10)
            # obj = Author.objects.get(aid=5)       # 获取单条数据，当对象不存在 或者 当条件匹配多个对象时，都会报错。
            # obj = Author.objects.all()            # 获取 表中所有记录对象
            # obj = Author.objects.filter(aid__in=range(1,100)) # 对表中数据进行过滤筛选
            # obj = Author.objects.exclude(aid__in=range(1,100)) # 对表中数据进行反过滤， 与 filter() 相反。
#进阶操作：
    # obj = Author.objects.filter(aid__in=range(1,6))  # ID 属于一个 集合，in(1,2,3,4,5) 左闭右开 ，故不包含 6
    # obj = Author.objects.filter(aid__range=[1,6]) # 范围 bettwen 100 and 200， 闭 区间， 包含 6

    # obj = Author.objects.filter(aid__lt=100)         # ID值 less than(小于)
    # obj = Author.objects.filter(aid__lte=100)# ID less than or equal(小于等于)
    # obj = Author.objects.filter(aid__gt=100)# ID greater than (大于)
    # obj = Author.objects.filter(aid__gte=100) # ID greater than or equal (大于等于)
    # obj = Author.objects.filter(name__contains="shi")  # 包含指定 字符的
    # obj = Author.objects.filter(name__icontains="wang") # 包含指定 字符的， 但不区分大小写
    # obj = Author.objects.filter(name__endswith="s") # 以指定字符结尾的，
    # obj = Author.objects.filter(name__iendswith="s") # 以指定字符结尾的，但不区分大小写
    # obj = Author.objects.filter(name__startswith="wan") # 以指定字符开头的，
    # obj = Author.objects.filter(name__istartswith="mei") # 以指定字符开头的， 但不区分大小写
    # obj = Author.objects.filter(name__regex=r' *.a')   # 正则表达式匹配，
    # obj = Author.objects.filter(name__iregex=r' *.li') # 正则表达式匹配，不区分大小写

    #  filter(**kwargs) 方法 条件 与 操作
    # obj = Author.objects.filter(aid__gte=10,aid__lte=50)
    # obj = Author.objects.filter(aid__in=range(10,100),name__contains="shi")

    # obj = Author.objects.filter(aid__in=range(1,100)).order_by("aid")  # 对 QuerySet集合元素根据 aid 字段  asc
    # obj = Author.objects.filter(aid__in=range(1,100)).order_by("-aid") # 对 QuerySet集合元素根据 aid 字段  desc
    #
    # obj = Author.objects.filter(aid__in=range(1,100)).count()  # 查询 QuerySet集合的 长度
    # obj = Author.objects.filter(aid__in=range(1,100)).first() #  查询 QuerySet集合 中的第一个 元素
    # obj = Author.objects.filter(aid__in=range(1,100)).last()  #  查询 QuerySet集合 中的最后一个元素

    # obj = Book.objects.filter(publishDate__year__range=[2000,2555])  # BETWEEN 2000 AND 2555 ,包含2555
    # obj = Book.objects.filter(publishDate__year__in=range(2000,2555))#  IN(2000, ....,2553,2554)
    # obj = Book.objects.filter(publishDate__month__gt=6)              #  > 6
    # obj = Book.objects.filter(publishDate__day__lt=6)                # < 6
    # obj = Book.objects.filter(publishDate__week_day=4)               # 映射 星期几，星期日:1 ,星期六：7
    #                     # 注意区分与 datetime.date(2017,2,23).weekday() # 映射 星期几，0 表示 星期 一
    #                     # 注意区分与 datetime.date(2017,2,23).isoweekday() # 映射 星期几，1 表示 星期 一
    # obj = AuthorDetail.objects.filter(birthday__hour=12)
    # obj = AuthorDetail.objects.filter(birthday__minute__lt=12)
    # obj = AuthorDetail.objects.filter(birthday__second__gt=30)
    # obj = AuthorDetail.objects.filter(birthday__hour__range=[8,20])

# 高级操作:
#F and Q :
    from django.db.models import F,Q
#     obj = Author.objects.filter(aid=6).update(age = F('age')+100)
    # 默认情况下，filter(),exclude(),get(), 方法中的条件以逗号分隔， 都为 与 运算， and 操作，
    # 要想实现 或运算，也就是 or 操作， 则用 Q 查询：
    # obj = Author.objects.filter(Q(aid=4)|Q(age=80))   # or  运算
    # obj = Author.objects.filter(Q(aid=4)&Q(age=80))   # and 运算
    # obj = Author.objects.filter(Q(age=80)).count()      #
# 小飘的使用:
    # 下方 的 两条查询语句所执行的 SQL 语句一模一样， 故 one = two,
    # one = Author.objects.filter(~Q(age=80)).count()     #  WHERE NOT
    # two = Author.objects.exclude(Q(age=80)).count()     #  WHERE NOT

    # 注意: 当关键字参数 和 Q对象 组合使用时， Q对象必须放在前面。否则报错。
    # obj = Author.objects.filter(Q(aid__gt=15)|Q(aid__lte=1)&Q(name='shiweiIslion'),aid__gt=10)
    # SQL语句为: where (( aid > 15 or ( aid <=1 and name = 'shiwei' )) and aid > 10 )
    # obj = Author.objects.filter(Q(aid__gt=15)|Q(aid__lte=1)&~Q(name='shiweiIslion'),aid__gt=10)
    # SQL语句为: where (( aid > 15 or ( aid <=1 and not ( name = 'shiwei' ))) and aid > 10)

# 执行 原生 SQL 语句: 依赖 与 Django 正常运行的情况下 :
    # from django.db import connection,connections
    # cursor = connection.cursor()  # cursor = connections['default'].cursor()
    # cursor.execute("""SELECT * FROM shiwei_author where aid = %s""",(1,))
    # obj = row = cursor.fetchone()
# QuerySet 切片操作: 下标 从 0 开始
    # obj = Author.objects.all()[1:4]  #  LIMIT 3  左闭右开 区间
    # 左闭右开 区间，每 两 个为一组，只显示每组 第一个
    # obj = Author.objects.all()[1:7:2]   # 实际 SQL 语句为  LIMIT 6 OFFSET 1
    # 左闭右开 区间，每 三 个为一组，只显示每组 第一个
    # obj = Author.objects.all()[1:7:3]   # 实际 SQL 语句为  LIMIT 6 OFFSET 1

    from django.db.models import Count,Max,Min,Sum,Avg
# group by 操作:annotate(**kwargs) :  提供聚合表达式查询方法，
    # values('aid','age').annotate(**kwargs)       # 结果为列表对象， 元素为 字典对象
    # values_list('aid','age').annotate(**kwargs)  # 结果为列表对象， 元素为 元祖 对象
    # 可写多个参数，每个参数都是一个annotation，它将添加到返回结果对象中。就是原生SQL 的 select 返回字段中。
    # 每个参数 可指定别名， 匿名参数将基于 字段名__聚合函数名称 来自动生成 : 例如:
    #  annotate(Count('name'))      #  select  Count('name') AS  name__count,........
    #  annotate(shi=Count('name'))  #  select  Count('name') AS  shi,........
    #  annotate(shi=Count('name'),wei=Sum('age'))  #  select  Count('name') AS  shi,Sum('name') AS wei,.......
    # values() 和 values_list() 方法中参数若 存在主键字段， 则自动以 主键 分组，相当于没有分组。
    #    在没有 主键字段的情况下， 有一个字段，就按此字段分组， 有多个字段， 则以这几个字段为联合字段进行分组。

    # 以 ('aid')字段 为分组依据，
    # obj = Author.objects.filter(aid__gt=15).annotate(shi = Count('age')).values('aid','name','shi')
    # 结果为:<QuerySet [{'aid': 16, 'name': 'shiweiIslion', 'shi': 1}, {'aid': 17, 'name': '李克强', 'shi': 1}]>

    # 以 ('name') 字段 为分组依据， 统计每组的年龄最大者为一个新的字段， 字段名为 wei
    # obj = Author.objects.filter(aid__gt=1).values('name').annotate(wei=Max("age"))
    # 结果为:<QuerySet [{'name': '王安石·', 'wei': 78}, {'name': '忽而覆盖', 'wei': 80}]>

    # 以 ('name') 字段为分组依据，再根据一对一键 ，统计每组的关联字段的生日的 最小者。
    # obj = Author.objects.filter(aid__gt=10).values('name').annotate(wan=Min("authorDetail__birthday"))
    # 结果为:<QuerySet  [{'name': 'liping', 'wan': datetime.datetime(1298, 12, 2, 0, 0, tzinfo=<UTC>)}, {'name': 'lihaimei', 'wan': datetime.datetime(1205, 5, 6, 0, 0, tzinfo=<UTC>)}]>

    # 对 values() 方法 的参数为分组依据， 统计每组的 年龄总和，为一个新的字段， 字段名叫 shi
    # obj = Author.objects.all().values_list('name').annotate(shi=Sum('age'))
    # 结果为:<QuerySet [('莫言', 56), ('王安石·', 78), ('忽而覆盖', 80), ('但丁', 3918)]>

    # 对 values() 的 参数 'name' 进行分组，并且统计每组的行数，得到一个新的字段， 字段名 为 shi
    # obj = Author.objects.filter(aid__gt=1).values('name').annotate(shi=Count('age'))
    # 结果为: <QuerySet [{'name': '王安石·', 'shi': 1}, {'name': '忽而覆盖', 'shi': 1}]> # QuerySet 对象
# QuerySet 转化为 List 对象
    # list(obj) 等于: [{'name': '王安石·', 'shi': 1}, {'name': '忽而覆盖', 'shi': 1}]
    # 以('age','name','authorDetail') 为分组依据
    # obj = Author.objects.filter(aid__gt=10).values_list('age','name','authorDetail').annotate(shi=Count('age'),wei=Sum('age'))
    # 以 ('aid') 为分组依据。
    # obj = Author.objects.filter(aid__gt=10).values('age','name','authorDetail','aid').annotate(Count('name'),wei=Sum('age'))

    # obj = Author.objects.filter(aid__lt=100).values_list('name', 'age').annotate(shi=Sum('age')).values_list('name')
    # 结果为: <QuerySet [('莫言',), ('王安石·',), ('忽而覆盖',), ('但丁',)]>

    # 最后一个 有 ("aid") 字段， 则 聚合函数 以 ("aid") 字段分组
    # obj = Author.objects.filter(aid__lt=100).values_list('name', 'age').annotate(shi=Sum('age')).values_list('name','aid')
    # 结果为:  <QuerySet [('莫言', 1), ('王安石·', 2), ('忽而覆盖', 3), ('但丁', 4)]>

    # 以 ('name','age','authorDetail__qq') 为分组依据。
    # obj = Author.objects.filter(aid__lt=100).values_list('name', 'age').annotate(shi=Sum('age')).values_list('name','authorDetail__qq')
    # 结过为:  <QuerySet [('莫言', 54545), ('王安石·', 145122152), ('忽而覆盖', 2464124454125)]> # 按照最后一个 values_list()

    # 以 ('name','age','authorDetail__qq') 为分组依据。
    # obj = Author.objects.filter(aid__lt=100).values_list('name', 'age').annotate(shi=Sum('age')).values('name','authorDetail__qq')
    # 结过为:  <QuerySet [{'name': '莫言', 'authorDetail__qq': 54545}, {'name': '王安石·', 'authorDetail__qq': 145122152}]>

    # 对分组查询结果 进一步进行 筛选
    # obj = Author.objects.values_list("age","name").annotate(shi=Count("name",distinct=True)).filter(aid__gt=15)

# order_by 操作:
    # obj =  Author.objects.order_by('name','age')
    # obj = Author.objects.order_by('age','name') # 先按照 年龄 asc 排序，再按照 name asc 排序。

# reverse() : 第二次调用reverse()将恢复到原有的排序
    # obj =  Author.objects.order_by('name','age').reverse()[:3]  # 获取前三个元素， 不支持负索引









# obj = Author.objects.annotate(Count('age'))
    # 结果为:  [<Author: 莫言>, <Author: 王安石·>, <Author: 忽而覆盖>]
    # obj = Author.objects.filter(aid__gt=10).values_list('name',"age")











    # print('obj = ',list(obj))
    print('obj = ',obj)
    return HttpResponse("CRUD is Ok!")
