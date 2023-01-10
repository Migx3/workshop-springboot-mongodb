package com.migx3.workshopmongo.repositories;

import com.migx3.workshopmongo.domain.Post;
import com.migx3.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
