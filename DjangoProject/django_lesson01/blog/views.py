from django.shortcuts import render,HttpResponse,redirect

# Create your views here.

import time

def show_time(req): # 服务器 打包的 客户端的 数据对象
    # return HttpResponse("Hello")
    shiwei = time.ctime()
    # return render(req,"index.html",locals())
    return render(req,"index.html",{"time":shiwei})
    # return redirect("/index/")


def index(req):
    return render(req,"index.html")

#  无命名分组
def article_year(req):
    return HttpResponse("2004")


def article_year01(req,year):
    return HttpResponse(year)

def article_year02(req,years,months):
    return HttpResponse("无命名分组\n" + "year:%s  \n month:%s"%(years,months))

def article_year03(req,ye,mon):
    return HttpResponse("有命名分组\n" + "year:%s  \n month:%s"%(ye,mon))

def register(req):
    return render(req,"register.html")

def chuli(req):
    if req.method == "POST":
        print("name:",req.POST.get("username"))
        print("password:",req.POST.get("password"))
    return HttpResponse("OK")
