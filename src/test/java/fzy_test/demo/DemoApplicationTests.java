package fzy_test.demo;

import com.alibaba.fastjson.JSON;
import fzy_test.demo.Entity.User;
import fzy_test.demo.Model.HttpMsg;
import fzy_test.demo.Redis.RedisUtil;
import fzy_test.demo.ServiceImp.UserImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.LinkedHashMap;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserImp userImp;

    @Autowired
    RedisUtil redisUtil;


    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        int id = userImp.save(user);
        System.out.println(id);
    }

    @Test
    void httpmsg() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        HttpMsg httpMsg = new HttpMsg().successmsg(user);
        System.out.println(JSON.toJSONString(httpMsg));
    }

    @Test
    void setredis() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        redisUtil.set("test", user);
    }

    @Test
    void getredis() {
        User test = (User) redisUtil.get("test", User.class);
        System.out.println(test.toString());
    }
}
