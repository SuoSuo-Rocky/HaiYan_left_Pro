from django.db import models

# Create your models here.


class Book(models.Model):
    name = models.CharField(max_length=100)
    price = models.IntegerField()
    author = models.CharField(max_length=50)
    pub_date = models.DateField()
