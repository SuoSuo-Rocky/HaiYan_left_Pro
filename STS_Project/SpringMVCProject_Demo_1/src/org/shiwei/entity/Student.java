package org.shiwei.entity;

public class Student {

	// �¼ӵ�
	// @Past // ��ǰʱ����ǰ

	// @NumberFormat(pattern="###,#")
	private int id;
	private String name;
	private int age;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name,int age) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

//	private Address address;

	/*
	 * @Past
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private Date birthday;
	 */

	/*
	 * @Email private String email;
	 */

	/*
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public Date getBirthday() { return birthday; }
	 * 
	 * public void setBirthday(Date birthday) { this.birthday = birthday; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public Address getAddress() { return address; } public void
	 * setAddress(Address address) { this.address = address; }
	 */
/*
	@Override
	public String toString() {
		return "���Ϊ��" + this.id + "\t����Ϊ��" + this.name + "\t����Ϊ��" + this.age;
	}*/

}
