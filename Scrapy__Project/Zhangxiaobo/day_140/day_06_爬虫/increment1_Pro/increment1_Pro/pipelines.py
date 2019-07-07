# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

from redis import Redis
class Increment1ProPipeline(object):
    conn = None
    def open_spider(self,spider):
        self.conn = Redis(host='127.0.0.1',port=6379)
    def process_item(self, item, spider):
        # dic = {
        #     'name':item['name'],
        #     'axtor':item['actor']
        # }
        print('有新数据被爬取到,正在入库......')
        self.conn.lpush('movie_data',item)
        return item
