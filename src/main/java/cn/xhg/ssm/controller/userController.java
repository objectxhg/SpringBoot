package cn.xhg.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xhg.ssm.pojo.User;
import cn.xhg.ssm.service.UserService;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(){
		System.out.println("aaaaa");
		return "index";
	}
	
	@RequestMapping("/showAll")
	public List<User> findAll(){
		System.out.println("aaaaa");
		return userService.findAll();
	}
	//restful 传参
	@RequestMapping("/get/{id}")//@PathVariable("id") 获取路径参数。即url/{id}这种形式。
	public User findAll(@PathVariable("id") Integer id){
		System.out.println("111111111");
		
		return userService.get(id);
	}
	
//	@RequestMapping("/get") //以前的形式
//	public User findAll(HttpServletRequest req){
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		return userService.get(id);
//	}
	
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(User user){
		try{
			userService.insert(user);
			return "insert success";
		}catch(Exception e){
			return "insert error";
		}
	}
	
	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String update(User user){
		try{
			userService.update(user);
			return "update success";
		}catch(Exception e){
			return "update error";
		}
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		try{
			userService.delete(id);
			return "delete success";
		}catch(Exception e){
			return "delete error";
		}
		
	}
}







