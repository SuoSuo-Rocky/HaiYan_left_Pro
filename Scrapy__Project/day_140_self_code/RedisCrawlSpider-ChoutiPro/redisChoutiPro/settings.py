# -*- coding: utf-8 -*-

# Scrapy settings for RedisCrawlSpider-ChoutiPro project
#
# For simplicity, this file contains only settings considered important or
# commonly used. You can find more settings consulting the documentation:
#
#     https://doc.scrapy.org/en/latest/topics/settings.html
#     https://doc.scrapy.org/en/latest/topics/downloader-middleware.html
#     https://doc.scrapy.org/en/latest/topics/spider-middleware.html




# Configure maximum concurrent requests performed by Scrapy (default: 16)
#CONCURRENT_REQUESTS = 32

# Configure a delay for requests for the same website (default: 0)
# See https://doc.scrapy.org/en/latest/topics/settings.html#download-delay
# See also autothrottle settings and docs
#DOWNLOAD_DELAY = 3
# The download delay setting will honor only one of:
#CONCURRENT_REQUESTS_PER_DOMAIN = 16
#CONCURRENT_REQUESTS_PER_IP = 16


# Disable Telnet Console (enabled by default)
#TELNETCONSOLE_ENABLED = False



# Enable or disable spider middlewares
# See https://doc.scrapy.org/en/latest/topics/spider-middleware.html
#SPIDER_MIDDLEWARES = {
#    'RedisCrawlSpider-ChoutiPro.middlewares.RedischoutiproSpiderMiddleware': 543,
#}

# Enable or disable downloader middlewares
# See https://doc.scrapy.org/en/latest/topics/downloader-middleware.html
#DOWNLOADER_MIDDLEWARES = {
#    'RedisCrawlSpider-ChoutiPro.middlewares.RedischoutiproDownloaderMiddleware': 543,
#}

# Enable or disable extensions
# See https://doc.scrapy.org/en/latest/topics/extensions.html
#EXTENSIONS = {
#    'scrapy.extensions.telnet.TelnetConsole': None,
#}

# Configure item pipelines
# See https://doc.scrapy.org/en/latest/topics/item-pipeline.html
#ITEM_PIPELINES = {
#    'RedisCrawlSpider-ChoutiPro.pipelines.RedischoutiproPipeline': 300,
#}

# Enable and configure the AutoThrottle extension (disabled by default)
# See https://doc.scrapy.org/en/latest/topics/autothrottle.html
#AUTOTHROTTLE_ENABLED = True
# The initial download delay
#AUTOTHROTTLE_START_DELAY = 5
# The maximum download delay to be set in case of high latencies
#AUTOTHROTTLE_MAX_DELAY = 60
# The average number of requests Scrapy should be sending in parallel to
# each remote server
#AUTOTHROTTLE_TARGET_CONCURRENCY = 1.0
# Enable showing throttling stats for every response received:
#AUTOTHROTTLE_DEBUG = False

# Enable and configure HTTP caching (disabled by default)
# See https://doc.scrapy.org/en/latest/topics/downloader-middleware.html#httpcache-middleware-settings
#HTTPCACHE_ENABLED = True
#HTTPCACHE_EXPIRATION_SECS = 0
#HTTPCACHE_DIR = 'httpcache'
#HTTPCACHE_IGNORE_HTTP_CODES = []
#HTTPCACHE_STORAGE = 'scrapy.extensions.httpcache.FilesystemCacheStorage'

#==>第一部分：基本配置<===

#1、项目名称，默认的USER_AGENT由它来构成，也作为日志记录的日志名
BOT_NAME = 'RedisCrawlSpider-ChoutiPro'

# 2、爬虫应用路径
SPIDER_MODULES = ['RedisCrawlSpider-ChoutiPro.spiders']
NEWSPIDER_MODULE = 'RedisCrawlSpider-ChoutiPro.spiders'

#3、客户端User-Agent请求头
USER_AGENT = 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36'

#4、是否遵循爬虫协议
ROBOTSTXT_OBEY = False

#5、是否支持cookie，cookiejar进行操作cookie，默认开启
#COOKIES_ENABLED = False

#6、Telnet用于查看当前爬虫的信息，操作爬虫等...使用telnet ip port ，然后通过命令操作
#TELNETCONSOLE_ENABLED = False
#TELNETCONSOLE_HOST = '127.0.0.1'
#TELNETCONSOLE_PORT = [6023,]

#7、Scrapy发送HTTP请求默认使用的请求头
#DEFAULT_REQUEST_HEADERS = {
#   'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
#   'Accept-Language': 'en',
#}

######  分布式 配置
# 添加 开启使用scrapy-redis组件中封装好的  共享管道
ITEM_PIPELINES = {
    'scrapy_redis.pipelines.RedisPipeline': 400
}
# 增加了一个去重容器类的配置, 作用使用Redis的set集合来存储请求的指纹数据, 从而实现请求去重的持久化
DUPEFILTER_CLASS = "scrapy_redis.dupefilter.RFPDupeFilter"  # 指定过滤器
# 使用scrapy-redis组件自己的调度器
SCHEDULER = "scrapy_redis.scheduler.Scheduler"
# 配置调度器是否要持久化, 也就是当爬虫结束了, 要不要清空Redis中请求队列和去重指纹的set。如果是True, 就表示要持久化存储, 就不清空数据, 否则清空数据
SCHEDULER_PERSIST = True   #可有可无， 数据指纹 ，对数据的唯一标识，涉及到增量式，
# 若 分布式集群 荡机 了，当再次重启继续执行分布式爬虫代码时，接着从荡机之前的位置开始爬，
# 只会爬 没有经过爬取的数据和最近更新的数据，
# 如何区分 数据是否 爬过：
    #  把 爬过的数据进行数据指纹 的设置

# 指定存储数据的  redis
REDIS_HOST = "127.0.0.1"
REDIS_PORT = 6379

# 程序执行起来时候 ， 再 向调度器中 放置 起始 URL

# 配置 redis 数据库  redis 的配置文件: redis.windows.conf
    # - 取消保护模式 ：第 75 行: protected-mode no ,
    # - bind 绑定 : 注释 第 56 行，否则只有本机才可以访问   #bind 127.0.0.1
# 启动 redis
# 服务端: redis-server.exe redis.windows.conf
# 客户端: redis-cli.exe:
"""
        keys * : 显示 db 中 所有的 数据
        flushall : 清空所有
        """

# 执行分布式 集群的代码:
        # scrapy runspider xxx.py
        # 执行之后 会发现 程序停止了， 正在等待起始 的 URL
# 向 调度器 队列中 仍入 一个 起始 的 URL:
        # 在 redis 的 客户端执行 命令: lpush key url
        # lpush chouti https://dig.chouti.com/
            # 参数解析: key : 集群爬虫代码中 redis_key 参数所对应的值
            #           url : 其实页面 的 URL

    # lrange chouti:items 0 -1 : 查看 redis 列表中 某个 key 中 所有 的 数据















