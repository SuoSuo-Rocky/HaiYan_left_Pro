package org.wang.mapper;

import java.util.List;

import org.wang.entity.Student;

// ������ MyBatis �Ľӿ�
public interface StudentMapper {
	/*
	 * 1. ������ �� mapper.xml �ļ� �б�ǩ ��id ֵ ��ͬ
	 * 2. ������ �β� ��  mapper.xml �ļ��� ��ǩ�� parameterType ����һ��
	 * 3. �����ķ���ֵ  �� mapper.xml �ļ���  ��ǩ �� resultType  ����һ�¡�
	 *   
	 */
	  //��ѯһ��
	 Student queryStudentByStuno(int stuno);
	 //����
	  void  addStudent(Student student);
	  //ɾ��
	  void deleteStudentByStuno(int id);
	  // ����
	  void updateStudentByStuno(Student student);
	  // ��ѯ���� ѧ��
	  List<Student>  queryAllStudents();
	  
	  
	  //ʹ��������ת�������� stuNo ��ѯѧ��
	  Student queryStudentByStunoWithConverter(int stuno);
	  
      //ʹ������ת���� ���� ѧ��
	  void addStudentWithConverter(Student student);
}
