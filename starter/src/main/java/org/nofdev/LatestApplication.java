package org.nofdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic
@SpringBootApplication
public class LatestApplication {

    static void main(String[] args) {
        SpringApplication.run(LatestApplication.class, args);
    }

}
