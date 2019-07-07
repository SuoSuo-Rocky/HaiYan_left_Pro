from django.contrib import admin

from shiwei import models


# Register your models here.


class courseConf(admin.ModelAdmin):
    list_display = ("id","title", "hours",)
    list_editable = ("title","hours",)
    filter_horizontal = ("stus",)

    # list_per_page = 3
    search_fields = ("id","title","hours","stus")

    list_filter = ("title","hours",)
    ordering = ("id","hours")

class stuConf(admin.ModelAdmin):
    list_display = ("id","name","age","gender","born_date")
    list_editable = ("name","age","gender","born_date",)
    search_fields = ("name",)

class teaConf(admin.ModelAdmin):
    list_display = ("id","name","age","graduate","course")
    list_editable = ("name","age","graduate","course")

admin.site.register(models.Course,courseConf)
admin.site.register(models.Student,stuConf)
admin.site.register(models.Teacher,teaConf)





























