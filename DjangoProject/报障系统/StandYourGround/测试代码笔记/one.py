# import requests
#
# import re
# import json
#
#
# def getPage(url):
#     response = requests.get(url)
#     return response.text
#
#
# def parsePage(s):
#     com = re.compile(
#         '<div class="item">.*?<div class="pic">.*?<em .*?>(?P<id>\d+).*?<span class="title">(?P<title>.*?)</span>'
#         '.*?<span class="rating_num" .*?>(?P<rating_num>.*?)</span>.*?<span>(?P<comment_num>.*?)评价</span>', re.S)
#
#     ret = com.finditer(s)
#     for i in ret:
#         yield {
#             "id": i.group("id"),
#             "title": i.group("title"),
#             "rating_num": i.group("rating_num"),
#             "comment_num": i.group("comment_num"),
#         }
#
#
# def main(num):
#     url = 'https://movie.douban.com/top250?start=%s&filter=' % num
#     response_html = getPage(url)
#     ret = parsePage(response_html)
#     print(ret)
#     f = open("move_info7", "a", encoding="utf8")
#
#     for obj in ret:
#         print(obj)
#         data = json.dumps(obj, ensure_ascii=False)
#         f.write(data + "\n")
#
#
# if __name__ == '__main__':
#     count = 0
#     for i in range(10):
#         main(count)
#         count += 25
















import requests
import re

session = requests.session()

# 第一步：访问登陆页,拿到X_Anti_Forge_Token，X_Anti_Forge_Code
# 1、请求url:https://passport.lagou.com/login/login.html
# 2、请求方法:GET
# 3、请求头:
#    User-agent
r1 = session.get('https://passport.lagou.com/login/login.html',
                 headers={
                     'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
                 },
                 )

X_Anti_Forge_Token = re.findall("X_Anti_Forge_Token = '(.*?)'", r1.text, re.S)[0]
X_Anti_Forge_Code = re.findall("X_Anti_Forge_Code = '(.*?)'", r1.text, re.S)[0]
# print(X_Anti_Forge_Token,X_Anti_Forge_Code)

