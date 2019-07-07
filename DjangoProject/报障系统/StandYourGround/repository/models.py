from django.db import models

# Create your models here.
class User(models.Model):
    uid = models.AutoField(primary_key=True, verbose_name='用户ID')
    username = models.CharField(max_length=32, verbose_name='姓名', unique=True)
    pwd = models.CharField(max_length=32, verbose_name='密码')
    email = models.EmailField(max_length=32, verbose_name='邮箱')
    img = models.FileField(max_length=100, verbose_name='头像', upload_to='static/img/user_img',null=True)
    nickname = models.CharField(max_length=36, verbose_name='昵称',null=True)   # new                # new
    create_time = models.DateTimeField(verbose_name='创建时间',auto_now_add=True)   # new ,auto_now_add=True
    class Meta:
        verbose_name_plural='用户'
        db_table='user'
    def __str__(self):
        return self.username


class UserInfo(models.Model):                          # new
    uiid = models.IntegerField(verbose_name='博主ID', primary_key=True)
    title = models.CharField(verbose_name='个人主站标题',max_length=100)
    site = models.CharField(max_length=100,verbose_name='个人主站前缀',unique=True)
    theme = models.CharField(max_length=100,verbose_name='个人主站主题')
    user = models.ForeignKey(to='User',to_field='uid',on_delete=models.CASCADE, related_name='user_info')
    class Meta:
        verbose_name_plural='个人主站信息'
        db_table='userinfo'
    def __str__(self):
        return self.site





class UserFans(models.Model):                         # new
    """
    互粉关系表
    """
    user = models.ForeignKey(to='User',verbose_name='博主',to_field='uid',on_delete=models.CASCADE,related_name='love_user')
    follower = models.ForeignKey(to='User',verbose_name='粉丝',to_field='uid',on_delete=models.CASCADE,related_name='fan_user')
    class Meta:
        verbose_name_plural='互粉关系'
        unique_together=[
            ('user', 'follower'),
        ]
        db_table='userfans'
    def __str__(self):
        return self.user.username



class Self_class(models.Model):
    # choice_type = [
    #     (0, '全部'),
    #     (1, 'Python'),
    #     (2, 'Linux'),
    #     (3, 'C#'),
    #     (4, 'Java'),
    #     (5, 'Android'),
    # ]
    user = models.ForeignKey('User',on_delete=models.CASCADE,verbose_name='博主ID',related_name='uid_class')
    caption = models.CharField(verbose_name='分类名', max_length=100)
    class Meta:
        verbose_name_plural='分类'
        db_table='Self_class'
        unique_together=[
            ('user','caption'),
        ]               # new
    def __str__(self):
        return self.caption

class Tag(models.Model):
    user = models.ForeignKey('User', on_delete=models.CASCADE, verbose_name='博主ID',related_name='uid_tag')
    caption = models.CharField(max_length=50,verbose_name='标签名')
    class Meta:
        db_table='Tag'
        verbose_name_plural='标签'
        unique_together = [
            ('user', 'caption'),
        ]                 #  new
    def __str__(self):
        return self.caption


class Blog(models.Model):
    bid = models.IntegerField(verbose_name='ID',primary_key=True)
    title = models.CharField(max_length=100,verbose_name='标题')
    summary = models.CharField(max_length=200,verbose_name='简介')
    ctime = models.DateField(verbose_name='博客创建时间') # update
    read_count = models.IntegerField(default=0,verbose_name='阅读数')      # new
    comment_count = models.IntegerField(default=0,verbose_name='评论数')   # new
    up_count = models.IntegerField(default=0,verbose_name='赞数')          # new
    down_count = models.IntegerField(default=0,verbose_name='踩数')        # new
    choice_type = [
        (0, '全部'),
        (1, 'Python'),
        (2, 'Linux'),
        (3, 'OpenStack'),
        (4, 'GoLang'),
    ]
    main_class = models.IntegerField(choices=choice_type,verbose_name='首页分类')
    self_class = models.ForeignKey('Self_class',on_delete=models.CASCADE,verbose_name='所属个人分类',related_name='class_blog')
    tag = models.ManyToManyField('Tag',verbose_name='所属个人标签',related_name='tag_blog',
                                 through='blog_tag',
                                 through_fields=('bid','tid'),)
    # user_id = models.ForeignKey('User',verbose_name='博主ID',on_delete=models.CASCADE)
    detail = models.OneToOneField('BlogDetail',related_name='blogDetail',on_delete=models.CASCADE)
    class Meta:
        verbose_name_plural='博客'
        db_table='Blog'
    def __str__(self):
        return self.title

class blog_tag(models.Model):
    bid = models.ForeignKey('Blog',verbose_name='博客ID',on_delete=models.CASCADE)
    tid = models.ForeignKey('Tag',verbose_name='标签ID',on_delete=models.CASCADE)
    class Meta:
        verbose_name_plural='博客所属标签'
        db_table='blog_tag'
        unique_together=(('bid','tid'),)
    def __str__(self):
        return str(self.id)


class BlogDetail(models.Model):
    blog_img = models.FileField(max_length=200,verbose_name='博客图片',upload_to='static/img/blog_img')
    detail = models.CharField(max_length=2000,verbose_name='详细')
    class Meta:
        verbose_name_plural='博客内容详细'
        db_table='BlogDetail'
    def __str__(self):
        return str(self.id)

class sp_tread(models.Model):
    uid = models.ForeignKey('User',on_delete=models.CASCADE,verbose_name='用户ID')
    bid = models.ForeignKey('Blog',on_delete=models.CASCADE,verbose_name='博客ID')
    type = models.IntegerField(choices=[(0, False), (1, True),])
    class Meta:
        verbose_name_plural='赞和踩'
        db_table='sp_tread'
        unique_together=(('bid','uid'),)
    def __str__(self):
        return str(self.id)

class Discuss(models.Model):
    uid = models.ForeignKey('User',verbose_name='用户ID',on_delete=models.CASCADE)
    bid = models.ForeignKey('Blog',verbose_name='博客ID',on_delete=models.CASCADE)
    content = models.CharField(max_length=200,verbose_name='评论内容')
    ctime = models.DateField(max_length=100,verbose_name='评论时间')
    # reply = models.ForeignKey(to='self',verbose_name='回复评论',related_name='back',on_delete=models.CASCADE)  # new
    class Meta:
        verbose_name_plural='评论'
        db_table='Discuss'
    def __str__(self):
        return str(self.id)




























































