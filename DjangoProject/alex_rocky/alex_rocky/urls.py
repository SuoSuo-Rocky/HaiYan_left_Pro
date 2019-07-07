"""alex_rocky URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django.conf.urls import url

from shiwei.views import student
from shiwei import viewsCBV

from shiwei.views import  ajax

urlpatterns = [
    path('admin/', admin.site.urls),
    url(r'show_student.html$',student.show_student),
    url(r'del_student.html$',student.del_student),
    url(r'add_student.html$',student.add_student),
    url(r'repeat_add$',student.repeat_add),
    url(r'edit_student.html$',student.edit_student),
    url(r'submit_edit$',student.submit_edit),

    path('CBV/',viewsCBV.CBV.as_view()),
    url(r'ajax.html$',ajax.ajax.as_view()),




]
