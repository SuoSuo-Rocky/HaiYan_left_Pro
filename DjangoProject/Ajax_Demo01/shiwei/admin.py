from django.contrib import admin

from shiwei import models


# Register your models here.


class courseConf(admin.ModelAdmin):
    list_display = ("id","title", "hours",)
    list_editable = ("title","hours",)


    # list_per_page = 3
    search_fields = ("id","title","hours","stus")

    list_filter = ("title","hours",)
    ordering = ("id","hours")

class stuConf(admin.ModelAdmin):
    list_display = ("id","name","gender",)
    list_editable = ("name","gender",)
    search_fields = ("name",)
    filter_horizontal = ("courses",)

class teaConf(admin.ModelAdmin):
    list_display = ("id","name","graduate","course")
    list_editable = ("name","graduate","course")

admin.site.register(models.Course,courseConf)
admin.site.register(models.Student,stuConf)
admin.site.register(models.Teacher,teaConf)


