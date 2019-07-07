from django.shortcuts import render

# Create your views here.

def index(req):

    return render(req,"base.html", locals())




def student(req):
    student_list = ['习近平','施伟','浩辰','正文']

    return render(req,"student02.html",locals())

def teacher(req):
    teacher_list = ['习近平', '施伟', '浩辰', '正文']
    return render(req,"teacher.html",locals())

def course(req):

    return render(req,"course.html",locals())

def classes(req):

    return render(req,"classes.html",locals())