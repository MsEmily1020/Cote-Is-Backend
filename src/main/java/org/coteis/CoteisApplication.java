package org.coteis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CoteisApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoteisApplication.class, args);
    }
}