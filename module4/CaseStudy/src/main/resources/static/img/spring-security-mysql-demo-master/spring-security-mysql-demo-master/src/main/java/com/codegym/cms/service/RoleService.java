package com.codegym.cms.service;

import com.codegym.cms.model.Message;
import com.codegym.cms.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Long id);

    void save(Role role);

    void remove(Long id);
}
