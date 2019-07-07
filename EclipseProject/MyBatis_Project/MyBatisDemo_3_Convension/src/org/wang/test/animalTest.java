package org.wang.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.wang.entity.Animal;
import org.wang.mapper.AnimalMapper;

public class animalTest {
	
	
//	 使用  ResultMap 
	public static void queryAllAnimalWithResMap() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("conf.xml");
		SqlSessionFactory  factory = new  SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		AnimalMapper mapper = session.getMapper(AnimalMapper.class);
		
		List<Animal> map = mapper.queryAllAnimalWithResMap();
		System.out.println(map);
		
		
		
	}
	
	
//	 使用 HashMap
	public static void queryAnimalByIdWithHashMap() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("conf.xml");
		SqlSessionFactory  factory = new  SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		AnimalMapper mapper = session.getMapper(AnimalMapper.class);
		
		Animal animal = mapper.queryAnimalByIdWithHashMap(100);
		System.out.println(animal);
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
//		queryAllAnimalWithResMap();
		queryAnimalByIdWithHashMap();
		
	}
	

}
