from django.shortcuts import render

# Create your views here.
from shiwei.models import  *

def video(request,*args,**kwargs):
    condition = {
        # 'classification_id':1,
        # 'level_id':2,
    }


    for k,v in kwargs.items():
        temp = int(v)
        kwargs[k] = temp
        if temp != 0:
            condition[k] = temp

    class_list = Classification.objects.all()
    level_list = Level.objects.all()
    status_list = Video.status_choice
    # status_list = list(map(lambda x:{'id':x[0],'name':x[1]},Video.status_choice))

    video_list = Video.objects.filter(**condition)

    return render(request,'video.html',{
        'class_list': class_list,
        'level_list': level_list,
        'kwargs':kwargs,
        'video_list':video_list,
        'status_list':status_list,
    })


def video2(request,*args,**kwargs):
    condition = {}
    for k,v in kwargs.items():
        temp = int(v)
        kwargs[k] = temp
    direction_id = int(kwargs.get('direction_id'))
    classification_id = int(kwargs.get('classification_id'))
    level_id = int(kwargs.get('level_id'))
    status = int(kwargs.get('status'))



    direction_list = Direction.objects.all()
    level_list = Level.objects.all()

    if direction_id == 0:
        class_list = Classification.objects.all()
        if classification_id == 0:
            pass
        else:
            condition['classification_id'] = classification_id
    else:
        direction_obj = Direction.objects.filter(id=direction_id).first()
        class_list = direction_obj.classification.all()
        v = direction_obj.classification.all().values_list('id')
        if not v:
            v_list = []
        else:
            # 方案 一:
            # v_list = list(map(lambda s:s[0],v))
            # print('v_list==',v_list)
            # 方案 二:
            v_list = list(zip(*v))[0]
            print('v_list==',v_list)
        if classification_id == 0:
            condition['classification_id__in'] = v_list
        else:
            if classification_id in v_list:
                condition['classification_id'] = classification_id
            else:  #  分类非法
                # 改变当前 kwargs['classification_id'] ,避免之后一直使用错的 classification_id
                kwargs['classification_id'] = 0
                condition['classification_id__in'] = v_list
    if level_id != 0:
        condition['level_id'] = level_id
    if status != 0:
        condition['status'] = status

    video_list = Video.objects.filter(**condition)  # 根据 查询字典 来查询 视频
    status_list = Video.status_choice

    return render(request,'video2.html',{
        'kwargs':kwargs,
        'direction_list':direction_list,
        'class_list': class_list,
        'level_list':level_list,
        'status_list':status_list,
        'video_list':video_list,
    })











