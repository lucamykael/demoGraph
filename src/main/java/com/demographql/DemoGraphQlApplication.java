package com.demographql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.demographql.repositories")
public class DemoGraphQlApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoGraphQlApplication.class, args);
    }

}
