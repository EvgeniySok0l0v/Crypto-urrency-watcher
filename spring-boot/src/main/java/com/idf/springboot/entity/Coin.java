package com.idf.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class for coin
 */
@Entity
@Table(name = "coin")
public class Coin {
    @Id
    private Long id;
    private String symbol;
    private Double price;

    /**
     * Constructor for coin
     *
     * @param id of coin
     * @param symbol of coin
     * @param price of coin
     */
    public Coin(Long id, String symbol, Double price) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
    }

    public Coin(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
