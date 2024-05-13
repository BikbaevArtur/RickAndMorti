package ru.bikbaev.spring_hw_6_2_rickandmorti.domain;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
     Info info;
     List<Result> results;
}
