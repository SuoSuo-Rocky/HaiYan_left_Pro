

from django.shortcuts import render,HttpResponse,redirect

from shiwei.models import *

def add_date(request):
    username = request.POST.get("username")
    userage = request.POST.get("userage")
    graduate = request.POST.get("user_graduate")
    course = request.POST.get("user_course")
    obj_course = Course.objects.filter(title=course).first()
    Teacher.objects.create(
        name=username,
        age=userage,
        graduate=graduate,
        course=obj_course,
    )


def show_teacher(request):
    if request.method =="POST":
        add_date(request)

    tea_list = Teacher.objects.all()
    return render(request,'show_teacher.html',locals())


def add_teacher(request):
    course_list = Course.objects.all()
    print("course-list=",course_list)

    return render(request,'add_teacher.html',locals())
