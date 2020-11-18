package com.example1.book.springboot.domain.posts;

import com.example1.book.springboot.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가 , public Posts(){}와 같다
@Entity // 테이블과 링크될 클래스임을 표시, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 매칭 ex)SalesManager.java->sales_manager table
public class Posts extends BaseTimeEntity {

    @Id //테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙, GenerationType.IDENTITY 옵션을 추가해야만 auto_increment(id값 자동 증가) 가능
    private Long id;

    @Column(length = 500, nullable = false) //선언하지 않다도 필드는 모두 칼럼, 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함함
     public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
