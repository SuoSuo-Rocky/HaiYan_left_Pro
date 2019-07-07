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
from rest_framework import routers

from shiwei.views import account

from repository.rest_views import UserViewSet, RoleViewSet

# Routers provide an easy way of automatically determining the URL conf.
router = routers.DefaultRouter()
router.register(r'users', UserViewSet)
router.register(r'roles',RoleViewSet)
# Wire up our API using automatic URL routing.
# Additionally, we include login URLs for the browsable API.
urlpatterns_two = [

    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]

 # url 向后匹配 不加 $  符号
urlpatterns = [
    url(r'^api/', include(router.urls)),
    path('wanganshi', account.wanganshi, name="wanganshi"),
    path('', account.dashboard, name='sales_dashboard'),
    path('stu_enrollment/', account.stu_enrollment, name='stu_enrollment'),
    url(r'^enrollment/(\d+)/$', account.enrollment, name='enrollment'),
    url(r'^enrollment/(\d+)/contract_upload$', account.contract_upload, name='contract_upload'),
    url(r'^enrollment/(\d+)/fileupload/$', account.enrollment_fileupload, name='enrollment_fileupload'),

    # path('sales_dashboard', account),
]

