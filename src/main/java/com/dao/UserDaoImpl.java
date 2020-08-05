package com.dao;

import com.entity.User;
import com.entity.Userloginlog;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public User getUserByEmail(String email) {
        String hql = "from User u where u.email=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, email);
        System.out.println("UserDaoImpl");
        return (User)query.uniqueResult();
    }
    @Override
    public User getUserByCellphone(String cellphone) {
        String hql = "from User u where u.cellphone=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, cellphone);
        return (User)query.uniqueResult();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void addUserLoginlog(Userloginlog userloginlog) {
        String sql="insert into userloginlog(login_id,user_id,login_time,login_ip) values(UUID(),?,?,?)";
        Query query=getSession().createSQLQuery(sql);
        query.setParameter(0, userloginlog.getUserId());
        query.setParameter(1,userloginlog.getLoginTime());
        query.setParameter(2, userloginlog.getLoginIp());
        query.executeUpdate();
    }

    @Override
    public List<Userloginlog> getalluserloginlog() {
        String hql = "from Userloginlog";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }


}
