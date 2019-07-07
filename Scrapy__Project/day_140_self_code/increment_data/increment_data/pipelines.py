
# -*- coding: utf-8 -*-
from redis import Redis
#####################  注意  ########################
"""
    在这里 向 redis 的列表中 lpush 字典时 ，则python  中 redis 的版本需要为 2.10.6,否则报错
        pip3 install redis==2.10.6
"""
class IncrementDataPipeline(object):
    conn = Redis(host='127.0.0.1', port=6379)
    def process_item(self, item, spider):
        dic = {
            'author': item['author'],
            'content': item['content'],
        }
        self.conn.lpush('qiubai_data',dic)
        print('爬取到一条数据， 正在入库')
        return item

