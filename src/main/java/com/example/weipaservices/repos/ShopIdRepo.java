package com.example.weipaservices.repos;

import com.example.weipaservices.domain.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShopIdRepo extends CrudRepository<Shop, Integer> {


  Shop findByAddress (String address);


}
