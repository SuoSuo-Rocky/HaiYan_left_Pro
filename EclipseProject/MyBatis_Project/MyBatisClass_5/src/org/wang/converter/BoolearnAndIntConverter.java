package org.wang.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class BoolearnAndIntConverter extends BaseTypeHandler<Boolean> {
	
	/*
	 * ps:  PreparedStatement ����
	 * i :  PreparedStatement ������� ������ λ�� 
	 * parameter : java ֵ 
	 * jdbcType: jdbc ������  ���ݿ� ����
	 */
	// java(boolearn) ���� �� DB (number)
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter){
			ps.setInt(i, 1);
		}else{
			ps.setInt(i, 0);
		}
	}
	// DB(number) ------> java(boolearn) ����
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
	/*     if(sexNum == 1){
	    	 return true;
	     }else{
	    	 return false;
	     }*/
		int sexNum = rs.getInt(columnName);
		return sexNum == 1?true:false;
	}
	// DB ------> java ����
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int sexNum = rs.getInt(columnIndex);
		return sexNum == 1?true:false;
	}
	// DB ------> java ����
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int sexNum = cs.getInt(columnIndex);
		return sexNum == 1?true:false;
	}


}
