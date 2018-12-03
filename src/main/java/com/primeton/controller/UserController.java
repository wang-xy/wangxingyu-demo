package com.primeton.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.primeton.entity.User;
import com.primeton.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理Controller
 * 
 * @author wangxingyu 提供了对用户信息的增删改查和登陆方法
 */
@RestController
@RequestMapping(value = "/api/usercontroller")
@Api(value = "用户管理controller", tags = "用户管理接口")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertUser", method = { RequestMethod.POST })
	@ResponseBody
	@ApiOperation(value = "添加用户信息")
	public User insertUser(User user) throws Exception {

		return userService.insertUser(user);

	}

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/SelectUserByName", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据用户名查询用户信息")
	public List<User> SelectUserByName(String userName) throws Exception {

		return userService.SelectUserByName(userName);

	}

	/**
	 * 分页查询用户信息
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectUser", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "分页查询用户信息")
	public PageInfo<User> selectUser(String userName, Integer pageNum, Integer pageSize) throws Exception {
		PageInfo<User> selectUser = userService.selectUser(userName, pageNum, pageSize);

		return selectUser;

	}

	/**
	 * 根据用户密码查询用户信息
	 * 
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectUserByPassword", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据用户名查询用户信息")
	public List<User> selectUserByPassword(String userPassword) throws Exception {

		return userService.selectUserByPassword(userPassword);

	}

	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectUserById", method = { RequestMethod.GET })
	@ResponseBody
	@ApiOperation(value = "根据用户id查询用户信息")
	public User SelectUserById(Integer uid) throws Exception {

		return userService.selectUserById(uid);

	}

	/**
	 * 根据id删除用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteUserById", method = { RequestMethod.DELETE })
	@ResponseBody
	@ApiOperation(value = "根据用户id删除用户信息")
	public Integer deleteByID(Integer uid) throws Exception {
		Integer deleteByID = userService.deleteByID(uid);

		return deleteByID;

	}

	/**
	 * 根据用户Id修改用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/updateUser", method = { RequestMethod.PUT })
	@ResponseBody
	@ApiOperation(value = "根据用户id修改用户信息")
	public User update(User user) throws Exception {

		return userService.update(user);

	}

	/**
	 * 根据用户名和用户id来修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateByName", method = { RequestMethod.PUT })
	@ResponseBody
	@ApiOperation(value = "根据用户名修改用户信息")
	public List<User> updateByNamw(User user) throws Exception {
		return userService.updateByName(user);

	}

	/**
	 * 用户登陆
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */

	// 登录
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	@ResponseBody
	@ApiOperation(value = "用户请求登录")
	public User login(User user) throws Exception {
		return userService.login(user);
	}
}