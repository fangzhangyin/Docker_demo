package fzy_test.demo.Service;

import fzy_test.demo.Entity.User;

public interface UserSercice {
    int save(User user);

    User findByid(int id);
}
