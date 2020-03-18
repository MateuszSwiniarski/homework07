package com.rodzyn.homework07.repository;

import com.rodzyn.homework07.model.news.News;

import java.util.List;

public interface NewsRepository {

    List<News> getAllNews();
    void editNews(News newNew);
    void deleteNewsById(long id);
    News getOneNewsById(long id);
    void saveNews(long news_id, String author, String title, String description, String url, String published);
    void deleteAll();
    void updateNews(String author, String description, long newId);
}
