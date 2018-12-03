package com.primeton.wangxingyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.primeton.wangxingyu.entity.Department;

/**
 * 组织机构Mapper接口
 * 
 * @author wangxingyu
 */
@Mapper
public interface DepartmentMapper {
	/**
	 * 添加组织机构
	 * 
	 * @param department
	 * @return
	 */
	public Integer insertDepartment(Department department);

	/**
	 * 根据id查询组织机构信息和下级组织信息想
	 * 
	 * @param integer
	 * @return
	 */
	public Department selectDepById(Integer integer);

	/**
	 * 根据组织机构id查询组织机构信息和关联的员工信息
	 * 
	 * @param dep_id
	 * @return
	 */
	public Department selectDepDetail(Integer dep_id);

	/**
	 * 分页查询组织机构信息
	 * 
	 * @param userName
	 * @param pageIndex
	 *            起始页数
	 * @param pageSize
	 *            每页条数
	 * @return 用户数据
	 * @throws Exception
	 */

	public List<Department> selectDepartment(String dep_name);

	/**
	 * 根据用户id删除用户
	 * 
	 * @param dep_id
	 * @return
	 */
	public Integer deleteDepById(Integer dep_id);

	/**
	 * 根据id修改用户信息
	 * 
	 * @param department
	 * @return
	 */
	public int updateDepById(Department department);

}
