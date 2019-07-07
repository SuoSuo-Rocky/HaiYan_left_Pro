#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = alex_rocky.student.py 
# __date__   = 2019/4/15  14:42
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------

from django.shortcuts import  render,HttpResponse,redirect
from shiwei.models import *
import time

def add_date(request):
    username = request.POST.get("username")
    userage = request.POST.get("userage")
    sex = request.POST.get("usersex")
    if sex == "1":
        usersex = True
    else:
        usersex = False
    born_date = request.POST.get("born_date")
    print("born_date=",born_date)
    Student.objects.create(
        name=username,
        age=userage,
        gender=usersex,
        born_date=born_date,
    )


def show_student(request):
    if request.method == "POST":
        add_date(request)

    stu_list = Student.objects.all()
    return render(request,"show_student.html",locals())

def del_student(request):
    nid = request.GET.get("id")
    Student.objects.filter(id = nid).delete()
    stu_list = Student.objects.all()
    return render(request,"show_student.html",locals())


def add_student(request):
    return render(request,"add_student.html",)


def repeat_add(request):
    return render(request,"add_student.html",locals())

def edit_student(request):
    nid = request.GET.get("id")
    print("edit_student_id=",nid,"type=",type(nid))

    student = Student.objects.filter(id = nid).first()
    print("edit_student_object=",student)
    return render(request,"edit_student.html",locals())

import re
def charge(born_date):
    born_date = str(born_date)
    # if len(born_date) == 10:
    #     if born_date[4] == born_date[7]  == "-":
    #         if born_date[5:7].isdigit() and born_date[:4].isdigit() and born_date[8:].isdigit():
    #             if int(born_date[5:7]) > 1 and int(born_date[5:7] <= 12 ):
    #                 if int(born_date[8:]) > 0 and int(born_date[8:]) <=30:
    #                     return True
    # return False
    if re.findall("\d{4}-(?:0\d|1[0,1,2])-[0-2]\d",born_date).__len__() == 1:
        return True
    else:
        return False




def submit_edit(request):
    nid = request.GET.get("nid")
    print("type==",type(nid))
    print("nid====",nid)
    name = request.GET.get("username")
    age = request.GET.get("userage")
    sex = request.GET.get("usersex")
    if sex:
        sex = True
    else:
        sex = False
    born_date = request.GET.get("born_date")
    if not charge(born_date):
        student = Student.objects.filter(id = nid).first()
        print("student====",student)
        return render(request,"edit_student.html",{"student":student})

    stu = Student.objects.filter(id = nid).first()
    print("stu======",stu)
    if stu:
        stu.name = name
        stu.age = age
        stu.gender = sex
        stu.born_date = born_date
    return redirect("/show_student.html")




















