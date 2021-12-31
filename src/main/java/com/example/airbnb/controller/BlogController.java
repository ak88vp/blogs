package com.example.airbnb.controller;

import com.example.airbnb.model.Blog;
import com.example.airbnb.model.Status;
import com.example.airbnb.service.interfaceS.BlogService;
import com.example.airbnb.service.interfaceS.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    StatusService statusService;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> findAll(){
        Iterable<Blog> blogs= blogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        blog.setTime(LocalDateTime.now());
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id,@RequestBody Blog blog){
        blog.setId(id);
        blog.setTime(LocalDateTime.now());
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Blog> delete(@PathVariable Long id){
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findOne(@PathVariable Long id){
        Optional<Blog> blog=blogService.findById(id);
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }
    @GetMapping("public/{id}")
    public ResponseEntity<Iterable<Blog>> findAllPublic(@PathVariable Long id){
        Optional<Status> status=statusService.findById(id);
        Iterable<Blog> blogs=blogService.findAllByStatus(status.get());
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("status")
    public ResponseEntity<Iterable<Status>> findAllStatus(){
        Iterable<Status> statuses=statusService.findAll();
        return new ResponseEntity<>(statuses,HttpStatus.OK);
    }
    @GetMapping("search")
    public ResponseEntity<Iterable<Blog>> findByTitle(String key){
        Iterable<Blog> blogs=blogService.findAllByTitleContaining(key);
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }


}
