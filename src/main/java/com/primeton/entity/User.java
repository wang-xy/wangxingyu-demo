package com.primeton.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "User", description = "用户信息")
public class User {
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private String age;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 组织id
	 */
	private Integer did;
	/**
	 * 组织机构实体类，多对1关系
	 */
	private Department department;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User(Integer uid, String userName, String userPassword, String name, String age, String sex, Integer did,
			Department department) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userPassword = userPassword;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.did = did;
		this.department = department;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", userPassword=" + userPassword + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + ", did=" + did + ", department=" + department + "]";
	}

}
