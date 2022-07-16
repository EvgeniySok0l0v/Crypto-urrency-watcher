package com.idf.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Class for UserCoin
 */
@Entity
@Table(name = "user_coin")
@IdClass(UserCoinKey.class)
public class UserCoin {

    @Id
    private String username;
    @Id
    private String symbol;
    private Double price;

    /**
     * Constructor for UserCoin
     *
     * @param username of user
     * @param symbol of coin
     * @param price of coin
     */
    public UserCoin(String username, String symbol, Double price) {
        this.username = username;
        this.symbol = symbol;
        this.price = price;
    }

    public UserCoin(){};

    public UserCoinKey getId(){
        return new UserCoinKey(username,symbol);
    }

    public void setId(UserCoinKey id) {
        this.username = id.getUsername();
        this.symbol = id.getSymbol();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
