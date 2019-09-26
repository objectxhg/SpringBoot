package cn.xhg.ssm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 将返回值转换成json
public class hello {

	@GetMapping("/demo")
	public String demo() {
		System.out.println("Hello");

		return "hello word";
	}
}
