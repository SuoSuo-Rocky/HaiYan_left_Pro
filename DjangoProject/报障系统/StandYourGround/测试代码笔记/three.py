import requests
import re
for i in range(100000000000000000):
    try:
        #请求1:
        r1=requests.get('https://github.com/login')
        # r1=requests.get('https://passport.jd.com/new/login.aspx')
        # r1=requests.get('https://passport.suning.com/ids/login')
        # r1=requests.get('https://login.1688.com/member/signin.htm')
        r1_cookie=r1.cookies.get_dict() #拿到初始cookie(未被授权)
        authenticity_token=re.findall(r'name="authenticity_token".*?value="(.*?)"',r1.text)[0] #从页面中拿到CSRF TOKEN
        print("authenticity_token",authenticity_token)
        #第二次请求：带着初始cookie和TOKEN发送POST请求给登录页面，带上账号密码
        data={
            'commit':'Sign in',
            'utf8':'✓',
            'authenticity_token':authenticity_token,
            'login':'yuanchenqi0316@163.com',
            'password':'yuanchenqi0316'
        }

        #请求2:
        r2=requests.post('https://github.com/session',
                     data=data,
                     cookies=r1_cookie,
                     # allow_redirects=False
                     )
        print(r2.status_code)      #200
        print(r2.url)              #看到的是跳转后的页面:https://github.com/
        print(r2.history)          #看到的是跳转前的response:[<Response [302]>]
        print(r2.history[0].text)  #看到的是跳转前的response.text

        with open("result.html","wb") as f:

            f.write(r2.content)
    except Exception as f:
        print(f)