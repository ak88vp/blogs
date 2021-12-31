package com.example.airbnb.repository;

import com.example.airbnb.model.Blog;
import com.example.airbnb.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByStatus(Status status);
    Iterable<Blog> findAllByTitleContaining(String title);
}
