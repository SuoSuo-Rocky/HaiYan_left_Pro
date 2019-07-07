from django.shortcuts import render,HttpResponse,redirect
from django.core.paginator import Paginator,EmptyPage,PageNotAnInteger
from shiwei import models

USER_LIST = ["shiwei施伟%s"% s for s in range(1,200)]


class CustomPaginator(Paginator):
    def __init__(self, current_page, every_page_num, *args,**kwargs):
        # print("dffffffffffffffffffffffffffffffffffffffffffffffffffff")
        # print("args:",args,"kwargs:",kwargs)
        self.current_page = int(current_page)
        self.every_page_num = int(every_page_num)
        # super(CustomPaginator,self).__int__(*args,**kwargs)
        super(CustomPaginator, self).__init__(*args, **kwargs)
    def num_list(self):
        if self.num_pages <= self.every_page_num:
            return range(1,self.num_pages+1)

        part = int(self.every_page_num/2)
        # 页数特别多
        if self.current_page <= part:
            return range(1,self.every_page_num+1)
        if self.current_page + part >= self.num_pages:
            return range(self.num_pages-self.every_page_num+1,self.num_pages+1)
        return range(self.current_page-part,self.current_page+part+1)

# class CustomPaginator(Paginator):
#     def __init__(self,num,*args,**kwargs):
#         print("dffffffffffffffffffffffffffffffffffffffffffffffffffff")
#         print("num:",num)
#         print("args:",args,"kwargs:",kwargs)
#         # self.current_page = int(current_page)
#         # self.every_page_num = int(every_page_num)
#         # super(CustomPaginator,self).__int__(*args,**kwargs)
#         # super(CustomPaginator,self).__init__(*args, **kwargs)
#         super(CustomPaginator,self).__init__(*args,**kwargs)
#         # Paginator.__init__(*args,**kwargs)


def index(request):
    current_page = request.GET.get("p")
    current_page = int(current_page)
    paginator = CustomPaginator(current_page,10,USER_LIST,10)
    try:
        pages = paginator.page(current_page)
    except PageNotAnInteger:
        pages = paginator.page(1)
    except EmptyPage:
        pages = paginator.page(paginator.num_pages)
    return render(request,"index.html",locals())

































