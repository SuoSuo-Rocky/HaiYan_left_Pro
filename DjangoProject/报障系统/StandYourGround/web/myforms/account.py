
from django import forms
from django.forms import fields
from django.forms import widgets

from django.core.validators import RegexValidator
from django.core.exceptions import ValidationError,NON_FIELD_ERRORS

class RegisterForm(forms.Form):
    #
    username = fields.CharField(
        widget=widgets.TextInput(attrs={'placeholder': '用户名'}),
        max_length=16,
        min_length=6,
        required=True,                                      #  在 {6,16} 要加一个 '.'
        validators=[RegexValidator(r'^[a-zA-Z0-9_-](?=.*[a-zA-Z]).{6,16}$', '4到16位 字母 数字 下划线 减号'), ],  # 自定义验证规则
        error_messages={
            'required': "用户名不能为空",
            'max_length': '长度不得超过 16 位',
            'min_length': '长度不得低于 6 位',
            'invalid': '用户名输入无效，可能包含非法字符',
        }
   )
     # strip=True,    # EmailField 字段没有这个属性，谢了报错
    email = fields.EmailField(
        widget=widgets.EmailInput(attrs={"placeholder":'邮箱'}),
        max_length=64,
        min_length=10,
        required=True,
        validators=[RegexValidator(r'^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$', '邮箱格式有误'), ],
        error_messages={
            'required': "邮箱不能为空",
            'max_length': '长度不得超过 64 位',
            'min_length': '长度不得低于 10 位',
            'invalid': '输入无效，请输入正确格式的邮箱地址',
        }
    )

    # RegexField 字段 必须要写 regex 属性， 不写报错
        # regex="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&?*]).{6,18}$",
    pwd = fields.CharField(
        # widget=widgets.PasswordInput(attrs={'placeholder':'密码'}),
        max_length=18,
        min_length=6,
        # validators=[mobile_validate, ],
        error_messages={
            'required': '密码不能为空',
            'max_length': '长度不得超过 18 位',
            'min_length': '长度不得低于 6 位',
            'invalid': '输入无效，可能包含非法字符,至少1个大写字母，1个小写字母，1个数字，1个特殊字符',
        }
    )

        # regex="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&?*]).{6,18}$",
    # validators = [RegexValidator(r'^[0-9]+$', 'Enter a valid extension.', 'invalid')], )
    r_pwd = fields.CharField(
        # widget=widgets.PasswordInput(attrs={'placeholder': '确认密码'}),
        max_length=18,
        min_length=6,
        # validators=[mobile_validate, ],
        error_messages={
            'required': '确认密码不能为空',
            'max_length': '长度不得超过 18 位',
            'min_length': '长度不得低于 6 位',
            'invalid': '输入无效，可能包含非法字符 至少1个大写字母 1个小写字母 1个数字 1个特殊字符',
        }
    )
    # img = fields.FileField(
    #     widget=widgets.FileInput(attrs={'placeholder': 't头像'}),
    #     required=True,
    #     allow_empty_file=False,
    #     max_length=500,
    #     error_messages={
    #         'required': '头像不可为空',
    #         'max_length': '长度不得超过 18 位',
    #         'invalid': '非法格式',
    #     }
    # )
    validate = fields.CharField(
        required=True,
        max_length=4,
        error_messages={
            'required': '验证码不可为空',
            'invalid': '输入非法',
        }
    )
    isfree = fields.CharField(
        widget=widgets.CheckboxInput(),
        required=False,

    )

    # 局部钩子
    def clean_username(self):
        print('I love you ')
        val=self.cleaned_data.get("username")
        val = str(val)
        print('type_username==',val)
        if not val.isdigit():
            return val
        else:
            raise ValidationError("用户名不能是纯数字!")  # 错误存放在 form_self.errors

    # 局部钩子
    def clean_pwd(self):
        print('I love you =================pwd')
        val=self.cleaned_data.get("pwd")
        val = str(val)
        print('type_pwd==',val)
        if not val.isdigit():
            return val
        else:
            raise ValidationError("密码不能是纯数字!")  # 错误存放在 form_self.errors



    # 全局钩子

    def clean(self):
        pwd=self.cleaned_data.get("pwd")
        r_pwd=self.cleaned_data.get("r_pwd")

        if pwd==r_pwd:
            return self.cleaned_data
        else:
            # 抛异常， 只能是这个异常
            raise ValidationError('两次密码不一致!') # 错误保存至 ： form_self.errors.get("__all__")
                                                    # 或form_self.errors.get("NON_FIELD_ERRORS")


class LoginForm(forms.Form):
    username = fields.CharField(
        max_length=32,
        widget=widgets.TextInput(attrs={'class':'form-control', 'placeholder': '用户名'}),
        required=True,
        error_messages={
            'invalid': '输入无效',
            'required': '用户名不可为空'
        }
    )
    password = fields.CharField(
        widget=widgets.PasswordInput(attrs={'class': 'form-control', 'placeholder': '密码'}),
        max_length=32,
        required=True,
        error_messages={
            'invalid': '密码输入无效',
            'required': '密码不可为空',
        }
    )

    validate = fields.CharField(
        widget=widgets.PasswordInput(attrs={'class': 'form-control vali', 'placeholder': '验证码'}),
        required=True,
        max_length=4,
        error_messages={
            'required': '验证码不可为空',
            'invalid': '输入非法',
        }
    )
    isfree = fields.CharField(
        widget=widgets.CheckboxInput(),
        required=False,

    )
