package ru.bikbaev.spring_hw_6_2_rickandmorti.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.bikbaev.spring_hw_6_2_rickandmorti.domain.Characters;

import java.util.List;


@Service
public class ServiceApiImpl implements ServiceApi{

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Setter
    @Value("${spring.api.character.url}")
    private   String CHARACTER_API;


    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(CHARACTER_API, HttpMethod.GET,entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Characters getAllNextCharacters(String next) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(next, HttpMethod.GET,entity, Characters.class);
        return responce.getBody();
    }

}
