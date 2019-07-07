from django.db import models

# Create your models here.
class Author(models.Model):
    aid = models.AutoField(max_length=50,primary_key=True)
    name = models.CharField(max_length=100,verbose_name="姓名")
    age = models.IntegerField(verbose_name="年龄")  # 不加 max_length 参数
    authorDetail = models.OneToOneField(to="AuthorDetail",on_delete=models.CASCADE,related_name="expand")
    def __str__(self):
        return self.name


class AuthorDetail(models.Model):
    birthday = models.DateTimeField(max_length=50,verbose_name="生日")
    qq = models.BigIntegerField(verbose_name="腾讯QQ")   # 不加 max_length 参数
    addr = models.CharField(max_length=50,verbose_name="联系地址")

    def __str__(self):
        return str(self.id)


class Publisher(models.Model):
    pid = models.AutoField(max_length=100,primary_key=True)
    name = models.CharField(max_length=100)
    city = models.CharField(max_length=100)
    email = models.EmailField(max_length=100)
    def __str__(self):
        return self.name


class Book(models.Model):
    bid = models.AutoField(max_length=50,primary_key=True)
    title = models.CharField(max_length=100)
    price = models.DecimalField(max_digits=8,decimal_places=3)
    publishDate = models.DateField(max_length=50)

    publisher = models.ForeignKey(to="Publisher",on_delete=models.CASCADE,related_name="pu_name")
    authors = models.ManyToManyField(to="Author",related_name="au_name")
    def __str__(self):
        return self.title



# class Book(models.Model):
#     bid = models.AutoField(max_length=50,primary_key=True)
#     title = models.CharField(max_length=100)
#     price = models.DecimalField(max_digits=8,decimal_places=3)
#     publisher = models.ForeignKey(to="Publisher",on_delete=models.CASCADE,related_name="pub_name")
#     authors = models.ManyToManyField(to="Author",through="Book_Authors",through_fields=("bid","aid"))
#
#
# class Book_Authors(models.Model):
#     bid = models.ForeignKey(to="Book",on_delete=models.CASCADE)
#     aid = models.ForeignKey(to="Author",on_delete=models.CASCADE)




