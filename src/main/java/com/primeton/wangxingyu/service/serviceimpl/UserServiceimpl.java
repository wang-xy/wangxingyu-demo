package com.primeton.wangxingyu.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.primeton.wangxingyu.dao.UserMapper;
import com.primeton.wangxingyu.entity.User;
import com.primeton.wangxingyu.exception.DemoException;
import com.primeton.wangxingyu.service.UserService;

/**
 * 用户service实现类
 * 
 * @author wangxingyu
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceimpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户信息
	 * @return 添加后的用户信息
	 * @throws ServiceException
	 */
	@Override
	@Transactional
	public User insertUser(User user) throws Exception {
		List<User> selectUserByName = userMapper.SelectUserByName(user.getUserName());
		// 判断接收到的用户名在数据库中是否存在
		if (selectUserByName.size() != 0) {
			// 如果已经存在，抛出自定义异常： 用户名不能重复
			throw new DemoException(DemoException.SAVE_USER_INFO_FAILED, "用戶名不能重复");
		}
		// 如果不存在则添加用户
		userMapper.insertUser(user);
		return user;
	}

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param userName
	 * @param pageIndex
	 *            起始页数
	 * @param pageSize
	 *            每页条数
	 * @return 用户数据
	 * @throws Exception
	 */
	public List<User> SelectUserByName(String userName) throws Exception {
		List<User> selectUserByName = userMapper.SelectUserByName(userName);
		if (selectUserByName == null) {
			// 如果不存在，抛出自定义异常：用不名不存在
			throw new DemoException(DemoException.POST_USER_INFO_FAILED, "用户名不存在");
		}

		return selectUserByName;

	}

	/**
	 * 分页查询用户信息
	 * 
	 * @param userName
	 * @param pageIndex
	 *            起始页数
	 * @param pageSize
	 *            每页条数
	 * @return 用户数据
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public PageInfo<User> selectUser(String userName, Integer pageNum, Integer pageSize) {
		userName = "%" + userName + "%";
		// 设置起始页数默认值
		if (pageNum == null) {
			pageNum = 1;
		}
		// 设置每页条数默认值
		if (pageSize == null) {
			pageSize = 3;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.selectUser(userName);
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		return pageInfo;

	}

	/**
	 * 根据用户密码查询用户信息
	 * 
	 * @param userPassword
	 *            用户密码
	 * @return 用户数据
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<User> selectUserByPassword(String userPassword) throws Exception {
		// 判断接收到的用户密码在数据库中是否存在
		List<User> selectUserByPassword = userMapper.selectUserByPassword(userPassword);
		// 如果不存在，抛出自定义异常：密码不存在
		if (selectUserByPassword.size() == 0) {
			throw new DemoException(DemoException.POST_PASSWORD_INFO_FAILED, "密码不存在");
		}
		// 如果存在，将查询到的信息返回
		return userMapper.selectUserByPassword(userPassword);
	}

	/**
	 * 根据用户Id查询用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return 用户数据
	 * @throws Exception
	 */
	@Override
	@Transactional
	public User selectUserById(Integer uid) throws Exception {
		// 判断接收到的用户id在数据库中是否存在
		User selectUserById = userMapper.selectUserById(uid);
		// 如果不存在，抛出自定义异常：id不存在
		if (selectUserById == null) {
			throw new DemoException(DemoException.POST_ID_INFO_FAILED, "员工ID不存在");
		}
		// 如果存在，将查询到的信息返回
		return userMapper.selectUserById(uid);
	}

	/**
	 * 根据用户id删除用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Integer deleteByID(Integer uid) throws Exception {
		Integer deleteById = userMapper.deleteById(uid);
		// 判断接收到的用户id在数据库中是否存在
		if (deleteById == 0) {
			// 如果不存在，则抛出异常："删除失败，id不存在"
			throw new DemoException(DemoException.DELETE_ID_INFO_FAILED, "删除失败，ID不存在");
		}
		// 如果存在，删除数据
		return deleteById;
	}

	/**
	 * 根据用户id修改用户信息
	 * 
	 * @param user
	 *            用户id
	 * @return 更新的数据
	 * @throws Exception
	 */
	@Override
	@Transactional
	public User update(User user) throws Exception {
		User selectUserById = userMapper.selectUserById(user.getUid());
		// 判断接受到的用户Id在数据库中是否存在
		if (selectUserById == null) {
			// 如果不存在，抛出自定义异常：修改的用户id不存在
			throw new DemoException(DemoException.GET_USER_INFO_FAILED, "修改的用户id不存在");
		}
		// 如果存在，将用户信息修改并返回
		userMapper.update(user);
		User userById = userMapper.selectUserById(user.getUid());
		return userById;
	}

	/**
	 * 根据用户名和id修改用户信息
	 * 
	 * @param user
	 *            用户名
	 * @return 更新的数据
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<User> updateByName(User user) throws Exception {
		// 判断接受到的用户名和用户Id是否存在
		List<User> result = userMapper.SelectUserByName(user.getUserName());
		User selectUserById = userMapper.selectUserById(user.getUid());
		if (result.size() == 0) {
			// 如果用户名不存在，抛出自定义异常：修改的用户名不存在
			throw new DemoException(DemoException.WECHAT_VALID_FAILED, "修改的用户名不存在");
		}
		// 如果用id不存在，抛出自定义异常：修改的用户id不存在
		if (selectUserById == null) {
			throw new DemoException(DemoException.GET_USER_INFO_FAILED, "修改的用户id不存在");
		}
		// 如果都存在，则修改用户信息并将结果返回
		userMapper.updateByName(user);
		return result;
	}

	/**
	 * 用户请求登录
	 * 
	 * @param user
	 *            用户名密码
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public User login(User user) throws Exception {
		// 从用户信息中获取到用户名和用户密码
		List<User> userName = userMapper.SelectUserByName(user.getUserName());
		List<User> userPassword = userMapper.selectUserByPassword(user.getUserPassword());
		// 判断用户名和密码是否存在于数据库中
		// 如果用户名不存在，则抛出自定义异常：用户名不正确
		if (userName.size() == 0) {
			throw new DemoException(DemoException.GET_USER_AUTH_INFO_FAILED, "用户名不正确");
		}
		// 如果用户密码不存在，则抛出自定义异常：用户密码不正确
		else if (userPassword.size() == 0) {
			throw new DemoException(DemoException.SAVE_USER_AUTH_INFO_FAILED, "密码不正确");
		}
		// 如果两个条件都满足则通过用户登录请求，并提示用户登录成功

		return userMapper.login(user);
	}

}
