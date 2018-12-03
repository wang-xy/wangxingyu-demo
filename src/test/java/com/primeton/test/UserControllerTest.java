package com.primeton.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.primeton.controller.UserController;
import com.primeton.entity.User;
import com.primeton.exception.DemoException;

/**
 * 员工信息的增删改查、登录测试
 * 
 * @author wangxingyu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@Test
	public void UserTest() throws Exception {

		User user = new User();
		int uid = 5;
		String userName = "wang-xy";
		int pageNum = 1;
		int pageSize = 2;
		/**
		 * 测试根据id删除用户信息
		 * 
		 * @param id
		 * @return
		 * @throws Exception
		 */
		userController.deleteByID(5);
		Assert.assertNotEquals(DemoException.DELETE_ID_INFO_FAILED, "删除失败，ID不存在");

		/**
		 * 测试添加用户
		 * 
		 * @param user
		 * @return
		 * @throws Exception
		 */

		user.setUid(5);
		user.setUserName("wang-xy");
		user.setUserPassword("123456");
		user.setName("王星宇");
		user.setAge("18");
		user.setSex("男");
		user.setDid(1);
		userController.insertUser(user);
		Assert.assertNotEquals(DemoException.SAVE_USER_INFO_FAILED, "用戶名不能重复");

		/**
		 * 测试根据用户名查询用户信息
		 * 
		 * @param userName
		 *            用户名
		 * @return 用户数据
		 * @throws Exception
		 */

		userController.SelectUserByName(userName);
		Assert.assertNotEquals(DemoException.POST_USER_INFO_FAILED, "用户名不存在");

		/**
		 * 测试 分页查询用户信息
		 * 
		 * @param id
		 *            用户id
		 * @return 用户数据
		 * @throws Exception
		 */

		userController.selectUser(userName, pageNum, pageSize);
		Assert.assertNotEquals(DemoException.POST_USER_INFO_FAILED, "用户名不存在");

		/**
		 * 测试 根据用户Id查询用户信息
		 * 
		 * @param id
		 *            用户id
		 * @return 用户数据
		 * @throws Exception
		 */

		userController.SelectUserById(uid);
		Assert.assertNotEquals(DemoException.POST_ID_INFO_FAILED, "员工ID不存在");

		/**
		 * 根据用户名和id修改用户信息
		 * 
		 * @param user
		 *            用户名
		 * @return 更新的数据
		 * @throws Exception
		 */
		user.setUid(5);
		user.setUserName("wang-xy");
		user.setUserPassword("666");
		user.setName("西岚");
		user.setAge("18");
		user.setSex("男");
		user.setDid(2);
		userController.updateByNamw(user);
		Assert.assertNotEquals(DemoException.WECHAT_VALID_FAILED, "修改的用户名不存在");
		Assert.assertNotEquals(DemoException.GET_USER_INFO_FAILED, "修改的用户id不存在");

		/**
		 * 用户请求登录
		 * 
		 * @param user
		 *            用户名密码
		 * @return
		 * @throws Exception
		 */
		user.setUserName("wang-xy");
		user.setUserPassword("666");
		userController.login(user);
		Assert.assertNotEquals(DemoException.GET_USER_AUTH_INFO_FAILED, "用户名不正确");
		Assert.assertNotEquals(DemoException.SAVE_USER_AUTH_INFO_FAILED, "密码不正确");
	}
}
