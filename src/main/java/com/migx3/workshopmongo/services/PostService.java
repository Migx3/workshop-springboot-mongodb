package com.migx3.workshopmongo.services;

import com.migx3.workshopmongo.domain.Post;
import com.migx3.workshopmongo.repositories.PostRepository;
import com.migx3.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}