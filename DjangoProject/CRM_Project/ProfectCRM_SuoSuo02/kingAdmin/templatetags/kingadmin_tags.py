#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = ProfectCRM_SuoSuo01.kingadmin_tags.py 
# __date__   = 2019/6/6  19:15
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------
from django.template import Library
from django.utils.safestring import mark_safe
register = Library()

@register.simple_tag
def build_table_row(obj,admin_class):
    """  生成 一条 记录 的 html element  """
    ele = ''
    for column_name in admin_class.list_display:
        column_obj = admin_class.model._meta.get_field(column_name)
        if column_obj.choices:
            column_data = getattr(obj,'get_%s_display'% column_name)()
        else:
            column_data = getattr(obj,column_name)
        td_ele = "<td>%s</td>"% column_data
        ele += td_ele
    return mark_safe(ele)

