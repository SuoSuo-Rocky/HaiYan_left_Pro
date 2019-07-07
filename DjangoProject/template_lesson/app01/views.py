from django.shortcuts import render,HttpResponse

# Create your views here.

import datetime
def show_time(req):
    t = datetime.datetime.now()
    # return HttpResponse("<html><body>It is now %s.</body></html>"%(t))
    return render(req,"show_time.html",{"time":t})
class Animal:
    def __init__(self,name,sex):
        self.name = name
        self.sex = sex



def query(req):
    t = ["shi_%s"% i for i in range(100)]
    d = {"name":"shiwei","age":100}

    c = Animal("alex","male")
    e = Animal("egon","female")
    wei = " H  e lo   shi wei "
    date_time = datetime.datetime.now()
    no = ""
    chao = "<a href="">click</a>"
    none = None
    test_str = "ShiWei is the Big Bang!"
    value8='http://www.baidu.com/?a=1&b=3'
    return render(req,"query.html",locals())

def tagDemo(req):
    d = {"name":"shiwei","age":50}
    td = ["shi_%s" % i for i in range(10)]
    return render(req,"tags.html",locals())


def login(req):

    return render(req, "user_login.html", locals())



