import requests


# html = requests.get('https://www.cnblogs.com/wupeiqi/articles/6144178.html')
# print(html.text)
# check_code = 'dfdf'
for i in range(1000000000000000):
    shi = requests.post(
        url='https://passport.jd.com/new/login.aspx',
        data={'loginname':"shiwRgfdfGeifd",'nloginpwd':'123dhjdfk343',}
    )
    print(shi.text)
# 现在都用 图片做验证码，不易识别

