package cn.xhg.ssm;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xhg.ssm.config.redisConfig;
import cn.xhg.ssm.utils.RedisUtil;

@RestController
// 将返回值转换成json
public class hello {
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	public static void main(String[] args) {
		
		redisConfig conf = new redisConfig();
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		ValueOperations<String, Object> redis = redisTemplate.opsForValue();
		redis.set("name", "xhg");
	}

	@GetMapping("/demo")
	public String demo() {
		System.out.println("Hello");

		return "hello word";
	}
}
