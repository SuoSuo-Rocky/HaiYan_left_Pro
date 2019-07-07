package org.wang.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class test {

	
	// ����ѧ�ţ� ��ѯѧ��
	public static void queryStudentByStuno(int id) throws Exception {
		// Connection --------SqlSession,��Ҫǰ�ö��������
		// �� conf.xml �����ļ� ���뵽�ڴ���ȥ
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -----> SqlSession
		// ����ͨ�� build �ĵڶ������� ��ǿ�� ָ�� ���ݿ�� ����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.queryStudentByStuno";
		Student student = session.selectOne(statement, 1);

		System.out.println(student);
		session.close();

	}
  // ��ѯ����ѧ��
	public static void queryAllStudents() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.queryAllStudents";
		List<Student> student = session.selectList(statement);

		System.out.println(student);
		
		session.close();

	}
	
	//����ѧ��
	public static void addStudent() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.addStudent";
		Student student = new Student(106,"wangwu",123456,"sishiban");
		int count = session.insert(statement, student);
		System.out.println("������" + count + "��ѧ��");
		
		// û���ύ �Ͳ��� ���� ����
		session.commit();
		session.close();
		
	}

	//�޸�ѧ����Ϣ
	public static void  updateStudentByStuno() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.updateStudentByStuno";
		Student student = new Student(100,"7777",7777,"7777");
		int count = session.update(statement, student);
		System.out.println("�޸���" + count + "��ѧ��");
		
		// û���ύ �Ͳ��� ���� ����
		session.commit();
		session.close();
	}
	
	
	// ɾ��ѧ��
	public static  void deleteStudentByStuno() throws IOException{
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		String statement = "org.wang.entity.studentMapper.deleteStudentByStuno";
		int count = session.delete(statement, 106);
		System.out.println("ɾ����" + count + "��ѧ��");
		
		// û���ύ �Ͳ��� ���� ����
		session.commit();
		session.close();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		queryAllStudents();
		queryStudentByStuno(10);
		queryAllStudents();
	}
	
	

}
