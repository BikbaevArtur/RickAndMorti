package ru.bikbaev.spring_hw_6_2_rickandmorti.domain;

import lombok.Data;

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
