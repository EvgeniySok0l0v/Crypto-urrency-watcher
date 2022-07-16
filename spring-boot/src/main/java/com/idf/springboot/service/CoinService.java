package com.idf.springboot.service;

import com.idf.springboot.dto.CoinDto;
import com.idf.springboot.entity.Coin;
import com.idf.springboot.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Service for Coin
 */
@Service
public class CoinService {
    @Autowired
    private CoinRepo coinRepo;

    private static final String URL = "https://api.coinlore.net/api/ticker/?id=";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Method for get all coins
     *
     * @return list of coins
     */
    public List<Coin> getAllCoins(){
        //updateExistCoins();
        return (List<Coin>) coinRepo.findAll();
    }

    /**
     * Method for save Coin
     *
     * @param coin coin
     */
    public void saveCoin(Coin coin){
        coinRepo.save(coin);
    }

    /**
     * Method for get coin by id
     *
     * @param id of coin
     * @return Coin
     */
    public Coin getCoinById(Long id){
        return coinRepo.getCoinById(id);
    }

    /**
     * Setter for coin data from CoinDto
     *
     * @param id of coin
     * @return Coin
     */
    public Coin setCoinById(Long id){
        Coin coin = new Coin();
        CoinDto coinDto = getCoinDto(id);
        if(coinDto != null){
            coin.setId(Long.valueOf(coinDto.getId()));
            coin.setSymbol(coinDto.getSymbol());
            coin.setPrice(Double.valueOf(coinDto.getPrice_usd()));
        }
        return coin;
    }

    /**
     * Method for get CoinDto
     *
     * @param id of coin
     * @return CoinDto
     */
    private CoinDto getCoinDto(Long id){
        CoinDto[] coinDtos = restTemplate.getForObject(URL + id, CoinDto[].class);
        if(coinDtos != null && coinDtos.length == 1){
            return coinDtos[0];
        }
        return null;
    }
}
