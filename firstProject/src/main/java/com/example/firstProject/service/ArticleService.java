package com.example.firstProject.service;

import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 서비스 선언! 요리사임 ( 서비스 객체를 스프링부트에 생성)
public class ArticleService {

    @Autowired // springboot 가 미리 생성해놓은 객체를 가져다가 자동 연결해줌 DI(Dependency Injection)
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }
}