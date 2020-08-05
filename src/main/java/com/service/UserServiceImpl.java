package com.service;

import com.dao.UserDao;
import com.entity.User;
import com.entity.Userloginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        return user;
    }

    @Override
    public User getUserByCellphone(String cellphone) {
        User user = userDao.getUserByCellphone(cellphone);
        return user;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void addUserLoginlog(Userloginlog userloginlog) {
        userDao.addUserLoginlog(userloginlog);
    }

    @Override
    public List<Userloginlog> getalluserloginlog() {
        List<Userloginlog> list = userDao.getalluserloginlog();
        return list;
    }


}
