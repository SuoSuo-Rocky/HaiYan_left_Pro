from django.contrib import admin

# Register your models here.
from repository.models import *
class userprofileView(admin.ModelAdmin):
    list_display = ('id', 'name', 'user', )
    list_editable = ('name', 'user',)
    list_display_links = ('id',)

class roleView(admin.ModelAdmin):
    list_display = ('id', 'name',)
    # 主键字段 不可 位于 list_editable 中， 主键 不可编辑
    list_editable = ('name',)
    list_display_links = ('id',)

class CustomerInfoView(admin.ModelAdmin):
    list_display = ('id', 'name', 'contact_type', 'contact', 'source', 'referral_from', 'consult_content', 'consultant', 'status',)
    list_editable = ('name', 'contact_type', 'contact', 'source', 'referral_from', 'consultant', 'status',)
    # 'name'的值不能同时位于'list_editable'和'list_display_link中
    list_display_links = ('id', )
    # 显示 侧边栏 过滤
    list_filter = ['name', 'contact_type', 'status', 'consultant', 'date']
    # 添加 头部 搜索框 , 注意 当有 外键字段时，需 关联 到 关联表中 的字段, 搜索需要依据
    search_fields = ('id', 'name', 'status', 'consultant__name', 'contact')

admin.site.register(UserProfile,userprofileView)
admin.site.register(Role,roleView)
admin.site.register(CustomerInfo,CustomerInfoView)




# **************************      上下 两种写法



@admin.register(Student)
class StudentView(admin.ModelAdmin):
    list_display = ('id', 'customer',)
    list_editable = ('customer',)

@admin.register(CustomerFollowUp)
class CustomerFollowUpView(admin.ModelAdmin):
    list_display = ('id', 'customer', 'content', 'user', 'status','date')
    #  list_editable 中不可 有 DateField 字段
    list_editable = ('customer', 'content', 'user', 'status',)

@admin.register(Course)
class CourseView(admin.ModelAdmin):
    list_display = ('id', 'name', 'price', 'perid', 'outline')
    list_editable = ('name', 'price', 'perid', 'outline')

@admin.register(ClassList)
class ClassListView(admin.ModelAdmin):
    list_display = ('id', 'branch', 'course', 'class_type', 'semester', 'start_date', 'graduate_date')
    list_editable = ('branch', 'course', 'class_type', 'semester', 'start_date', 'graduate_date')

@admin.register(CourseRecord)
class CourseRecordView(admin.ModelAdmin):
    list_display = ('id', 'class_grade', 'day_num', 'teacher', 'title', 'content', 'has_homework', 'homework', 'date')
    #  list_editable 中不可 有 DateTimeField 字段
    list_editable = ('class_grade', 'day_num', 'teacher', 'title', 'content', 'has_homework', 'homework',)

@admin.register(StudyRecord)
class StudyRecordView(admin.ModelAdmin):
    list_display = ('id', 'course_record', 'score', 'show_status', 'note','date',)
    list_editable = ('course_record', 'score', 'show_status', 'note')

@admin.register(Branch)
class BranchView(admin.ModelAdmin):
    list_display = ('id', 'name', 'addr')
    list_editable = ('name', 'addr')

@admin.register(Menus)
class MenusView(admin.ModelAdmin):
    list_display = ('id', 'name', 'url_type', 'url_name')
    list_editable = ('name', 'url_type', 'url_name')





