package com.bionime.service.impl;

import com.bionime.entity.User;
import com.bionime.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> find() {
        List<User> users=new ArrayList<>();
        int a=1;
        User user=new User();
        while (a<10){
            a++;
            user.setName("测试"+a);
            user.setAccount("账号:"+a);
            user.setPassword("123456");
            user.setSex("男");
            users.add(user);
        }
        return users;
    }
}
