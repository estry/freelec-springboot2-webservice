package com.example1.book.springboot.web;

import com.example1.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //make controller to return json file
public class HelloController {

   /* @GetMapping("/hello") //make API be requested Http method get
    public String hello() {
        return "hello";
    }*/

    /*@GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        //외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        return new HelloResponseDto(name, amount);
    }*/
}
