#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = ProfectCRM_SuoSuo01.urls.py 
# __date__   = 2019/6/5  14:53
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from django.contrib import admin
from django.urls import path
from django.conf.urls import url,include

from shiwei.views import account

urlpatterns = [
    path('', account.dashboard, name='sales_dashboard'),

    # path('sales_dashboard', account),
]
