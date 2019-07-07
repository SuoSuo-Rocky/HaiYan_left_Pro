# Generated by Django 2.1.3 on 2019-04-22 14:46

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Author',
            fields=[
                ('aid', models.AutoField(max_length=50, primary_key=True, serialize=False)),
                ('name', models.CharField(max_length=100)),
                ('age', models.IntegerField()),
            ],
        ),
        migrations.CreateModel(
            name='AuthorDetail',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('birthday', models.DateField(max_length=50)),
                ('qq', models.BigIntegerField()),
                ('addr', models.CharField(max_length=50)),
            ],
        ),
        migrations.CreateModel(
            name='Book',
            fields=[
                ('bid', models.AutoField(max_length=50, primary_key=True, serialize=False)),
                ('title', models.CharField(max_length=100)),
                ('price', models.DecimalField(decimal_places=3, max_digits=8)),
                ('publishDate', models.DateField(max_length=50)),
                ('authors', models.ManyToManyField(related_name='au_name', to='shiwei.Author')),
            ],
        ),
        migrations.CreateModel(
            name='Publisher',
            fields=[
                ('pid', models.AutoField(max_length=100, primary_key=True, serialize=False)),
                ('name', models.CharField(max_length=100)),
                ('city', models.CharField(max_length=100)),
                ('email', models.EmailField(max_length=100)),
            ],
        ),
        migrations.AddField(
            model_name='book',
            name='publisher',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='pu_name', to='shiwei.Publisher'),
        ),
        migrations.AddField(
            model_name='author',
            name='authorDetail',
            field=models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, related_name='expand', to='shiwei.AuthorDetail'),
        ),
    ]
