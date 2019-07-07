#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = django_lesson01.urls.py 
# __date__   = 2019/4/7  20:40
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from django.contrib import admin
from django.urls import path
from django.conf.urls import url,include

# import os,sys
# BASE_DIR = os.path.dirname(os.getcwd())
# sys.path.append(BASE_DIR)
from blog import views

urlpatterns = [

    url(r'articles/\d{4}',views.article_year),
    # 加了括号 表示  组内的内容 为 视图函数的参数
    url(r'articles02/(\d{4})$',views.article_year01),
    url(r'articles02/(\d{4})/(\d{2})',views.article_year02),
    url(r'articles03/(?P<ye>\d{4})/(?P<mon>\d{2})', views.article_year03),
    url(r'register',views.register),
    # 路由分发
    url(r'chuli',views.chuli,name="chu"),

    ]






