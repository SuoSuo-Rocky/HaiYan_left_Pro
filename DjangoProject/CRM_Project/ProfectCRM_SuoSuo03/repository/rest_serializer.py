#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = ProfectCRM_SuoSuo03.rest_serializer.py 
# __date__   = 2019/6/29  19:17
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------

# 第一步 取出数据库中的数据
from django.conf.urls import url, include
from repository import models
from rest_framework import routers, serializers, viewsets

# Serializers define the API representation.
# 继承的类为   HyperlinkedModelSerializer : 表示 关联数据展现 为 url 链接的形式
#        若为  ModelSerializer ：  关联数据 以 ID 展现
class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.UserProfile
        depth = 2         #  深度 ，展示 关联所有数据
        fields = ('url', 'email', 'name', 'is_staff','is_active','role',)


class RoleSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = models.Role
        fields = ("name",)

