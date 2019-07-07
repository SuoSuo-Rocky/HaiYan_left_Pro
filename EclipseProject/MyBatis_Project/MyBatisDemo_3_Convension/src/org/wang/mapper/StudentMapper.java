package org.wang.mapper;

import java.util.List;

import org.wang.entity.Student;

// 操作的 MyBatis 的接口
public interface StudentMapper {
	/*
	 * 1. 方法名 和 mapper.xml 文件 中标签 的id 值 相同
	 * 2. 方法的 形参 和  mapper.xml 文件中 标签的 parameterType 类型一致
	 * 3. 方法的返回值  和 mapper.xml 文件中  标签 的 resultType  类型一致。
	 *   
	 */
	  //查询一个
	 Student queryStudentByStuno(int stuno);
	 //增加
	  void  addStudent(Student student);
	  //删除
	  void deleteStudentByStuno(int id);
	  // 更新
	  void updateStudentByStuno(Student student);
	  // 查询所有 学生
	  List<Student>  queryAllStudents();
	  
	  
	  //使用了类型转换器根据 stuNo 查询学生
	  Student queryStudentByStunoWithConverter(int stuno);
	  
      //使用类型转换器 增加 学生
	  void addStudentWithConverter(Student student);
}
