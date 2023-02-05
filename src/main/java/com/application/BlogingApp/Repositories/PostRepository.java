package com.application.BlogingApp.Repositories;
import com.application.BlogingApp.Entity.Category;
import com.application.BlogingApp.Entity.Post;
import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
