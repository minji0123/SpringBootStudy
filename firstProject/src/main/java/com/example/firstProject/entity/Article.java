package com.example.firstProject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 이 어노테이션이 있어야 DB 가 해당 객체를 인식 가능
@AllArgsConstructor // constructor 롬복
@NoArgsConstructor // 디폴트 constructor 롬북
@ToString // toString 롬복
public class Article {

    @Id // id 삽입!
    @GeneratedValue // 자동으로 id 넘버링
    private Long id; // DB 에는 대표값을 넣어줘야 한다. id 키값같은거

    @Column // 이 어노테이션이 있어야 DB 에서 컬럼으로 인식 가능
    private String title;
    @Column
    private String content;

//    public Article() {
//    }

//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }


}
