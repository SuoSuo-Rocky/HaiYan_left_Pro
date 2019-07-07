#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = template_lesson.my_tags.py 
# __date__   = 2019/4/8  19:03
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------

from django import template
from django.utils.safestring import mark_safe

register = template.Library()   #register的名字是固定的,不可改变


@register.filter
def filter_multi(x,y):
    return x * y