package com.example1.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //link springboot test to junit
@WebMvcTest //focus on Web(spring MVC)
public class HelloControllerTest {
    @Autowired //about Bean
    private MockMvc mvc; //start of spring MVC test

    @Test
    public void hello_is_returned() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //request HTTP GET to /hello
                .andExpect(status().isOk()) //check result
                .andExpect(content().string(hello)); //check response content
    }

    @Test
    public void helloDto_is_returned() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name) // API 테스트시 사용될 요청 패러미터 지정, String 값만 사용가능
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) // JSON 응답값을 필드별로 검증 가능, $를 기준으로 필드값을 명시
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
