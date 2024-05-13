package ru.bikbaev.spring_hw_6_2_rickandmorti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bikbaev.spring_hw_6_2_rickandmorti.domain.Characters;
import ru.bikbaev.spring_hw_6_2_rickandmorti.service.ServiceApi;


@RestController
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public ResponseEntity<Characters> getCharacters()
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }




}
