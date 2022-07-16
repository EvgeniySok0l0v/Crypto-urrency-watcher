package com.idf.springboot.entity;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class UserCoinKey for composite key for UserCoin class
 */
@IdClass(UserCoinKey.class)
public class UserCoinKey implements Serializable {

    private String username;
    private String symbol;

    /**
     * Constructor for UserCoinKey
     *
     * @param username of user
     * @param symbol of coin
     */
    public UserCoinKey(String username, String symbol) {
        this.username = username;
        this.symbol = symbol;
    }

    public UserCoinKey(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCoinKey that = (UserCoinKey) o;
        return username.equals(that.username)  &&
                symbol.equals(that.symbol);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username, symbol);
    }
}
