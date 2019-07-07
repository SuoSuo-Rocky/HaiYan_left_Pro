"""Special_Ajax URL Configuration

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
from shiwei import views

urlpatterns = [
    path('admin/', admin.site.urls),
    url(r'index.html$',views.index),

    url(r'ajaxDemo01.html$',views.ajaxDemo01),
    url(r'native01.html$',views.native01),

    url(r'ajaxDemo02.html$',views.ajaxDemo02),
    url(r'native02.html$',views.native02),

    url(r'iframe_form/',views.iframe_form),

    url(r'ajaxfile.html$',views.ajaxfile),
    url(r'ajaxupload',views.ajaxUpload),
    url(r'iframe_form_file',views.iframe_form_file),
    
    
    
    url(r'blog_one.html$',views.blog),

    url(r'native_ajax_demo.html$',views.native_demo),
    url(r'jquery_ajax_demo.html$',views.jquery_ajax_demo),
    url(r'jsonp_ajax_demo.html$',views.jsonp_ajax_demo),

]
