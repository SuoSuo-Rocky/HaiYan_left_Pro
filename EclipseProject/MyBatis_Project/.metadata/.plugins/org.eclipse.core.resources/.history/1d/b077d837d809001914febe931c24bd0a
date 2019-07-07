package org.wang.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.wang.entity.Mouse;
import org.wang.entity.MouseClass;
import org.wang.mapper.MouseMapper;

public class MouseTest {
	
	public static void queryClassAndMouses() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		 MouseMapper mapper = session.getMapper(MouseMapper.class);
		 
		 MouseClass mouseClass = mapper.queryClassAndMouses(100);
		 List<Mouse> mouses = mouseClass.getMouses();
		 
		 for(Mouse mouse:mouses){
			 System.out.println(mouse);
		 }
		 
	}
	

	public static void main(String[] args) throws IOException {
		queryClassAndMouses();
		
	}
	
}
