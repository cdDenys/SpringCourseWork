package com.example.news.repository;

import com.example.news.models.Posting;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Posting, Long> {
}
