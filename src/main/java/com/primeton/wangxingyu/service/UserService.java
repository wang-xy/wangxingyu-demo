package com.primeton.wangxingyu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.primeton.wangxingyu.entity.User;

/**
 * 用户service接口
 * 
 * @author wangxingyu
 *
 */
public interface UserService {
	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户信息
	 * @return
	 * @throws ServiceException
	 */
	public User insertUser(User user) throws Exception;

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户数据
	 * @throws Exception
	 */
	public List<User> SelectUserByName(String userName) throws Exception;

	/**
	 * 分页查询用户信息
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户数据
	 * @throws Exception
	 */
	PageInfo<User> selectUser(String userName, Integer pageNum, Integer pageSize);

	/**
	 * 根据用户密码查询用户信息
	 * 
	 * @param userPassword
	 *            用户密码
	 * @return 用户数据
	 * @throws Exception
	 */
	public List<User> selectUserByPassword(String userPassword) throws Exception;

	/**
	 * 根据用户Id查询用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return 用户数据
	 * @throws Exception
	 */
	public User selectUserById(Integer uid) throws Exception;

	/**
	 * 根据用户id删除用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteByID(Integer uid) throws Exception;

	/**
	 * 根据用户id修改用户信息
	 * 
	 * @param user
	 *            用户id
	 * @return 更新的数据
	 * @throws Exception
	 */
	public User update(User user) throws Exception;

	/**
	 * 根据用户名修改用户信息
	 * 
	 * @param user
	 *            用户名
	 * @return 更新的数据
	 * @throws Exception
	 */
	public List<User> updateByName(User user) throws Exception;

	/**
	 * 用户请求登录
	 * 
	 * @param user
	 *            用户名密码
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;

}