from django.contrib import admin

# Register your models here.
from repository import models

@admin.register(models.User)
class user(admin.ModelAdmin):
    list_display = ('uid','username','pwd','email','img','nickname')
    list_editable = ('username','pwd','email','img','nickname')

@admin.register(models.UserInfo)
class userinfo(admin.ModelAdmin):
    list_display = ('uiid','title','site','theme','user')
    list_editable = ('title','site','theme','user')

@admin.register(models.UserFans)
class userfans(admin.ModelAdmin):
    list_display = ('id','user','follower')
    list_editable = ('user','follower')

@admin.register(models.Self_class)
class self_class(admin.ModelAdmin):
    list_display = ('id','user','caption','user')
    list_editable = ('user','caption')

@admin.register(models.Tag)
class tag(admin.ModelAdmin):
    list_display = ('id','user','caption')
    list_editable = ('user','caption')


@admin.register(models.Blog)
class blog(admin.ModelAdmin):
    list_display = ('bid','title','summary','ctime','main_class','self_class','detail')
    list_editable = ('title','summary','ctime','main_class','self_class','detail')

@admin.register(models.BlogDetail)
class blogDetail(admin.ModelAdmin):
    list_display = ('id','blog_img','detail')
    list_editable = ('blog_img','detail')

@admin.register(models.sp_tread)
class support_tread(admin.ModelAdmin):
    list_display = ('id','type','uid','bid')
    list_editable = ('type',)

@admin.register(models.Discuss)
class discuss(admin.ModelAdmin):
    list_display = ('id','content','ctime')
    list_editable = ('content','ctime')

@admin.register(models.blog_tag)
class blog_tag(admin.ModelAdmin):
    list_display = ('id','bid','tid')
    list_editable = ("bid",'tid')









