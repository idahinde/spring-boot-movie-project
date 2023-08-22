package org.movieticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.movieticket.repository")
public class MovieTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTicketApplication.class, args);
    }

}
