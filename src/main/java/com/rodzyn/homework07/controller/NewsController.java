package com.rodzyn.homework07.controller;

import com.rodzyn.homework07.model.news.News;
import com.rodzyn.homework07.service.NewSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news")
public class NewsController {

    private NewSService newSService;

    @Autowired
    public NewsController(NewSService newSService) {
        this.newSService = newSService;
    }

    @GetMapping
    public String getAllNews(Model model){
        model.addAttribute("allnews", newSService.getAllNews());
        return "news/news";
    }

    @GetMapping("/new/{id}")
    public String getOneNews(@PathVariable("id") Integer id, Model model){
        model.addAttribute("newOne", newSService.getOneNew(id));
        return "news//onenew";
    }

    @GetMapping("/update/{id}")
    public String updateNews(@PathVariable("id") Integer id, Model model){
        News oneNew = newSService.getOneNew(id);
        model.addAttribute("onenew", oneNew);
//        model.addAttribute("updateNews", new News());
        return "news/updatenews";
    }

    @PostMapping("/update")
    public String addCar(@ModelAttribute News onenew){
        System.out.println(onenew);
        newSService.updateNews(onenew.getAuthor(), onenew.getDescription(), onenew.getNewsId());
        return "redirect:/news";
    }
}
