# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule


class ChoutiSpider(CrawlSpider):
    name = 'chouti'
    allowed_domains = ['www.xxx.com']
    start_urls = ['https://dig.chouti.com/r/scoff/hot/1']
    # 链接 提取器:
        # allow : 表示提取规则(Regex)
    link = LinkExtractor(allow=r'/r/scoff/hot/\d+')
    rules = (
        # 规则解析器作用:
            # 将链接提取器提取到的链接所对应的 页面源码数据进行指定形式的 解析，就是 回调
        # follow = True : 让 链接提取器继续作用到链接提取器提取到的链接所对应的页面中
        Rule(link, callback='parse_item', follow=True),
    )





    def parse_item(self, response):
        item = {}
        #item['domain_id'] = response.xpath('//input[@id="sid"]/@value').get()
        #item['name'] = response.xpath('//div[@id="name"]').get()
        #item['description'] = response.xpath('//div[@id="description"]').get()
        print(response)
        # return item
