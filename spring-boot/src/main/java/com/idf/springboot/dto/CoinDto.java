package com.idf.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.DataAmount;

import java.io.Serializable;

/**
 * CoinDto class
 */
public class CoinDto implements Serializable {

    private String id;
    private String symbol;
    private String name;
    private String nameid;
    private int rank;
    private String price_usd;
    private String percent_change_24h;
    private String percent_change_1h;
    private String percent_change_7d;
    private String market_cap_usd;
    private String volume24;
    private String volume24_native;
    private String csupply;
    private String price_btc;
    private String tsupply;
    private String msupply;

    public CoinDto(String id, String symbol, String name, String nameid, int rank, String price_usd, String percent_change_24h, String percent_change_1h, String percent_change_7d, String market_cap_usd, String volume24, String volume24_native, String csupply, String price_btc, String tsupply, String msupply) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameid = nameid;
        this.rank = rank;
        this.price_usd = price_usd;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_7d = percent_change_7d;
        this.market_cap_usd = market_cap_usd;
        this.volume24 = volume24;
        this.volume24_native = volume24_native;
        this.csupply = csupply;
        this.price_btc = price_btc;
        this.tsupply = tsupply;
        this.msupply = msupply;
    }
    public CoinDto(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getVolume24() {
        return volume24;
    }

    public void setVolume24(String volume24) {
        this.volume24 = volume24;
    }

    public String getVolume24_native() {
        return volume24_native;
    }

    public void setVolume24_native(String volume24_native) {
        this.volume24_native = volume24_native;
    }

    public String getCsupply() {
        return csupply;
    }

    public void setCsupply(String csupply) {
        this.csupply = csupply;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = price_btc;
    }

    public String getTsupply() {
        return tsupply;
    }

    public void setTsupply(String tsupply) {
        this.tsupply = tsupply;
    }

    public String getMsupply() {
        return msupply;
    }

    public void setMsupply(String msupply) {
        this.msupply = msupply;
    }

    @Override
    public String toString() {
        return this.id + "\n" +this.symbol + "\n" +this.name+ "\n" +this.nameid+ "\n" +this.rank + "\n" +this.price_usd
                + "\n" +this.percent_change_24h+ "\n" +this.percent_change_1h+ "\n" +this.percent_change_7d
                + "\n" +this.market_cap_usd+ "\n" +this.volume24+ "\n" +this.volume24_native+ "\n" +this.csupply
                + "\n" +this.price_btc+ "\n" +this.tsupply+ "\n" +this.msupply;
    }
}
