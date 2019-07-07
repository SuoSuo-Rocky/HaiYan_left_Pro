from django.contrib import admin
from shiwei import models
# Register your models here.
class img(admin.ModelAdmin):
    list_display = ('id','title','summary')
    list_editable = ('title','summary')

admin.site.register(models.Img,img)