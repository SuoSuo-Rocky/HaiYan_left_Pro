

# -*- coding: utf-8 -*-
from redis import Redis
class Increment1ProPipeline(object):
    def open_spider(self,spider):
        self.conn=Redis(host='127.0.0.1',port=6379)

    def process_item(self, item, spider):
        # dic = {
        #     'name': item['name'],
        #     'actor': item['actor'],
        # }
        print('正在入库！')
        self.conn.lpush('movie_data',item)
        return item

