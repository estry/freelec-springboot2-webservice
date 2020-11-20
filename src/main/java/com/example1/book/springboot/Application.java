package com.example1.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}

//update : url->indexController->수정완료 클릭->js에서 update function api 호출 ->PostsApiController
//->PostsService->entity 통해 db 업데이트