package com.tap.DAO;

import com.tap.model.User;

public interface UserDAO {
    int addUser(User user);
    User getUserByUsername(String username);
}