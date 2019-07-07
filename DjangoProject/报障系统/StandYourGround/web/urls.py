
from django.conf.urls import url
from web import home
urlpatterns = [
    url(r'register.html$', home.register),
    url(r'^login.html$', home.login),
    url(r'^(?P<site>\w+).html$', home.master),
    url(r'^(?P<site>\w+)/(?P<kind>((class)|(tag)|(date)))/(?P<cid>\w+)', home.master_son),
    # url(r'^(?P<si>)')
    url(r'^', home.index),
]