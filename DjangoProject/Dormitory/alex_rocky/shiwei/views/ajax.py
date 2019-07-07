from django.shortcuts import render,HttpResponse,redirect

from shiwei.models import *

from django.views import View
class ajax_delstudent(View):
    def get(self,request):
        msg = "成功"
        try:
            nid = request.GET.get("nid")
            Student.objects.filter(id = nid).delete()
        except Exception as e:
            msg = str(e)
        return HttpResponse(msg)

    def post(self,request):
        pass