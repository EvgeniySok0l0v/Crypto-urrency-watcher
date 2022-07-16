package com.idf.springboot.utils;

/**
 * Util class
 */
public class PriceComparison {

    /**
     * Method count difference current price and registered
     *
     * @param actual price of coin
     * @param userPrice price of coin
     * @return double difference
     */
    public static Double comparePrice(Double actual, Double userPrice){
        double onePercent = userPrice/100;
        return (actual - userPrice)/onePercent;
    }
}
