package ru.bikbaev.spring_hw_6_2_rickandmorti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bikbaev.spring_hw_6_2_rickandmorti.domain.Characters;
import ru.bikbaev.spring_hw_6_2_rickandmorti.service.ServiceApi;

@Controller
public class CharactersController {

    @Autowired
    private ServiceApi serviceApi;

    private static  int pageNum = 1;

    @GetMapping("/page")
    public String getCharacters(Model model) {
        Characters characters = serviceApi.getAllCharacters();
        int pageEnd = serviceApi.getAllCharacters().getInfo().getPages();
        model.addAttribute("characters", characters);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageEnd",pageEnd);
        return "page";
    }

    @GetMapping("/page/next")
    public String nextPage(Model model) {
        String nextPage = serviceApi.getAllCharacters().getInfo().getNext();
        if (nextPage != null) {
            serviceApi.setCHARACTER_API(nextPage);
            pageNum++;
        }

        return "redirect:/page";

    }

    @GetMapping("/page/prev")
    public String prevPage(Model model) {

        String prev = serviceApi.getAllCharacters().getInfo().getPrev();
        if (prev != null) {
            serviceApi.setCHARACTER_API(prev);
            pageNum --;
        }

        return "redirect:/page";

    }


}
