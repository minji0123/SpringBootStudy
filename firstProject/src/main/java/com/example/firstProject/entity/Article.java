package com.example.firstProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // 이 어노테이션이 있어야 DB 가 해당 객체를 인식 가능 => 해당 클래스Article 로 테이블을 만든다.
@AllArgsConstructor // constructor 롬복
@NoArgsConstructor // 디폴트 constructor 롬북
@ToString // toString 롬복
@Getter // 게터 롬복
public class Article {

    @Id // id 삽입!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 id 넘버링 + db가 id를 자동으로 생성해줌
    private Long id; // DB 에는 대표값을 넣어줘야 한다. id 키값같은거

    @Column // 이 어노테이션이 있어야 DB 에서 컬럼으로 인식 가능
    private String title;
    @Column
    private String content;

//    public Long getId() {
//        return id;
//    }

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
