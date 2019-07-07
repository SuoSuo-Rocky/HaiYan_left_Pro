from django.shortcuts import render,HttpResponse,redirect
from shiwei.models import *

def add_date(request):
    title = request.POST.get("title")
    hours = request.POST.get("hours")
    stu_list = request.POST.getlist("stu_list")
    # print("stu_list==++++",stu_list)  # List
    obj_course = Student.objects.filter(name__in=stu_list)
    print("obj_course++++",obj_course)  # QuerySet
    obj = Course.objects.create(
        title = title,
        hours = hours,
    )
    obj.stus.add(*obj_course)



def show_course(request):
    if request.method == "POST":
        add_date(request)
    cou_list = Course.objects.all()
    return render(request,'show_course.html',locals())



def add_course(request):
    stu_list = Student.objects.all()
    print("stu_list===",stu_list)
    return render(request,"add_course.html",locals())















