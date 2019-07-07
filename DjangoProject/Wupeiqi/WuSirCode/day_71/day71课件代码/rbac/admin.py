from django.contrib import admin
from . import models

class Menus(admin.ModelAdmin):
    list_display = ('id','caption','parent')

class URL(admin.ModelAdmin):
    list_display = ('id','url','caption','menu_id')
admin.site.register(models.Role)
admin.site.register(models.Action)
admin.site.register(models.Permission,URL)
admin.site.register(models.Permission2Action)
admin.site.register(models.Permission2Action2Role)
admin.site.register(models.User)
admin.site.register(models.User2Role)
admin.site.register(models.Menu,Menus)