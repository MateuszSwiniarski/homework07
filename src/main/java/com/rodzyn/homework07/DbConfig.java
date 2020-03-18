package com.rodzyn.homework07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE carsList(" +
//                "car_id int" +
//                ",mark varchar(100)" +
//                ",model varchar(100)" +
//                ",color varchar(100)" +
//                ",production_year int)";
//        jdbcTemplate().update(sql);
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE news(" +
//                "news_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY" +
//                ",author VARCHAR(255)" +
//                ",title VARCHAR(255)" +
//                ",description VARCHAR(255)" +
//                ",url VARCHAR(255)" +
//                ",published VARCHAR(255))";
//        jdbcTemplate().update(sql);
//    }
}
