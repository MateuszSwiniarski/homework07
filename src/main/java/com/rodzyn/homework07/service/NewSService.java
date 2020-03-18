package com.rodzyn.homework07.service;

import com.rodzyn.homework07.model.news.New;
import com.rodzyn.homework07.model.news.News;
import com.rodzyn.homework07.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewSService {

    private NewsRepository newsRepository;

    @Autowired
    public NewSService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;

        newsRepository.deleteAll();
        saveNews();
    }

    public New getNews(){
        RestTemplate restTemplate = new RestTemplate();
        New getNew = restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=pl&apiKey=2c2f766fc07d4bfa968ab5ef96cfa837",
                New.class);
        return getNew;
    }

    public List<News> getAllNews(){
        return newsRepository.getAllNews();
    }

    /*
    save news to database. Result are limited - too slow is adding
     */

    public void saveNews(){
        int result = 5;
        for(int i = 0; i < result; i++){
            System.out.println(i);
            newsRepository.saveNews(i,
                    getNews().getArticles().get(i).getAuthor(),
                    getNews().getArticles().get(i).getTitle(),
                    getNews().getArticles().get(i).getDescription(),
                    getNews().getArticles().get(i).getUrl(),
                    getNews().getArticles().get(i).getPublishedAt());
        }
    }

    public News getOneNew(int id){
        return newsRepository.getOneNewsById(id);
    }

    public void updateNews(String author, String description, long id){
        newsRepository.updateNews(author, description, id);
    }
}
