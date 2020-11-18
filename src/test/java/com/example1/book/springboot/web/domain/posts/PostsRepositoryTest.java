package com.example1.book.springboot.web.domain.posts;

import com.example1.book.springboot.domain.posts.Posts;
import com.example1.book.springboot.domain.posts.PostsRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //테스트가 끝날 때마다 수행되는 메소드 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void load_and_save(){

        String title = "test text";
        String content = "test content";

        postsRepository.save(Posts.builder() //insert/update 쿼리를 실행, id가 있으면 update 없으면 insert
                            .title(title)
                            .content(content)
                            .author("estry")
                            .build());

        List<Posts> postsList = postsRepository.findAll(); //테이블에 있는 모든 데이터를 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void commitBaseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2020,6,4,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>> createDate="+posts.getCreatedDate()
                +", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
