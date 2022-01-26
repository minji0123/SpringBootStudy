package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired // 이 어노테이션은 springboot 가 미리 생성해놓은 객체를 가져다가 자동 연결해줌
    private ArticleRepository articleReopsitory; // = newArticleRepo~~~를 안해도 됨. springboot 가 알아서해줌


    @GetMapping("articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { //  post 방식으로 던져지는 데이터(DTO)를 파라미터로 받음
//        System.out.println(form.toString()); --> 로깅 기능으로 대체
        log.info(form.toString());


        // 이제 dto로 받아온 form 데이터를 db 로 잘 넣어줄거이다.
        // 1. form 데이터(DTO) 를 Entity 로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Repository 에게 Entity 를 DB 안에 넣으라고 시킴.
        Article saved = articleReopsitory.save(article);
        log.info(saved.toString());

        return "";
    }

    @GetMapping("articles/{id}")
    public String show(@PathVariable Long id, Model model){ // 이 골뱅이는 id 값의 경로를 인식시키기 위해 있는거임
        log.info("id = " + id);

        // 1. id 를 이용해서 데이터를 불러와라
//        Optional<Article> articleEntity = articleReopsitory.findById(id); // 제레닉! 선택적 제네릭 ㄱㄱ
        Article articleEntity = articleReopsitory.findById(id).orElse(null); // 자바8 버전보다 밑인 사람들을 위해서

       // 2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article",articleEntity);

        // 3. 보여줄 페이지를 설정하기
        return "articles/show";
    }
}
