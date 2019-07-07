# -*- coding: utf-8 -*-
import scrapy
from moviePro.items import MovieproItem

class MovieSpider(scrapy.Spider):
    name = 'movie'

    allowed_domains = ['4567tv.tv']
    start_urls = ['https://www.4567tv.tv/frim/index1.html']
    def parse_detail(self, response):
        #  解析详情页 的 数据
        # response.meta 接收 meta 字典
        item = response.meta['item']
        actor = response.xpath('/html/body/div[1]/div/div/div/div[2]/p[3]/a/text()').extract_first()
        item['actor'] = actor
        yield item


    def parse(self, response):
        li_list = response.xpath('//li[@class="col-md-6 col-sm-4 col-xs-3"]')
        for s in li_list:
            item = MovieproItem()
            name = s.xpath('./div/a/@title').extract_first()
            detail_url = 'https://www.4567tv.tv' + s.xpath('./div/a/@href').extract_first()
            item['name'] = name
                #  只有 这个 Request 方法 才可以帮我们 请求传参
            # meta 参数作用: 请求传参 ，是一个 字典 ，传递给 回调函数的 response 参数
            yield scrapy.Request(url=detail_url,callback=self.parse_detail,meta={'item': item})

