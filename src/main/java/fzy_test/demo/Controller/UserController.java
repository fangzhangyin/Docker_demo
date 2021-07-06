package fzy_test.demo.Controller;

import fzy_test.demo.Entity.User;
import fzy_test.demo.Model.HttpMsg;
import fzy_test.demo.Redis.RedisUtil;
import fzy_test.demo.ServiceImp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class UserController {


    HttpMsg httpMsg = new HttpMsg();


    @Autowired
    UserImp userImp;

    @ResponseBody
    @GetMapping("/find/{id}")
    public HttpMsg findByid(@PathVariable int id) {
        User user = userImp.findByid(id);
        if (user != null) {
            httpMsg.successmsg(user);
        } else {
            httpMsg.Error();
        }
        return httpMsg;
    }

    @ResponseBody
    @PostMapping("/save")
    public HttpMsg save(@RequestBody User user) {
        int save = userImp.save(user);
        if (save > 0) {
            httpMsg.successmsg(save);
        } else {
            httpMsg.Error();
        }
        return httpMsg;
    }
}