# 第二步：登陆
# 1、请求url:https://passport.lagou.com/login/login.json
# 2、请求方法:POST
# 3、请求头:
#    cookie
#    User-agent
#    Referer:https://passport.lagou.com/login/login.html
#    X-Anit-Forge-Code:53165984
#    X-Anit-Forge-Token:3b6a2f62-8import requests
# import re
#
# session = requests.session()
#
# # 第一步：访问登陆页,拿到X_Anti_Forge_Token，X_Anti_Forge_Code
# # 1、请求url:https://passport.lagou.com/login/login.html
# # 2、请求方法:GET
# # 3、请求头:
# #    User-agent
# r1 = session.get('https://passport.lagou.com/login/login.html',
#                  headers={
#                      'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#                  },
#                  )
#
# X_Anti_Forge_Token = re.findall("X_Anti_Forge_Token = '(.*?)'", r1.text, re.S)[0]
# X_Anti_Forge_Code = re.findall("X_Anti_Forge_Code = '(.*?)'", r1.text, re.S)[0]
# # print(X_Anti_Forge_Token,X_Anti_Forge_Code)
#
# # 第二步：登陆
# # 1、请求url:https://passport.lagou.com/login/login.json
# # 2、请求方法:POST
# # 3、请求头:
# #    cookie
# #    User-agent
# #    Referer:https://passport.lagou.com/login/login.html
# #    X-Anit-Forge-Code:53165984
# #    X-Anit-Forge-Token:3b6a2f62-80f0-428b-8efb-ef72fc100d78
# #    X-Requested-With:XMLHttpRequest
# # 4、请求体：
# # isValidate:true
# # username:18611453110
# # password:70621c64832c4d4d66a47be6150b4a8e
# # request_form_verifyCode:''
# # submit:''
# r2 = session.post('https://passport.lagou.com/login/login.json',
#                   headers={
#                       'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#                       'Referer': 'https://passport.lagou.com/login/login.html',
#                       'X-Anit-Forge-Code': X_Anti_Forge_Code,
#                       'X-Anit-Forge-Token': X_Anti_Forge_Token,
#                       'X-Requested-With': 'XMLHttpRequest'
#                   },
#                   data={
#                       "isValidate": True,
#                       'username': '18611453110',
#                       'password': '70621c64832c4d4d66a47be6150b4a8e',
#                       'request_form_verifyCode': '',
#                       'submit': ''
#                   }
#                   )
# # 第三步：授权
# # 1、请求url:https://passport.lagou.com/grantServiceTicket/grant.html
# # 2、请求方法:GET
# # 3、请求头:
# #    User-agent
# #    Referer:https://passport.lagou.com/login/login.html
#
# r3 = session.get('https://passport.lagou.com/grantServiceTicket/grant.html',
#                  headers={
#                      'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#                      'Referer': 'https://passport.lagou.com/login/login.html',
#                  }
#                  )
#
# # 第四步：验证
# r4 = session.get('https://www.lagou.com/resume/myresume.html',
#                  headers={
#                      'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#                  }
#                  )
#
# # print('18611453110' in r4.text)
#
#
# # 第五步：筛选职位信息
# # 请求url：https://www.lagou.com/jobs/list_java%E9%AB%98%E7%BA%A7%E5%BC%80%E5%8F%91
# # 请求方法：GET
# # 请求头：
# # User-Agent
# # 请求参数：
# # gj:3年及以下
# # px:default
# # yx:25k-50k
# # city:北京
# from urllib.parse import urlencode
#
# res = urlencode({'k': 'java高级开发'}, encoding='utf-8').split('=')[-1]
# url = 'https://www.lagou.com/jobs/list_' + res
# #
# # r5 = session.get(url,
# #                  headers={
# #                      'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
# #                  },
# #                  params={
# #                      'gj': '3年及以下',
# #                      'px': 'default',
# #                      'yx': '25k-50k',
# #                      'city': '北京'
# #                  }
# #                  )
# #
# # print(r5.text)
#
# #请求url：https://www.lagou.com/jobs/positionAjax.json
# #请求方法：POST
# #请求头
# #    Referer
# #    User-Agent
# #请求体：
#     # first:true
#     # pn:1
#     # kd:java高级开发
# #请求参数
# # params={
# #      'gj': '3年及以下',
# #      'px': 'default',
# #      'yx': '25k-50k',
# #      'city': '北京',
# #     'needAddtionalResult':False,
# #     'isSchoolJob':0
# # }
# r6=session.post('https://www.lagou.com/jobs/positionAjax.json',
#              headers={
#                     'Referer':url,
#                      'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#
#              },
#              data={
#                  'first':True,
#                  'pn':2,
#                  'kd':'java高级开发'
#              },
#              params={
#                  'gj': '3年及以下',
#                  'px': 'default',
#                  'yx': '25k-50k',
#                  'city': '北京',
#                  'needAddtionalResult': False,
#                  'isSchoolJob': 0
#              }
#              )
#
#
# from pprint import pprint
# # print(r6.json())
# comapines_list=r6.json()['content']['positionResult']['result']
# for comapiny in comapines_list:
#     positionId=comapiny['positionId']
#     company_link='https://www.lagou.com/jobs/{pos_id}.html'.format(pos_id=positionId)
#     companyShortName = comapiny['companyShortName']
#     positionName = comapiny['positionName']
#     salary = comapiny['salary']
#     print('''
#     详情连接:%s
#     公司名：%s
#     职位名：%s
#     薪资：%s
#     ''' %(company_link,companyShortName,positionName,salary))
#
#
#     #第七步：访问详情页，拿到X_Anti_Forge_Token，X_Anti_Forge_Code
#     # 请求url：详情页地址
#     # 请求方式：GET
#     # 请求头：User-Agent
#     r7=session.get(company_link,
#                 headers={
#                     'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#                 }
#                 )
#     X_Anti_Forge_Token = re.findall("X_Anti_Forge_Token = '(.*?)'", r7.text, re.S)[0]
#     X_Anti_Forge_Code = re.findall("X_Anti_Forge_Code = '(.*?)'", r7.text, re.S)[0]
#     # print(X_Anti_Forge_Token,X_Anti_Forge_Code)
#
#
#     #第八步：投递简历
#     #请求url：https://www.lagou.com/mycenterDelay/deliverResumeBeforce.json
#     #请求方式：POST
#     #请求头：
#         #Referer:详情页地址
#         #User-agent
#         #X-Anit-Forge-Code:53165984
#         #X-Anit-Forge-Token:3b6a2f62-80f0-428b-8efb-ef72fc100d78
#         #X-Requested-With:XMLHttpRequest
#     #请求体：
#     # positionId:职位ID
#     # type:1
#     # force:true
#
#     session.post('https://www.lagou.com/mycenterDelay/deliverResumeBeforce.json',
#                  headers={
#                      'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
#                      'Referer': company_link,
#                      'X-Anit-Forge-Code': X_Anti_Forge_Code,
#                      'X-Anit-Forge-Token': X_Anti_Forge_Token,
#                      'X-Requested-With': 'XMLHttpRequest'
#                  },
#                  data={
#     'positionId':positionId,
#     'type':1,
#     'force':True
#                  }
#                  )
#     print('%s 投递成功' %(companyShortName))