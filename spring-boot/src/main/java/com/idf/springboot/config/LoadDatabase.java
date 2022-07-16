package com.idf.springboot.config;

import com.idf.springboot.entity.Coin;
import com.idf.springboot.repo.CoinRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class for initDatabase values
 */
@Configuration
public class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CoinRepo repository) {

        return args -> {
            LOGGER.info("Preloading " + repository.save(new Coin(90L, "BTC", 0.0)));
            LOGGER.info("Preloading " + repository.save(new Coin(80L, "ETH", 0.0)));
            LOGGER.info("Preloading " + repository.save(new Coin(48543L, "SOL", 0.0)));
        };
    }
}
