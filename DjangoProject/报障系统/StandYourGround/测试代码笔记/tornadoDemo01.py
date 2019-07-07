#!/usr/bin/env python
# -*- coding:utf-8 -*-

import tornado.ioloop
import tornado.web

class MainHandler(tornado.web.RequestHandler):
    def get(self):
        self.write("Hello, world")

class LoginHandler(tornado.web.RequestHandler):
    def get(self):
        print( 'fdfdfd')
        # self.write("请登录！")
        self.render("login.html")

settings = {
    'template_path': 'template',
    'static_path': 'static',
    'static_url_prefix': '/shiwei/',  # 静态文件的前缀
}

application = tornado.web.Application([
    (r"/login.html", LoginHandler),
    (r"/", MainHandler),
],**settings)

if __name__ == "__main__":
    # 创建 Socket 对象
    # r,w,e =  select.select([socket,],)
    application.listen(8888)
    tornado.ioloop.IOLoop.instance().start()
