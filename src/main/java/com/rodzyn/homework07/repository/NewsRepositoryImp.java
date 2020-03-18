package com.rodzyn.homework07.repository;

import com.rodzyn.homework07.model.news.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsRepositoryImp implements NewsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public List<News> getAllNews() {
        List<News> newsList = new ArrayList<>();
        String sql = "SELECT * FROM news";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> newsList.add(new News(
                Long.parseLong(String.valueOf(element.get("news_id"))),
                String.valueOf(element.get("author")),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("description")),
                String.valueOf(element.get("url")),
                String.valueOf(element.get("published"))
        )));
        return newsList;
    }

    @Override
    public void editNews(News newNew) {
        String sql = "UPDATE news SET news.title = ?, news.description = ?, news.published = ?";
        jdbcTemplate.update(sql, newNew.getTitle(), newNew.getDescription(), newNew.getPublished());
    }

    @Override
    public void deleteNewsById(long id) {
        String sql = "DELETE FROM news WHERE news.news_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public News getOneNewsById(long id) {
        String sql = "SELECT * FROM news WHERE news_id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> new News(
                resultSet.getLong("news_id"),
                resultSet.getString("author"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getString("url"),
                resultSet.getString("published")
        ), id);
    }

    @Override
    public void saveNews(long newId, String author, String title, String description, String url, String published) {
        News news = new News(author, title, description, url, published);
        String sql = "INSERT INTO news VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, news.getNewsId(), news.getAuthor(), news.getTitle(),
                news.getDescription(), news.getUrl(), news.getPublished());
    }

    @Override
    public void deleteAll() {
        String sql = "TRUNCATE news";
        jdbcTemplate.update(sql);
    }

    @Override
    public void updateNews(String author, String description, long newId) {
        String sql = "UPDATE news SET author = ?, description = ? WHERE news_id = ?";
        jdbcTemplate.update(sql, author, description, newId);
    }


}
