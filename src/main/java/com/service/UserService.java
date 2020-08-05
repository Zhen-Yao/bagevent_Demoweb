package com.service;

import com.entity.User;
import com.entity.Userloginlog;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserByEmail(String email);

    User getUserByCellphone(String cellphone);

    void addUser(User user);

    void addUserLoginlog(Userloginlog userloginlog);

    List<Userloginlog> getalluserloginlog();
}
