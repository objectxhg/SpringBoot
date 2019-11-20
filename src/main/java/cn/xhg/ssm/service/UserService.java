package cn.xhg.ssm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.xhg.ssm.pojo.User;

public interface UserService {
	
	public PageInfo<User> findAll(Integer page, Integer pageSize);
	
	public User get(Integer id);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(Integer id);
}
