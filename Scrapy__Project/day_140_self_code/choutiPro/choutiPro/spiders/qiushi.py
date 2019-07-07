# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule


class QiushiSpider(CrawlSpider):
    name = 'qiushi'
    # allowed_domains = ['www.xxx.com']
    start_urls = ['https://www.qiushibaike.com/pic/']
    link = LinkExtractor(allow=r'/pic/page/\d+\?s=')
    rules = (
        Rule(link, callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        item = {}
        #item['domain_id'] = response.xpath('//input[@id="sid"]/@value').get()
        #item['name'] = response.xpath('//div[@id="name"]').get()
        #item['description'] = response.xpath('//div[@id="description"]').get()
        print(response)
        return item
