# Generated by Django 2.1.3 on 2019-04-29 05:14

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Img',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('src', models.CharField(max_length=100, verbose_name='图片地址')),
                ('title', models.CharField(max_length=100, verbose_name='图片标题')),
                ('summary', models.CharField(max_length=600, verbose_name='图片简介')),
            ],
            options={
                'verbose_name_plural': '收藏图片',
                'db_table': 'img',
            },
        ),
    ]
