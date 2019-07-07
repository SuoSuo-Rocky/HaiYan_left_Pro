package org.wei.entity;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatis {
	public static void main(String[] args) throws Exception {
		// ���� MyBatis �����ļ��� ��Ϊ�˷������ݿ⣩

		Reader	reader = Resources.getResourceAsReader("conf.xml");

		// SqlSessionFactory ---
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		// �൱����ǰ �� connection
		SqlSession session = factory.openSession();
		/*
		 * ִ�� SQL ��� �� ���裺 1. �ҵ� Mapper �ļ���ͨ�����е�<mapper>�� namespace +<select> ��
		 * id
		 */
		
			String statement = "org.wei.entity.personMapper.queryPersonById";
			Person person = session.selectOne(statement, 1);
			System.out.println(person);
			session.close();

		

	}

}
