package com.primeton.wangxingyu.entity;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Department", description = "组织机构实体类")
public class Department {
	/**
	 * 组织机构id
	 */
	private Integer dep_id;
	/**
	 * 组织机构名称
	 */
	private String dep_name;
	/**
	 * 下级组织机构id
	 */
	private Integer dep_xjId;
	/**
	 * 下级组织机构名称
	 */
	private String dep_xjName;
	/**
	 * user实体类1对多关系
	 */
	private List<User> user;

	public Integer getDep_id() {
		return dep_id;
	}

	public void setDep_id(Integer dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public Integer getDep_xjId() {
		return dep_xjId;
	}

	public void setDep_xjId(Integer dep_xjId) {
		this.dep_xjId = dep_xjId;
	}

	public String getDep_xjName() {
		return dep_xjName;
	}

	public void setDep_xjName(String dep_xjName) {
		this.dep_xjName = dep_xjName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Department(Integer dep_id, String dep_name, Integer dep_xjId, String dep_xjName, List<User> user) {
		super();
		this.dep_id = dep_id;
		this.dep_name = dep_name;
		this.dep_xjId = dep_xjId;
		this.dep_xjName = dep_xjName;
		this.user = user;
	}

	public Department(int i, String string, int j, String string2) {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dep_name=" + dep_name + ", dep_xjId=" + dep_xjId + ", dep_xjName="
				+ dep_xjName + ", user=" + user + "]";
	}

	public Department(Integer dep_id, String dep_name, Integer dep_xjId, String dep_xjName) {
		super();
		this.dep_id = dep_id;
		this.dep_name = dep_name;
		this.dep_xjId = dep_xjId;
		this.dep_xjName = dep_xjName;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

}
