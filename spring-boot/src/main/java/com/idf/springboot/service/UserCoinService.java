package com.idf.springboot.service;

import com.idf.springboot.entity.Coin;
import com.idf.springboot.entity.UserCoin;
import com.idf.springboot.entity.UserCoinKey;
import com.idf.springboot.repo.CoinRepo;
import com.idf.springboot.repo.UserCoinRepo;
import com.idf.springboot.request.NotifyRequest;
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

    /**
     * Method for save UserCoin
     *
     * @param userCoin UserCoin
     */
    public void save(UserCoin userCoin){
        userCoinRepo.save(userCoin);
    }

    /**
     * Method for create UserCoin
     *
     * @param notifyRequest NotifyRequest
     * @return UserCoin
     */
    public UserCoin createUserCoin(NotifyRequest notifyRequest){
        UserCoin userCoin = new UserCoin();
        Coin coin = coinRepo.getCoinBySymbol(notifyRequest.getSymbol());
        if(coin != null){
            userCoin.setId(new UserCoinKey(notifyRequest.getUsername(),notifyRequest.getSymbol()));
            userCoin.setPrice(coin.getPrice());
        }
        return userCoin;
    }
}
