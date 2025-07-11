package com.codegym.blogapp.repository;

import com.codegym.blogapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> { User findByUsername(String username);
}
