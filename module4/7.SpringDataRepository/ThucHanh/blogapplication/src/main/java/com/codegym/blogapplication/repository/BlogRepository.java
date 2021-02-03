package com.codegym.blogapplication.repository;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository  extends JpaRepository<Blog , Integer>{
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String keyword, Pageable pageable);

}
