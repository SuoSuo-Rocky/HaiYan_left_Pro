from django.shortcuts import render,HttpResponse
import json


from shiwei import models

# Create your views here.
def index(request):
    return render(request,"SpecialAjaxDemo01.html",locals())

def ajaxDemo01(request):
        print(request.GET)
        return HttpResponse("OK")

def native01(request):
    print("后台接受到的数据：",request.GET)
    return HttpResponse("OK")

def ajaxDemo02(request):
    print(request.POST)
    return HttpResponse("OK")

def native02(request):
    print("后台接受到的数据：", request.POST)
    print("Native of body:",request.body)
    return HttpResponse("OK")


def iframe_form(request):
    import time
    # time.sleep(5)
    import json
    msg = {"name":"shiwei","age":120}
    print(request.GET)
    print(request.FILES)

    return HttpResponse(json.dumps(msg))

def ajaxfile(request):
    return render(request,"ajaxfile.html",locals())

def ajaxUpload(request):
    msg = {"status":True,"message":""}
    # print(request.GET)
    print(request.POST)
    print(request.FILES)
    img = request.FILES.get("file_text")
    print(img)
    with  open("shiwei.js","wb") as  f:
        for i in img:
            f.write(i)
    obj = json.dumps(msg)
    return HttpResponse(obj)


def iframe_form_file(request):
    msg = {"status": True, "message": ""}
    print(request.POST)
    print(request.FILES)

    obj = json.dumps(msg)
    return HttpResponse(obj)


def blog(request):
    return render(request,"blog_one.html",locals())

def native_demo(request):
    return render(request,'Native_Ajax.html',locals())

def jquery_ajax_demo(request):
    return render(request,"Jquery_Ajax.html",locals())

def jsonp_ajax_demo(reuqest):
    return HttpResponse("")