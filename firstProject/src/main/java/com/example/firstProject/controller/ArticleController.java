package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { //  post 방식으로 던져지는 데이터를 파라미터로 받음
        System.out.println(form.toString());
        return "";
    }
}
