from django.db import models

# Create your models here.

class Img(models.Model):
    src = models.FileField(max_length=100,verbose_name="图片地址",upload_to='static/upload')
    title = models.CharField(verbose_name='图片标题',max_length=100)
    summary = models.CharField(verbose_name='图片简介',max_length=600)
    class Meta:
        verbose_name_plural='收藏图片'
        db_table="img"
    def __str__(self):
        return self.title


