package com.mymodel.course;

import java.io.UnsupportedEncodingException;

public class CodeConvert {
	public String toISO8859(String str){
		if(str == null){
			str = "";
		}
		try {
			str = new String(str.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			str = "";
		}
		return str;
	}

}
