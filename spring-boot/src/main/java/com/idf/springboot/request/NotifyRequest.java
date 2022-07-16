package com.idf.springboot.request;

/**
 * Class for NotifyRequest
 */
public class NotifyRequest {

    private String username;
    private String symbol;

    /**
     * Constructor for NotifyRequest
     *
     * @param username of user
     * @param symbol of coin
     */
    public NotifyRequest(String username, String symbol) {
        this.username = username;
        this.symbol = symbol;
    }

    public NotifyRequest(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
