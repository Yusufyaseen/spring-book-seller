package com.store.springbootbookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class InitClass implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");
        String sql = "create table if not exists premierleague(id serial not null, name varchar(15) unique, club varchar(15))";
        jdbcTemplate.execute(sql);
        System.out.println("/////////////");
    }
}
