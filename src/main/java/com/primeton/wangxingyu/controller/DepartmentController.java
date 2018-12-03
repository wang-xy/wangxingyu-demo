package com.primeton.wangxingyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.primeton.wangxingyu.entity.Department;
import com.primeton.wangxingyu.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 组织机构管理Controller
 * 
 * @author wangxingyu 实现了对组织机构的增删改查方法
 */
@RestController
@RequestMapping(value = "/api/departmentController")
@Api(value = "组织机构管理controller", tags = "组织机构管理接口")
public class DepartmentController {

	@Autowired

	private DepartmentService departmentService;

	/**
	 * 添加部门
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertDep", method = { RequestMethod.POST })
	@ResponseBody
	@ApiOperation(value = "添加部门")
	public Department insertDepartment(Department department) throws Exception {

		return departmentService.insertDepartment(department);

	}

	/**
	 * 根据部门id查询部门信息
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectDepById", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据id查询部门信息")
	public Department SelectDepById(Integer dep_id) throws Exception {

		return departmentService.SelectDepById(dep_id);

	}

	/**
	 * 根据部门id查询部门信息以及下级部门
	 * 
	 * @param dep_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectDepDetail", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据id查询部门信息和下级部门信息")
	public Department selectDepDetail(Integer dep_id) throws Exception {

		return departmentService.selectDepDetail(dep_id);

	}

	/**
	 * 分页查询组织机构信息
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selecDepartment", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "分页查询用户信息")
	public PageInfo<Department> selectDepartment(String dep_name, Integer pageNum, Integer pageSize) throws Exception {
		PageInfo<Department> selectDepartment = departmentService.selectDepartment(dep_name, pageNum, pageSize);

		return selectDepartment;
	}

	/**
	 * 根据部门id删除部门
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteDepById", method = { RequestMethod.DELETE })
	@ResponseBody
	@ApiOperation(value = "根据id删除部门")
	public Integer deleteDepById(Integer dep_id) throws Exception {
		Integer deleteDepById = departmentService.deleteDepById(dep_id);

		return deleteDepById;
	}

	/**
	 * 根据组织id修改组织信息
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateDepById", method = { RequestMethod.PUT })
	@ResponseBody
	@ApiOperation(value = "根据部门名称修改部门信息")
	public Department updateDepById(Department department) throws Exception {

		return departmentService.updateDepById(department);
	}

}
