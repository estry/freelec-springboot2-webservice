package com.example1.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //make get method
@RequiredArgsConstructor // make constructor with final variables
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
