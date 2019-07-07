from django.shortcuts import render

# Create your views here.

data = ["shiwei施伟%s"% s for s in range(1,300)]

pagedata = 1
def index(request):
    global pagedata
    action = request.GET.get("action")
    if action == "previous":
        if pagedata != 1:
            page_date = pagedata - 1
    elif pagedata == "next":
        if pagedata != 10:
            page_date = pagedata + 1
    print("page_date:",page_date)
    pagedata = page_date
    page_count = 10
    # page_data = request.GET.get("p")
    start = (page_date-1)*page_count
    end = page_date * page_count



    data_list = data[start:end]


    return  render(request,"index.html",{"page_list":data_list})