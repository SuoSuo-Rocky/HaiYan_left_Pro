from django.shortcuts import render,HttpResponse

# Create your views here.

from shiwei.models import *

def addbook(req):
    # 方式 一
    # t = Book(name="xijingping",price=120,author='shiwei',pub_date='1245-02-26')
    # t.save()
    # 方式二
    Book.objects.create(name='huhaiyan',price=12,pub_date="1245-02-02",author="shiwei")

    return  HttpResponse("添加成功")

def delbook(req):
    Book.objects.filter(name="shiwei").delete()
    return HttpResponse("删除成功")

def updatebook(req):
    # 方式 一
    # t = Book.objects.get(name='wanganshi')
    # t.author = 'shiwei'
    # t.price = 1000
    # t.save()  #  要 保存

    # 方式二
    t = Book.objects.filter(name='wanganshi')
    t.update(price = 2000)
    print(t)


    return HttpResponse("修改成功")


def selectAll(req):
    # book_list = Book.objects.filter(price=120)
    # print("book_list:",book_list)
    book_list = Book.objects.all() # 获得所有结果集
    print("all_list:",book_list[:2])
    #
    # book_list02 = Book.objects.filter(price=120).values("name","author")
    # print("values_t:",book_list02)


    return render(req,"index.html",locals())


















