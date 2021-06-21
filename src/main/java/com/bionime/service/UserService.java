package com.bionime.service;

import com.bionime.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> find();
}
