package org.shiwei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//�����Զ��� �쳣  ҳ��, �̳� Exception �� 
@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="��������Խ����ѽ��  ")
public class MyArrayIndexOutofBoundsException  extends Exception{  }
