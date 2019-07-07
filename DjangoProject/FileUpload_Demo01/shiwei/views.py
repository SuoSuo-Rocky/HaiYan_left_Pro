from django.shortcuts import render,HttpResponse,redirect
from django import forms
from django.forms import fields
# Create your views here.

class FormUpload(forms.Form):
    user = fields.CharField()
    img = fields.FileField()


def fileUpload(request):
    if request.method == "GET":
        obj = FormUpload()
        return render(request,"fileUpload.html",locals())
    else:
        # obj = FormUpload(request.POST,request.FILES)
        # if obj.is_valid():
        #     user = obj.cleaned_data.get("user")
        #     img = obj.cleaned_data.get("img")

        user = request.POST.get("user")
        img = request.FILES.get("img")
        f = open(img.name,"wb")
        for line in img.chunks():
            f.write(line)
        f.close()
        return HttpResponse('.........')