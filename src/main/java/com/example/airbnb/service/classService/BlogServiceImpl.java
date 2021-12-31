package com.example.airbnb.service.classService;

import com.example.airbnb.model.Blog;
import com.example.airbnb.model.Status;
import com.example.airbnb.repository.BlogRepository;
import com.example.airbnb.service.interfaceS.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByStatus(Status status) {
        return blogRepository.findAllByStatus(status);
    }

    @Override
    public Iterable<Blog> findAllByTitleContaining(String title) {
        return blogRepository.findAllByTitleContaining(title);
    }
}
