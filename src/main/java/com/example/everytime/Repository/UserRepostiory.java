package com.example.everytime.Repository;

import com.example.everytime.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostiory extends JpaRepository<User, Long> {
}
