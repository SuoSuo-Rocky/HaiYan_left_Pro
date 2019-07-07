#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = ProfectCRM_SuoSuo01.urls.py 
# __date__   = 2019/6/6  11:29
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------

from django.contrib import admin
from django.urls import path
from django.conf.urls import url,include
from kingAdmin import views


urlpatterns = [
    url('^$',views.app_index, name='app_index'),
    url(r'(\w+)/(\w+)/$', views.table_obj_list, name="table_obj_list"),
    path('login', views.acc_login.as_view()),  # 每次写 CBV 时 ， 就忘了 调用 as_view()
    url('^logout$', views.acc_logout, name='logout'),
]
