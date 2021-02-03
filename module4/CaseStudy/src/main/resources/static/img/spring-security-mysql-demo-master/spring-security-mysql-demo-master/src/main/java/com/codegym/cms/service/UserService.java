package com.codegym.cms.service;

import com.codegym.cms.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
