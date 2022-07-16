package com.idf.springboot.repo;

import com.idf.springboot.entity.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends CrudRepository<Coin, String> {
    Coin getCoinById(Long id);

    Coin getCoinBySymbol(String symbol);
}
