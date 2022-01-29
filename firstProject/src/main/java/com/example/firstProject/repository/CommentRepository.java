package com.example.firstProject.repository;

import com.example.firstProject.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> { // Jpa
    // 특정 게시글의 모든 댓글 조회
    @Query(value =
            "SELECT *" +
            "FROM comment" +
            "WHERE article_id = :articleId",
            nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);


    // 특정 닉네임의 모든 댓글 조회


}
