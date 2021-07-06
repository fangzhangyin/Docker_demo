package fzy_test.demo.ServiceImp;

import fzy_test.demo.DAO.UserDAO;
import fzy_test.demo.Entity.User;
import fzy_test.demo.Redis.RedisUtil;
import fzy_test.demo.Service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImp implements UserSercice {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public int save(User user) {
        int id = 0;
        try {//保存并返回id
            id = userDAO.saveAndFlush(user).getId();
            redisUtil.set("userID" + id, user);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("保存信息出错，信息==" + user.toString());
            id = -1;
        }
        return id;
    }

    @Override
    public User findByid(int id) {
        User user = new User();
        user = (User) redisUtil.get("userID" + id, User.class);
        if (user == null) {
            try {
                user = userDAO.findById(id).get();
                redisUtil.set("userID" + id, user);
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("查询出错，没有此id" + id);
                user = null;
            }
        }
        return user;
    }
}