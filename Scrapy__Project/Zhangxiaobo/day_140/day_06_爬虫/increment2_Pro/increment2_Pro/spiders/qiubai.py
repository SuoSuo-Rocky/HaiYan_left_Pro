# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule

from increment2_Pro.items import Increment2ProItem
from redis import Redis
import hashlib
class QiubaiSpider(CrawlSpider):
    name = 'qiubai'
    # allowed_domains = ['www.xxx.com']
    start_urls = ['https://www.qiushibaike.com/text/']

    rules = (
        Rule(LinkExtractor(allow=r'/text/page/\d+/'), callback='parse_item', follow=True),
    )

    def parse_item(self, response):

        div_list = response.xpath('//div[@class="article block untagged mb15 typs_hot"]')
        conn = Redis(host='127.0.0.1',port=6379)
        for div in div_list:
            item = Increment2ProItem()
            item['content'] = div.xpath('.//div[@class="content"]/span//text()').extract()
            item['content'] = ''.join(item['content'])
            item['author'] = div.xpath('./div/a[2]/h2/text() | ./div[1]/span[2]/h2/text()').extract_first()
            source = item['author']+item['content']
            #自己制定了一种形式的数据指纹
            hashValue = hashlib.sha256(source.encode()).hexdigest()

            ex = conn.sadd('qiubai_hash',hashValue)
            if ex == 1:
                yield item
            else:
                print('没有更新数据可爬!!!')

