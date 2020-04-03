package com.toedter.ms60min;

import com.toedter.ms60min.thing.Thing;
import com.toedter.ms60min.thing.ThingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ms60minApplication {

    public static void main(String[] args) {
        // when deployed as a docker container to Heroku
        // Heroku sets the PORT environment variable
        // The DYNO environment variable is just to make sure to run in an Heroku environment
        String herokuPort = System.getenv().get("PORT");
        String herokuDyno = System.getenv().get("DYNO");
        if (herokuPort != null && herokuDyno != null) {
            System.getProperties().put("server.port", herokuPort);
        }
        SpringApplication.run(Ms60minApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ThingRepository thingRepository) {
        return args -> {
            
            thingRepository.save(new Thing("1", "VW", "Black", "blabla1111"));
            thingRepository.save(new Thing("2", "Porsche", "Red", "blabla2222"));
            thingRepository.save(new Thing("3", "Mercedes", "Gold", "blabla3333"));
            thingRepository.save(new Thing("4", "Mercedes AMG", "Gold", "cool"));
            thingRepository.save(new Thing("5", "Opel", "Zafira", "the best"));

        };
    }
}
