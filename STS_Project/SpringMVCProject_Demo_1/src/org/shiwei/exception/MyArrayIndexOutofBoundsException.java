package org.shiwei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//此类自定义 异常  页面, 继承 Exception 类 
@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="这是数组越界了呀！  ")
public class MyArrayIndexOutofBoundsException  extends Exception{  }
