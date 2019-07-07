#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = alex_rocky.viewsCBV.py
# __date__   = 2019/4/15  17:40
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from django.shortcuts import render,HttpResponse,redirect

from django.views import View

class CBV(View):
    def get(self,request):
        return render(request,"CBV_Demo01.html",locals())

    def post(self,request):
        return HttpResponse("post")



