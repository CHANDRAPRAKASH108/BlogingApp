package com.application.BlogingApp.Repositories;

import com.application.BlogingApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
