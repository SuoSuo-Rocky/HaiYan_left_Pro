# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule


class ChoutiSpider(CrawlSpider):
    # name = 'chouti'
    # # allowed_domains = ['www.xxx.com']
    # start_urls = ['https://dig.chouti.com/r/scoff/hot/1']
    #
    # #连接提取器:
    # #allow:表示的就是链接提取器提取连接的规则(正则)
    # link = LinkExtractor(allow=r'/r/scoff/hot/\d+')
    #
    # rules = (
    #     #规则解析器:将链接提取器提取到的连接所对应的页面数据进行指定形式的解析
    #     Rule(link, callback='parse_item', follow=True),
    #     # 让连接提取器继续作用到链接提取器提取到的连接所对应的页面中
    # )
    #
    # def parse_item(self, response):
    #     print(response)

    name = 'qiubai'
    # allowed_domains = ['www.xxx.com']
    start_urls = ['https://www.qiushibaike.com/pic/']

    # 连接提取器:
    # allow:表示的就是链接提取器提取连接的规则(正则)/pic/page/3?s=5172496
    link = LinkExtractor(allow=r'/pic/page/\d+\?s=\d+')
    link1 = LinkExtractor(allow=r'/pic/$')
    # link1 = LinkExtractor(allow=r'')
    rules = (
        # 规则解析器:将链接提取器提取到的连接所对应的页面数据进行指定形式的解析
        Rule(link, callback='parse_item', follow=True),
        # 让连接提取器继续作用到链接提取器提取到的连接所对应的页面中

        Rule(link1, callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        print(response)
