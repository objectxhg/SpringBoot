package cn.xhg.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xhg.ssm.mapper.UserMapper;
import cn.xhg.ssm.pojo.User;
import cn.xhg.ssm.service.UserService;
import cn.xhg.ssm.utils.RedisUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private  RedisUtil redisUtil;
	

	@Override
	public PageInfo findAll(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.findAll();
		PageInfo<User> pagelist = new PageInfo<>(list);
		return pagelist;
	}

	@Override
	public User get(Integer id) {
		User user = null;
		String redisJson = (String) redisUtil.get("id"+id);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			
			if(StringUtils.isEmpty(redisJson)) {
				user = userMapper.get(id);
				redisUtil.set("id"+id, objectMapper.writeValueAsString(user), 30l);
				System.out.println("查询数据库");
			}else {
				user = objectMapper.readValue(redisJson, User.class);
				System.out.println("查询缓存");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
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
