from django.contrib import admin

# Register your models here.
from shiwei import models

class author(admin.ModelAdmin):
    list_display = ("aid","name","age",)
    list_editable = ("name","age",)  #  不可加 one 键
    search_fields = ("aid","name","age")

class authorDetail(admin.ModelAdmin):
    list_display = ("id","birthday","qq","addr")
    list_editable = ("birthday","qq","addr")
    search_fields = ("birthday","qq","addr")


class books(admin.ModelAdmin):
    list_display = ("bid","title","price","publishDate","publisher")  # 不可加 多键
    list_editable = ("title","price","publishDate","publisher",) # 不可加 多键
    search_fields = ("title","price","publishDate")

class publisher(admin.ModelAdmin):
    list_display = ("pid","name","city","email")
    list_editable = ("name","city","email")
    search_fields = ("name","city","email")



admin.site.register(models.Author,author)
admin.site.register(models.AuthorDetail,authorDetail)
admin.site.register(models.Book,books)
admin.site.register(models.Publisher,publisher)
