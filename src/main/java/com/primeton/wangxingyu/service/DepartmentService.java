package com.primeton.wangxingyu.service;

import com.github.pagehelper.PageInfo;
import com.primeton.wangxingyu.entity.Department;

/**
 * 组织机构service接口
 * 
 * @author wangxingyu
 *
 */
public interface DepartmentService {
	/**
	 * 添加部门
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	public Department insertDepartment(Department department) throws Exception;

	/**
	 * 根据部门id查询组织机构信息
	 * 
	 * @param dep_id
	 * @return
	 * @throws Exception
	 */

	public Department SelectDepById(Integer dep_id) throws Exception;

	/**
	 * 根据部门id查询部门信息以及下级组织机构
	 * 
	 * @param dep_id
	 * @return
	 * @throws Exception
	 */
	public Department selectDepDetail(Integer dep_id) throws Exception;

	/**
	 * 分页查询组织机构信息信息
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Department> selectDepartment(String dep_name, Integer pageNum, Integer pageSize) throws Exception;

	/**
	 * 根据id删除组织机构
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteDepById(Integer dep_id) throws Exception;

	/**
	 * 根据组织机构id修改组织机构信息
	 * 
	 * @param integer
	 * @return
	 * @throws Exception
	 */
	public Department updateDepById(Department department) throws Exception;

}
