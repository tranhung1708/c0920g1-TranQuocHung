package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogApplicationServiceimpl implements BlogApplicationService {
    @Autowired
    BlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByFirstNameContaining(String keyword, Pageable pageable) {
        return this.blogRepository.findAllByTitleContaining(keyword,pageable);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        return this.blogRepository.findById(id).orElse(null);
    }
}
