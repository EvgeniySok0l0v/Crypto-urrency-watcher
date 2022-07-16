package com.idf.springboot.service;

import com.idf.springboot.entity.Coin;
import com.idf.springboot.entity.UserCoin;
import com.idf.springboot.entity.UserCoinKey;
import com.idf.springboot.repo.CoinRepo;
import com.idf.springboot.repo.UserCoinRepo;
import com.idf.springboot.request.NotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for UserCoin
 */
@Service
public class UserCoinService {

    @Autowired
    private UserCoinRepo userCoinRepo;
    @Autowired
    private CoinRepo coinRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCoinService.class);

    /**
     * Method for save UserCoin
     *
     * @param notifyRequest consist of username and symbol of coin
     */
    public void save(NotifyRequest notifyRequest){
        UserCoin userCoin = createUserCoin(notifyRequest);
        if(userCoin != null) {
            userCoinRepo.save(userCoin);
            LOGGER.info("UserCoin:" + notifyRequest.getSymbol() + " saved.");
        } else {
            LOGGER.info("UserCoin:" + notifyRequest.getSymbol() + " can't be saved.");
        }
    }

    /**
     * Method for create UserCoin
     *
     * @param notifyRequest NotifyRequest
     * @return UserCoin
     */
    private UserCoin createUserCoin(NotifyRequest notifyRequest){
        Coin coin = coinRepo.getCoinBySymbol(notifyRequest.getSymbol());
        if(coin != null){
            UserCoin userCoin = new UserCoin();
            userCoin.setId(new UserCoinKey(notifyRequest.getUsername(),notifyRequest.getSymbol()));
            userCoin.setPrice(coin.getPrice());
            return userCoin;
        } else {
            LOGGER.info("Incorrect symbol:" + notifyRequest.getSymbol());
        }
        return null;
    }
}
