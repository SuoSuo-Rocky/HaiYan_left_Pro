# -*- coding: utf-8 -*-
import scrapy
from selenium import webdriver

"""
    在 Scrapy  中 使用selenium de 编码流程:
        - 在 spider 中 的构造方法中创建一个浏览器的对象(作为当前spider  的一个属性)
        - 重写 spider 的 一个方法 closed(self,spider), 在该方法中执行浏览器关闭的操作
        - 在下载中间件的 process_response(self,response,spider)方法zhong，通过spider 获得浏览器对象
        - 在中间件的 process_response(.....)方法中定制基于浏览器自动化的操作代码(获取动态加载的页面源码数据)
        - 实例化 一个响应对象 HtmlResponse，且将 selenium 返回的页面源码 page_source 封装到 此对象中
        - 最后 在 Spider 的 回调函数 parse(....)中解析 响应数据 
    
    """

class WangyiSpider(scrapy.Spider):
    name = 'wangyi'
    # allowed_domains = ['www.xxx.com']
    start_urls = ['https://war.163.com/']
    def __init__(self):
        self.browser = webdriver.Chrome(executable_path=r'E:\Scrapy__Project\day_139_self_code\wangyiPro\chromedriver.exe')

    def parse(self, response):
        #  注意 此  class 属性值有一个 空格
        div_list = response.xpath('//div[@class="data_row news_article clearfix "]')
        for div in div_list:
            title = div.xpath('./div/div[1]/h3/a/text()').extract_first()
            print(title)

    def closed(self,spider):
        print('关闭 浏览器对象')
        self.browser.quit()

