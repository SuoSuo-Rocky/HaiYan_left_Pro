

# -*- coding: utf-8 -*-
import scrapy
class IncrementDataItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    author = scrapy.Field()
    content = scrapy.Field()
