package org.wang.entity;

public class Course {
	private String courseName;
	private int courseHour;
	// ������ʦ��
	private Teacher teacher;  
	
	
	public Course() {
		
		}
	
	
	public Course(  Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void showinfo() {
		System.out.println(this.courseName + "," + this.courseHour +  "," + this.teacher.getName() );
	}
	
  
}
