package com.example.everytime.Repository;

import com.example.everytime.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository<엔티티 타입, 엔티티의 기본키 타입>
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.likes l LEFT JOIN FETCH p.scraps s WHERE p.isDeleted = false")
    List<Post> findAllWithLikeAndScrapCount();
}
