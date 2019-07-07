#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = alex_rocky.ajax.py 
# __date__   = 2019/4/17  18:12
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------

from django.shortcuts import render, HttpResponse,redirect
from django.views import View
from shiwei.models import *

class ajax(View):
    def get(self,request):
        msg = "成功"
        try:
            nid = request.GET.get("nid")
            obj = Student.objects.filter(id = nid).delete()
        except Exception as e:
            msg = str(e)
        return HttpResponse(msg)

    def post(self):
        pass

