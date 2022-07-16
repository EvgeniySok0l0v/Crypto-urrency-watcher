package com.idf.springboot.service;

import com.idf.springboot.dto.CoinDto;
import com.idf.springboot.entity.Coin;
import com.idf.springboot.entity.UserCoin;
import com.idf.springboot.repo.CoinRepo;
import com.idf.springboot.repo.UserCoinRepo;
import com.idf.springboot.utils.PriceComparison;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service
 */
@Service
public class NotifyService {

    @Autowired
    private UserCoinRepo userCoinRepo;
    @Autowired
    private CoinRepo coinRepo;
    private static final String URL = "https://api.coinlore.net/api/ticker/?id=";
    private final RestTemplate restTemplate = new RestTemplate();
    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyService.class);

    /**
     * Method for check price for all user's coins
     */
    private void checkPrice(){
        List<Coin> coinList = (List<Coin>) coinRepo.findAll();
        List<UserCoin> userCoinList = (List<UserCoin>) userCoinRepo.findAll();
        String username = "";
        for (UserCoin userCoin : userCoinList){
            username = userCoin.getId().getUsername();
            for (Coin coin : coinList){
                if(userCoin.getId().getSymbol().equals(coin.getSymbol())){
                    double priceChange = PriceComparison.comparePrice(coin.getPrice(), userCoin.getPrice());
                    if(priceChange < -1){
                        LOGGER.warn("Price:" + coin.getSymbol() + " for " + username + " changed to " + priceChange);
                    }
                    if(priceChange > 1){
                        LOGGER.warn("Price:" + coin.getSymbol() + " for " + username + " changed to " + priceChange);
                    }
                }
            }
        }

    }

    /**
     * Method for update price of coin every 60sec
     */
    @Scheduled(fixedDelay = 60000)
    private void updateExistCoins(){
        List<Coin> coinsFromDb = (List<Coin>) coinRepo.findAll();
        String ids = getIds(coinsFromDb);
        try {
            CoinDto[] coinDtos = restTemplate.getForObject(URL + ids, CoinDto[].class);
            assert coinDtos != null;
            List<CoinDto> coinDtoList = Arrays.stream(coinDtos).collect(Collectors.toList());

            List<Coin> coinList = new ArrayList<>();

            for (CoinDto coinDto : coinDtoList){
                Coin coin = new Coin(
                        Long.valueOf(coinDto.getId()),
                        coinDto.getSymbol(),
                        Double.valueOf(coinDto.getPrice_usd()));

                coinList.add(coin);
            }
            coinRepo.saveAll(coinList);
            LOGGER.info("Info updated");

            checkPrice();
        } catch (Exception exception){
            LOGGER.error("Server error, something wrong with CoinLore.");
        }
    }

    /**
     * Method for get ids of coins
     *
     * @param coins list of coins
     * @return string of ids
     */
    private String getIds(List<Coin> coins){
        StringBuilder ids = new StringBuilder();
        for (Coin coin : coins){
            ids.append(coin.getId()).append(",");
        }
        ids.deleteCharAt(ids.length()-1);
        return ids.toString();
    }
}
