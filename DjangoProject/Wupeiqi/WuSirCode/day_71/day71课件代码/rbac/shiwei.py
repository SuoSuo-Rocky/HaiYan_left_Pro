#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = day71课件代码.shiwei.py 
# __date__   = 2019/5/8  12:31
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from django.shortcuts import render,HttpResponse,redirect
from django.http import JsonResponse
from rbac.models import *

def diedai(type,arg):
    ret = []
    for key,valus in enumerate(arg,0):
        son = { }
        son[type] = valus.caption
        ret.append(son)
    return ret


def create_dict(request):
    # level_one = Menu.objects.filter(parent=None)
    # type_list = ["caption","child","child-child"]
    # ret = diedai(type_list[0],level_one)
    #
    # for key,value in enumerate(level_one,0):
    #     son = Menu.objects.filter(parent=value)
    #     if son:
    #          ret[0][type_list[1]] = diedai(type_list[1],son)

    username = 'cuikai'
    ret = Permission2Action.objects.filter(permission2action2role__r__in=Role.objects.
                                           filter(user2role__u__username=username),)
    ret  = ret.values('p__url').distinct()


    menu_list = Permission2Action.objects.filter(permission2action2role__r__in=Role.objects.
                                           filter(user2role__u__username=username),).exclude(p__menu__isnull=True)
    ret  = ret.values('p__url','p__caption').distinct()

      # print('level_one=',level_one)
    for item in ret:
        print(item)

    return  HttpResponse('fdfdfd')
    # import json
    # return HttpResponse(json.dumps(ret))
    # return JsonResponse(json.dumps(ret))
