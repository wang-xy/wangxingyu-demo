package com.primeton.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.primeton.dao.DepartmentMapper;
import com.primeton.entity.Department;
import com.primeton.exception.DemoException;

/**
 * 组织机构实现类
 * 
 * @author wangxingyu
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceimpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	/**
	 * 添加组织机构信息
	 * 
	 * @param department
	 *            组织机构信息
	 * @return 添加后的部门信息
	 * @throws ServiceException
	 */
	@Override
	@Transactional
	public Department insertDepartment(Department department) throws Exception {

		Department selectDepById = departmentMapper.selectDepById(department.getDep_id());
		// 判断接收到的组织机构名称是否为空
		if (selectDepById != null) {
			// 如果不是 抛出自定义异常： 组织机构名称不能重复
			throw new DemoException(DemoException.PUT_DEPO_FAILED, "组织机构名称不能重复");
		}
		// 如果是，则添加组织机构信息并返回
		departmentMapper.insertDepartment(department);
		return department;
	}

	/**
	 * 根据id查询组织机构信息
	 * 
	 * @param dep_id
	 *            组织机构id
	 * @return 组织机构信息
	 * @throws ServiceException
	 */
	// 根据id查询组织机构信息
	@Override
	@Transactional
	public Department SelectDepById(Integer dep_id) throws Exception {
		Department selectDepById = departmentMapper.selectDepById(dep_id);
		// 判断接收到的组织机构id是否为空
		if (selectDepById == null) {
			// 如果是空的话，抛出自定义异常：id不存在
			throw new DemoException(DemoException.PUT_ID_FAILED, "ID不存在");
		}
		// 如果不是，返回查询到的组织机构信息
		return selectDepById;
	}

	/**
	 * 根据部门id查询组织机构信息以及下级组织
	 * 
	 * @param dep_id
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Department selectDepDetail(Integer dep_id) throws Exception {
		// 判断接收到的的组织机构id是否为空
		Department selectDepById = departmentMapper.selectDepById(dep_id);
		Department result = departmentMapper.selectDepDetail(dep_id);
		// 判断接收到的的组织机构id是否为空
		if (selectDepById == null) {
			// 如果是空的话，抛出自定义异常：id不存在
			throw new DemoException(DemoException.PUT_ID_FAILED, "ID不存在");
		}
		// 如果不是，返回查询到的信息
		return result;

	}

	/**
	 * 分页查询组织机构信息信息
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */

	@Override
	public PageInfo<Department> selectDepartment(String dep_name, Integer pageNum, Integer pageSize) throws Exception {
		dep_name = "%" + dep_name + "%";
		// 设置起始页数默认值
		if (pageNum == null) {
			pageNum = 1;
		}
		// 设置每页条数默认值
		if (pageSize == null) {
			pageSize = 3;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Department> departments = departmentMapper.selectDepartment(dep_name);
		PageInfo<Department> pageInfo = new PageInfo<Department>(departments);
		return pageInfo;

	}

	/**
	 * 根据id删除组织
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Integer deleteDepById(Integer dep_id) throws Exception {
		Integer deleteDepById = departmentMapper.deleteDepById(dep_id);
		if (deleteDepById == 0) {
			throw new DemoException(DemoException.PUT_ID_FAILED, "ID不存在");
		}

		return deleteDepById;
	}

	/**
	 * 根据id修改组织信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	@Override
	@Transactional
	public Department updateDepById(Department department) throws Exception {
		Department selectDepById = departmentMapper.selectDepById(department.getDep_id());
		if (selectDepById == null) {
			throw new DemoException(DemoException.POST_ID_N_FAILED, "修改的组织id不存在");
		}
		departmentMapper.updateDepById(department);
		Department depById = departmentMapper.selectDepById(department.getDep_id());
		return depById;
	}

}
