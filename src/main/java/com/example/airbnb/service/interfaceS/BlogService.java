package com.example.airbnb.service.interfaceS;

import com.example.airbnb.model.Blog;
import com.example.airbnb.model.Status;

public interface BlogService extends iGeneralService<Blog> {
    Iterable<Blog> findAllByStatus(Status status);
    Iterable<Blog> findAllByTitleContaining(String title);
}
