#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __date__   = 2019/5/8  10:25
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------

from django.shortcuts import render, HttpResponse, redirect
from django.http import JsonResponse
from django.views import View
from repository.models import  *
import json
# 设置 没登录成功 ， 则跳转到 登录页面
#  登录失败的情况下访问 ：
            #    http://192.168.0.104:9999/accounts/login/?next=/shiwei/
from django.contrib.auth.decorators import login_required

@login_required   # 登录失败 ， 则在 settings 中配置
def dashboard(request):



    return render(request,'shiwei/dashboard.html',)


@login_required
def table_obj_list(request,app_name,model_name):
    """  取出 指定 表中的数据 返回 到前端  """
    pass



