package cn.xhg.ssm.service;

import java.util.List;

import cn.xhg.ssm.pojo.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User get(Integer id);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(Integer id);
}
