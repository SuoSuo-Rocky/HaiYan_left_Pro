package org.wang.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class test {

	
	// 根据学号， 查询学生
	public static void queryStudentByStuno(int id) throws Exception {
		// Connection --------SqlSession,需要前置对象来获得
		// 将 conf.xml 配置文件 读入到内存中去
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -----> SqlSession
		// 可以通过 build 的第二个参数 来强制 指定 数据库的 环境
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.queryStudentByStuno";
		Student student = session.selectOne(statement, 1);

		System.out.println(student);
		session.close();

	}
  // 查询所有学生
	public static void queryAllStudents() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.queryAllStudents";
		List<Student> student = session.selectList(statement);

		System.out.println(student);
		
		session.close();

	}
	
	//增加学生
	public static void addStudent() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.addStudent";
		Student student = new Student(106,"wangwu",123456,"sishiban");
		int count = session.insert(statement, student);
		System.out.println("增加了" + count + "个学生");
		
		// 没有提交 就不会 更新 数据
		session.commit();
		session.close();
		
	}

	//修改学生信息
	public static void  updateStudentByStuno() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.updateStudentByStuno";
		Student student = new Student(100,"7777",7777,"7777");
		int count = session.update(statement, student);
		System.out.println("修改了" + count + "个学生");
		
		// 没有提交 就不会 更新 数据
		session.commit();
		session.close();
	}
	
	
	// 删除学生
	public static  void deleteStudentByStuno() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.deleteStudentByStuno";
		int count = session.delete(statement, 106);
		System.out.println("删除了" + count + "个学生");
		
		// 没有提交 就不会 更新 数据
		session.commit();
		session.close();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		queryAllStudents();
		queryStudentByStuno(10);
		queryAllStudents();
	}
	
	

}
