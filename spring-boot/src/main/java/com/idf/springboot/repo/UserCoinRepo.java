package com.idf.springboot.repo;

import com.idf.springboot.entity.UserCoin;
import com.idf.springboot.entity.UserCoinKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCoinRepo extends CrudRepository<UserCoin, String> {

}
