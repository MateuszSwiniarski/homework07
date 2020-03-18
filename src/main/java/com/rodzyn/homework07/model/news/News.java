package com.rodzyn.homework07.model.news;

public class News {

  private long newsId;
  private String author;
  private String title;
  private String description;
  private String url;
  private String published;

  public News() {
  }

  public News(String author, String title, String description, String url, String published) {
    this.author = author;
    this.title = title;
    this.description = description;
    this.url = url;
    this.published = published;
  }

  public News(long newsId, String author, String title, String description, String url, String published) {
    this.newsId = newsId;
    this.author = author;
    this.title = title;
    this.description = description;
    this.url = url;
    this.published = published;
  }

  public long getNewsId() {
    return newsId;
  }

  public void setNewsId(long newsId) {
    this.newsId = newsId;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  @Override
  public String toString() {
    return "News{" +
            ". news_id'" + newsId + '\'' +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", url='" + url + '\'' +
            ", published='" + published + '\'' +
            '}';
  }
}
