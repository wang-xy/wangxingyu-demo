package com.primeton.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.primeton.wangxingyu.controller.DepartmentController;
import com.primeton.wangxingyu.entity.Department;
import com.primeton.wangxingyu.exception.DemoException;

/**
 * 组织机构的增删改查测试
 * 
 * @author wangxingyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentControllerTest {

	@Autowired
	private DepartmentController departmentController;

	@Test
	public void DepartmentTest() throws Exception {
		String dep_name = "研发部";
		int dep_id = 5;
		int pageNum = 1;
		int pageSize = 3;
		/**
		 * 根据id删除组织
		 * 
		 * @param id
		 * @return
		 * @throws Exception
		 */
		departmentController.deleteDepById(dep_id);
		Assert.assertNotEquals(DemoException.DEL_XJID_N_FAILED, "删除的组织id不存在");
		/**
		 * 测试添加部门
		 * 
		 * @param department
		 * @return
		 * @throws Exception
		 */
		Department department = new Department();
		department.setDep_id(5);
		department.setDep_name("法律部");
		department.setDep_xjId(10);
		department.setDep_xjName("法律一部");
		departmentController.insertDepartment(department);
		Assert.assertNotEquals(DemoException.PUT_DEPO_FAILED, "组织机构名称不能重复");
		/**
		 * 测试根据id查询组织机构信息
		 * 
		 * @param dep_id
		 *            组织机构id
		 * @return 组织机构信息
		 * @throws Exception
		 * @throws ServiceException
		 */

		departmentController.SelectDepById(dep_id);
		Assert.assertNotEquals(DemoException.PUT_ID_FAILED, "查询ID不存在");

		/**
		 * 测试分页查询组织机构信息
		 * 
		 * @param dep_id
		 * @return
		 * @throws Exception
		 */
		departmentController.selectDepartment(dep_name, pageNum, pageSize);
		Assert.assertNotEquals(DemoException.PUT_ID_FAILED, "查询ID不存在");
		/**
		 * 测试根据部门id查询组织机构信息以及下级组织
		 * 
		 * @param dep_id
		 * @return
		 * @throws Exception
		 */
		departmentController.selectDepDetail(dep_id);
		Assert.assertNotEquals(DemoException.PUT_ID_FAILED, "查询ID不存在");

		/**
		 * 根据id修改组织信息
		 * 
		 * @param id
		 * @return
		 * @throws Exception
		 */
		Department updateDepById = departmentController.updateDepById(department);
		updateDepById.setDep_id(5);
		updateDepById.setDep_name("人事部");
		updateDepById.setDep_xjId(10);
		updateDepById.setDep_xjName("人事1部");
		departmentController.updateDepById(updateDepById);
		Assert.assertNotEquals(DemoException.POST_ID_N_FAILED, "修改的组织id不存在");

	}

}
