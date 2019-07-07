from django.contrib import admin

from shiwei import models


class Dir(admin.ModelAdmin):
    list_display = ('id','name',)
    list_editable = ('name',)

class Cla(admin.ModelAdmin):
    list_display = ('id','name',)
    list_editable = ('name',)

class level(admin.ModelAdmin):
    list_display = ('id','title',)
    list_editable = ('title',)

class video(admin.ModelAdmin):
    list_display = ('id','title','status','weight','summary','img','href',)
    list_editable = ('title','status','weight','summary','img','href',)

admin.site.register(models.Direction,Dir)
admin.site.register(models.Classification,Cla)
admin.site.register(models.Level,level)
admin.site.register(models.Video,video)