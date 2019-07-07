# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule
from redis import Redis
from increment1_Pro.items import Increment1ProItem


class MovieSpider(CrawlSpider):
    name = 'movie'
    # allowed_domains = ['www.xxx.com']
    start_urls = ['https://www.4567tv.tv/index.php/vod/show/class/%E6%81%90%E6%80%96/id/9.html']

    rules = (
        Rule(LinkExtractor(allow=r'/index.php/vod/show/class/%E6%81%90%E6%80%96/id/9/page/\d+\.html'), callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        conn = Redis(host='127.0.0.1',port=6379)

        detail_url_list ='https://www.4567tv.tv' + response.xpath('//li[@class="col-md-6 col-sm-4 col-xs-3"]/div/a/@href')

        for url in detail_url_list:
            # ex 若 为 1 ，表示 为新数据
            ex = conn.sadd('movies_url',url)
            if ex == 1:
                yield  scrapy.Request(url=url,callback=self.self.parse_detail)
            else:
                print("此站<%s>无更新数据，暂无新数据可爬"%url)

    def parse_detail(self,response):
        item = Increment1ProItem()
        item['name'] = response.xpath('//div[@class="stui-content__detail"]/h1/text()').extract_first()
        item['actor'] = response.xpath('/html/body/div[1]/div/div/div/div[2]/p[3]/a/text()').extract_first()

        yield item

