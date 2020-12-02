package com.bionime.dao;

import com.bionime.entity.User;

public interface UserMapper {
    //  增
    int addUser(User user);
    //  查
    int selectUser(String username);
    //  改
    int updateUser(User user);
}