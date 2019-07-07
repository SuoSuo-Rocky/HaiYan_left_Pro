# Generated by Django 2.1.3 on 2019-05-01 03:20

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Blog',
            fields=[
                ('bid', models.IntegerField(primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=100, verbose_name='标题')),
                ('summary', models.CharField(max_length=200, verbose_name='简介')),
                ('ctime', models.DateField(verbose_name='博客创建时间')),
                ('main_class', models.IntegerField(choices=[(0, '全部'), (1, 'Python'), (2, 'Linux'), (3, 'OpenStack'), (4, 'GoLang')], verbose_name='首页分类')),
            ],
            options={
                'verbose_name_plural': '博客',
                'db_table': 'Blog',
            },
        ),
        migrations.CreateModel(
            name='blog_tag',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('bid', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='repository.Blog', verbose_name='博客ID')),
            ],
            options={
                'verbose_name_plural': '博客所属标签',
                'db_table': 'blog_tag',
            },
        ),
        migrations.CreateModel(
            name='BlogDetail',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('blog_img', models.FileField(max_length=200, upload_to='static/img/blog_img', verbose_name='博客图片')),
                ('detail', models.CharField(max_length=2000, verbose_name='详细')),
            ],
            options={
                'verbose_name_plural': '博客内容详细',
                'db_table': 'BlogDetail',
            },
        ),
        migrations.CreateModel(
            name='Discuss',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('content', models.CharField(max_length=200, verbose_name='评论内容')),
                ('ctime', models.DateField(max_length=100, verbose_name='评论时间')),
                ('bid', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='repository.Blog', verbose_name='博客ID')),
            ],
            options={
                'verbose_name_plural': '评论',
                'db_table': 'Discuss',
            },
        ),
        migrations.CreateModel(
            name='Self_class',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('caption', models.CharField(max_length=100, verbose_name='分类名')),
            ],
            options={
                'verbose_name_plural': '分类',
                'db_table': 'Self_class',
            },
        ),
        migrations.CreateModel(
            name='sp_tread',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('type', models.IntegerField(choices=[(0, False), (1, True)])),
                ('bid', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='repository.Blog', verbose_name='博客ID')),
            ],
            options={
                'verbose_name_plural': '赞和踩',
                'db_table': 'sp_tread',
            },
        ),
        migrations.CreateModel(
            name='Tag',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('caption', models.CharField(max_length=50, verbose_name='标签名')),
            ],
            options={
                'verbose_name_plural': '标签',
                'db_table': 'Tag',
            },
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('uid', models.IntegerField(primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=32, verbose_name='姓名')),
                ('pwd', models.CharField(max_length=32, verbose_name='密码')),
                ('email', models.EmailField(max_length=32, verbose_name='邮箱')),
                ('img', models.FileField(upload_to='static/img/user_img', verbose_name='头像')),
            ],
            options={
                'verbose_name_plural': '用户',
                'db_table': 'user',
            },
        ),
        migrations.AddField(
            model_name='tag',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='uid_tag', to='repository.User', verbose_name='博主ID'),
        ),
        migrations.AddField(
            model_name='sp_tread',
            name='uid',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='repository.User', verbose_name='用户ID'),
        ),
        migrations.AddField(
            model_name='self_class',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='uid_class', to='repository.User', verbose_name='博主ID'),
        ),
        migrations.AddField(
            model_name='discuss',
            name='uid',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='repository.User', verbose_name='用户ID'),
        ),
        migrations.AddField(
            model_name='blog_tag',
            name='tid',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='repository.Tag', verbose_name='标签ID'),
        ),
        migrations.AddField(
            model_name='blog',
            name='detail',
            field=models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, related_name='blogDetail', to='repository.BlogDetail'),
        ),
        migrations.AddField(
            model_name='blog',
            name='self_class',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='class_blog', to='repository.Self_class', verbose_name='所属个人分类'),
        ),
        migrations.AddField(
            model_name='blog',
            name='tag',
            field=models.ManyToManyField(related_name='tag_blog', through='repository.blog_tag', to='repository.Tag', verbose_name='所属个人标签'),
        ),
        migrations.AlterUniqueTogether(
            name='sp_tread',
            unique_together={('bid', 'uid')},
        ),
        migrations.AlterUniqueTogether(
            name='blog_tag',
            unique_together={('bid', 'tid')},
        ),
    ]
