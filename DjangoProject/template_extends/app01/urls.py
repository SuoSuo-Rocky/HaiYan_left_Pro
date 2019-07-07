#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = template_extends.urls.py 
# __date__   = 2019/4/8  20:45
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from django.contrib import admin
from django.urls import path
from django.conf.urls import url,include

from app01 import views

urlpatterns = [
    url(r"student/",views.student),
    url(r"teacher/",views.teacher),
    url(r"course/",views.course),
    url(r'classes/',views.classes),
]
