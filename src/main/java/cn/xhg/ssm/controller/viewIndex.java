package cn.xhg.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class viewIndex {
	
	@RequestMapping("/showindex")
	public String demo(HttpServletRequest req){
		
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		
		req.setAttribute("list", list);
		
		return "index";
	}
	
}
