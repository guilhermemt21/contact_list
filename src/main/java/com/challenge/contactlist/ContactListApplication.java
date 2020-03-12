package com.challenge.contactlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ContactListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactListApplication.class, args);
    }

}
