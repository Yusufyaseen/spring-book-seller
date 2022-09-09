package com.store.springbootbookstore;

import com.store.springbootbookstore.model.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringBootBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookStoreApplication.class, args);
        System.out.println(Role.SYSTEM_MANAGER);
        System.out.println(Role.values().length);
    }

}
