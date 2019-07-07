from django.db import models

# Create your models here.
class Course(models.Model):
    title = models.CharField(max_length=100,verbose_name="课程名")
    hours = models.IntegerField(verbose_name="课时")
    stus = models.ManyToManyField("Student")
    def __str__(self):
        return self.title

class Teacher(models.Model):
    name = models.CharField(max_length=100,verbose_name="姓名")
    age = models.IntegerField(verbose_name="年龄")
    graduate = models.CharField(max_length=100, verbose_name="毕业院校")
    course = models.ForeignKey("Course", on_delete=models.CASCADE)
    def __str__(self):
        return self.name

class Student(models.Model):
    name = models.CharField(max_length=100,verbose_name="姓名")
    age = models.IntegerField(verbose_name="年龄")
    gender = models.BooleanField(choices=((0, False), (1, True)),verbose_name="性别")
    born_date = models.DateField(max_length=100)
    def __str__(self):
        return self.name




