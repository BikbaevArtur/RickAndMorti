package ru.bikbaev.spring_hw_6_2_rickandmorti.service;


import ru.bikbaev.spring_hw_6_2_rickandmorti.domain.Characters;

public interface ServiceApi {
    Characters getAllCharacters();
    public Characters getAllNextCharacters(String next);
    public void setCHARACTER_API(String CHARACTER_API);


}
