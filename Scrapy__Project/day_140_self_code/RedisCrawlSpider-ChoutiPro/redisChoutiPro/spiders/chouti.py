# -*- coding: utf-8 -*-
import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule
from scrapy_redis.spiders import RedisCrawlSpider
from redisChoutiPro.items import RedischoutiproItem


class ChoutiSpider(RedisCrawlSpider):
    name = 'chouti'                              # 爬虫名
    # allowed_domains = ['www.xxx.com']          # 允许爬取的 域名， 分布式注释此属性
    # start_urls = ['https://dig.chouti.com//']  # 向 redis 的列表中扔入的 URL
    redis_key = 'chouti'                         # 共享 调度器 队列 的名称
    # 规则解析器
    allow = LinkExtractor(allow=r'/all/hot/recent/\d+')
    """
     link_extractor: 分页的 URL 的 正则匹配 提取规则
     callback: 回调函数
     follow: 是否让 链接解析器  迭代提取链接
    """
    # 链接解析器
    rules = (
        Rule(link_extractor=allow, callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        div_list = response.xpath('//div[@class="item"]')
        for div in div_list:
            item = RedischoutiproItem()
            content = div.xpath('./div[4]/div[1]/a/text()').extract_first()
            author = div.xpath('./div[4]/div[2]/a[4]/b/text()').extract_first()
            item['content'] = content
            item['author'] = author
            yield item  #  默认是 原生的 Scrapy 管道，
