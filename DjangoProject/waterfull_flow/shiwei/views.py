from django.shortcuts import render

# Create your views here.
from shiwei.models import *
def imgs(request):
    img_list = Img.objects.all()
    return render(request,'imgs.html',locals())