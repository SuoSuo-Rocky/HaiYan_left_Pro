from django.shortcuts import render,HttpResponse,redirect

from shiwei import models

# Create your views here.

def index(request):


    return render(request,"index.html",locals())