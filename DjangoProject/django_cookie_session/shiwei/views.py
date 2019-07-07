from django.shortcuts import render,HttpResponse,redirect


# Create your views here.

def login(request):
    print("COOKIE:", request.COOKIES)
    # print("SESSION:", request.session)
    print("request:",request)
    if request.method == "POST":
        username = request.POST.get("username")
        password = request.POST.get("password")
        if username == "shiwei" and password == "123456":
            ret = redirect("/index/")
            print("response:",ret)
            ret.set_cookie("hobby","lanqiu",max_age=10)  # 10 秒
            request.session.set_expiry(10)  #  10 秒
            return ret
    return render(request,"login.html",locals())

def index(request):
    name = "shiwei"
    return render(request,"index.html",locals())
