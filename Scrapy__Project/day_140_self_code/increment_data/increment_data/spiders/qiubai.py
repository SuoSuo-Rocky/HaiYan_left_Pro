# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule
from increment_data.items import IncrementDataItem
from redis import Redis
import hashlib

class QiubaiSpider(CrawlSpider):
    name = 'qiubai'
    # allowed_domains = ['www.xx.com']
    start_urls = ['https://www.qiushibaike.com/text/']

    rules = (
        Rule(LinkExtractor(allow=r'/text/page/\d+/'), callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        div_list = response.xpath('//div[@class="article block untagged mb15 typs_hot"]')
        conn = Redis(host='127.0.0.1',port=6379)
        for div in div_list:
            item = IncrementDataItem()
            item['author'] = div.xpath('./div[1]/a[2]/h2/text() | ./div[1]/span[2]/h2/text()').extract_first()
            # item['content'] = response.xpath('./a[1]/div/span/text()').extract_first()
            item['content'] = div.xpath('.//div[@class="content"]/span/text()').extract()
            item['content'] = ''.join(item['content'])
            source = item['author'] + item['content']

            # 自定制 一种形式的 数据指纹， 是数据的唯一标识
            hashValue = hashlib.sha256(source.encode()).hexdigest()

            ex = conn.sadd("qiubai_hash",hashValue)
            if ex == 1:
                yield item
            else:
                print("此数据 已 爬")



