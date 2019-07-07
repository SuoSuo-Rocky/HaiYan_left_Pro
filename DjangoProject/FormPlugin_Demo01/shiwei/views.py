from django.shortcuts import render,HttpResponse,redirect

from shiwei import models
from django.core import serializers

# Create your views here.
from django import forms
from django.forms import fields,widgets
class ShiForm(forms.Form):
    username = fields.CharField(
        max_length=18,
        min_length=6,
        required=True,
        error_messages={
            "required":"用户名不能为空",
            "min_length":"太短了",
            "max_length":"太长了",
        },
        # widget = widgets.RadioSelect(choices=((1,"施伟"),(1,"北京"),)),
        # widget=widgets.Select(choices=((1, '上海'), (2, '北京'),))


    )
    # user = fields.MultipleChoiceField(
    #     choices=((1,'上海'),(2,'北京'),),
    #     initial=[1,],
    #     widget=widgets.SelectMultiple
    # )
    password = fields.CharField(
        required=True,
        error_messages={
            "invalid":"不能包含特殊字符"  #  无效都为 此字段
        }
    )
    userage = fields.IntegerField(
        required=True,
    )
    useremail = fields.EmailField(
        required=True,
        min_length=8,
    )


def index(request):
    if request.method == "GET":
        obj = ShiForm()
        return render(request,"index.html",locals())
    if request.method == 'POST':
        obj = ShiForm(request.POST)
    if obj.is_valid():
        print("用提交成功!",obj.cleaned_data)  # 为一个 字典
        # return redirect("/success.html")
    else:
        print("用户提交失败！",obj.errors)
        # return render(request,"index.html",{"obj":obj})
    # return HttpResponse("OK")
    return render(request,"index.html",locals())



def success(request):
    return HttpResponse('OK')

def login(request):
    return render(request,"index.html")

def ajaxDemo(request):
    if request.method ==  "GET":
        obj = ShiForm()
        return render(request,"ajaxDemo.html",locals())
    else:
        obj = ShiForm(request.POST)
        if obj.is_valid():
            return HttpResponse("OK")
        errors = obj.errors
    return render(request,"ajaxDemo.html",locals())
















