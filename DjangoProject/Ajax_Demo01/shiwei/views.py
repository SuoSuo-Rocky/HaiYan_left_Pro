from django.shortcuts import render,HttpResponse

# Create your views here.
from shiwei.models import *
import json

def students(request):
    stu_list = Student.objects.all()
    # cou_list = { }
    # for i in stu_list:
    #     cou = Course.objects.filter(student=i)
    #     cou_list[i.name] = []
    #     for j in cou:
    #         cou_list[i.name].append(j)
    cou_list = Course.objects.all()
    return render(request,"students.html",locals())


def add_student(request):
    response = {"status":True,"msg":None}
    print(request.POST)
    try:
        u = request.POST.get("username")
        g = request.POST.get("gender")
        if g == 1:
            g = True;
        else:
            g = False
        cou = request.POST.get("courses")

        cou = cou[1:]
        cou_list = json.loads(cou)
        obj = Student.objects.create(name=u,gender=g)
        print("所选择的课程为:",cou_list,"类型为:",type(cou_list))
        choose = Course.objects.filter(title__in= cou_list)
        obj.courses.add(*choose)
        query_courses = Course.objects.filter(student=obj)
        print("新添加的学生为：",obj,"所选择的课程为:",query_courses)
        response["nid"] = obj.id
    except Exception as e:
        response["status"] = False
        response["msg"] = "用户输入错误"
    #    第二个参数则 为 防止 前端收到 乱码
    result = json.dumps(response,ensure_ascii=False)
    return HttpResponse(result)

def del_student(request):
    ret = {"status":True}
    try:
        nid = request.POST.get("nid")
        Student.objects.filter(id=nid).delete()
    except Exception as e:
        ret['status'] = False
    data = json.dumps(ret)
    return HttpResponse(data)


























































































