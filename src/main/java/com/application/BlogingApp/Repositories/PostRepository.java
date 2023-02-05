package com.application.BlogingApp.Repositories;
import com.application.BlogingApp.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
