package com.aaron.dao;

import com.aaron.dao.base.GenericDao;
import com.aaron.domain.User;

/**
 * Created by Aaron Sheng on 9/16/16.
 */
public interface UserDao extends GenericDao<User, Long> {
    User get(Long id);

    void add(User user);
}
