package com.primeton.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.primeton.entity.User;

/**
 * 用户UserMpper接口
 * 
 * @author wangxingyu
 *
 */
@Mapper
public interface UserMapper {
	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return 添加后的用户信息
	 */
	public Integer insertUser(User user);

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username
	 * @return 查询到的用户信息
	 */
	public List<User> SelectUserByName(@Param(value = "userName") String userName);

	/**
	 * 分页查询用户信息
	 * 
	 * @param userName
	 * 
	 * @param username
	 * @return 查询到的用户信息
	 */
	public List<User> selectUser(String userName);

	/**
	 * 根据用户密码查询用户信息
	 * 
	 * @param userPassword
	 * @return 查询到的用户信息
	 */
	public List<User> selectUserByPassword(@Param(value = "userPassword") String userPassword);

	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param id
	 * @return 查询到的用户信息
	 */
	public User selectUserById(@Param(value = "uid") Integer uid);

	/**
	 * 根据用户id删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteById(@Param(value = "uid") Integer uid);

	/**
	 * 根据id修改用户信息
	 * 
	 * @param user
	 * @return 修改后的用户信息
	 */
	public int update(User user);

	/**
	 * 根据用户名修改用户信息
	 * 
	 * @param user
	 * @return 修改后的用户信息
	 */
	public int updateByName(User user);

	/**
	 * 用户请求登录
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user);

}
