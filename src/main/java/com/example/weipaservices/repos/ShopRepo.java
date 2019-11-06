package com.example.weipaservices.repos;

import com.example.weipaservices.domain.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopRepo extends CrudRepository<Shop, Integer> {


    List<Shop> findByShopname(String shopname);
}
