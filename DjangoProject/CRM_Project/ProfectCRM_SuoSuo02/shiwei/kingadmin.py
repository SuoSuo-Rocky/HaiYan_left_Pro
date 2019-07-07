#!/usr/bin/env python
# -*- coding: utf-8 -*-#
# __name__   = ProfectCRM_SuoSuo01.kingadmin.py 
# __date__   = 2019/6/6  12:35
# __author__ ='Shi Wei'
# __description__: 
# --------------------------------------------------------------


from kingAdmin.new_site import site
from repository import models
from kingAdmin.admin_base import BaseKingAdmin
print(' Shiwei  CRM  Admin......   ')

class CustomerAdmin(BaseKingAdmin):
    list_display = ('id', 'name', 'contact_type', 'contact', 'source', 'referral_from', 'consult_content', 'consultant', 'status',)
    list_editable = ('name', 'contact_type', 'contact', 'source', 'referral_from', 'consultant', 'status',)
    list_filter = ['name', 'contact','consultant__name']



class userprofileView(BaseKingAdmin):
    list_display = ('id', 'name', 'user', )
    list_editable = ('name', 'user',)
    list_display_links = ('id',)

class roleView(BaseKingAdmin):
    list_display = ('id', 'name',)
    # 主键字段 不可 位于 list_editable 中， 主键 不可编辑
    list_editable = ('name',)
    list_display_links = ('id',)

site.register(models.CustomerInfo,CustomerAdmin)
site.register(models.UserProfile,userprofileView)
site.register(models.Role,roleView)






