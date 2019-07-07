from django.db import models

# Create your models here.


class student(models.Model):
    name = models.CharField(max_length=100,verbose_name="姓名")
    age = models.IntegerField(verbose_name="年龄")
    def __str__(self):
        return self.name