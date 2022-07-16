package com.idf.springboot.controller;

import com.idf.springboot.entity.Coin;
import com.idf.springboot.entity.UserCoin;
import com.idf.springboot.request.NotifyRequest;
import com.idf.springboot.service.CoinService;
import com.idf.springboot.service.UserCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller handling request for coins management
 */
@RestController
@RequestMapping("/api")
public class CryptoCurrencyController {

    @Autowired
    private final CoinService coinService;
    @Autowired
    private final UserCoinService userCoinService;

    /**
     * Constructor for CryptoCurrencyController
     *
     * @param coinService service
     * @param userCoinService service
     */
    public CryptoCurrencyController(CoinService coinService, UserCoinService userCoinService)  {
        this.coinService = coinService;
        this.userCoinService = userCoinService;
    }

    /**
     * Methods for display all coins
     *
     * @return list of Coins
     */
    @GetMapping
    public List<Coin> getAllCoins() {
        return coinService.getAllCoins() ;
    }

    /**
     * Method for get actual price and save coin by id
     *
     * @param id long
     * @return coin from DB
     */
   @GetMapping("/{id}")
    public Coin getCoinById(@PathVariable Long id) {
        coinService.saveCoin(coinService.setCoinById(id));
        return coinService.getCoinById(id);
    }

    /**
     * Method for save coin's price for user
     *
     * @param request consist of username and symbol
     */
    @PostMapping("/notify")
    public void notify(@RequestBody NotifyRequest request){
        UserCoin userCoin = userCoinService.createUserCoin(request);
        userCoinService.save(userCoin);
    }


}
