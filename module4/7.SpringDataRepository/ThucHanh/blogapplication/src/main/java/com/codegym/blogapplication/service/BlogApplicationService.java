package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogApplicationService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByFirstNameContaining(String keyword, Pageable pageable);

    void save(Blog blog);

    void delete(Integer id);

    Blog findById(Integer id);
}
