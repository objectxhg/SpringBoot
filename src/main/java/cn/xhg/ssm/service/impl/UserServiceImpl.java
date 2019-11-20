package cn.xhg.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xhg.ssm.mapper.UserMapper;
import cn.xhg.ssm.pojo.User;
import cn.xhg.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public PageInfo<User> findAll(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<User> list = userMapper.findAll();
		PageInfo<User> pageUser = new PageInfo<User>(list);
		
		return pageUser;
	}

	@Override
	public User get(Integer id) {
		return userMapper.get(id);
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
	}
}
