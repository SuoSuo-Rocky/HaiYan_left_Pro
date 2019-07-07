# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule
from scrapy_redis.spiders import RedisCrawlSpider
from redisChoutiPro.items import RedischoutiproItem
class ChoutiSpider(RedisCrawlSpider):
    name = 'chouti'
    # allowed_domains = ['www.xxx.com']
    # start_urls = ['http://www.xxx.com/']
    redis_key = 'chouti'#调度器队列的名称
    rules = (
        Rule(LinkExtractor(allow=r'/all/hot/recent/\d+'), callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        div_list = response.xpath('//div[@class="item"]')
        for div in div_list:
            title = div.xpath('./div[4]/div[1]/a/text()').extract_first()
            author = div.xpath('./div[4]/div[2]/a[4]/b/text()').extract_first()
            item = RedischoutiproItem()
            item['title'] = title
            item['author'] = author

            yield item
