#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = ProfectCRM_SuoSuo03.rest_views.py 
# __date__   = 2019/6/29  19:27
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from rest_framework import viewsets

from repository.models import UserProfile, Role

# 第二步 ： 交给 他 去序列化
from repository.rest_serializer import UserSerializer, RoleSerializer


class UserViewSet(viewsets.ModelViewSet):
    queryset = UserProfile.objects.all()
    serializer_class = UserSerializer

class RoleViewSet(viewsets.ModelViewSet):
    queryset = Role.objects.all()
    serializer_class = RoleSerializer
