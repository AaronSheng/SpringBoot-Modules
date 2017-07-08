package com.aaron.dao;

import com.aaron.domain.User;
import com.aaron.dao.base.GenericDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Aaron Sheng on 9/16/16.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
    @Resource(name = "serverSessionFactory")
    public void setServerSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public User get(Long id) {
        return findByPK(id);
    }

    public  void add(User user) {
        save(user);
    }
}
