# Generated by Django 2.1.3 on 2019-05-05 11:48

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('repository', '0002_auto_20190505_0826'),
    ]

    operations = [
        migrations.AlterField(
            model_name='user',
            name='create_time',
            field=models.DateTimeField(auto_now_add=True, verbose_name='创建时间'),
        ),
        migrations.AlterField(
            model_name='user',
            name='img',
            field=models.FileField(null=True, upload_to='static/img/user_img', verbose_name='头像'),
        ),
        migrations.AlterField(
            model_name='user',
            name='nickname',
            field=models.CharField(max_length=36, null=True, verbose_name='昵称'),
        ),
        migrations.AlterField(
            model_name='user',
            name='uid',
            field=models.IntegerField(auto_created=True, primary_key=True, serialize=False, verbose_name='用户ID'),
        ),
    ]
