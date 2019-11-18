package com.example.weipaservices.repos;

import com.example.weipaservices.domain.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShopRepo extends CrudRepository<Shop, Long> {


    Shop findByShopid(Long shopid);
    List<Shop> findByShopname(String shopname);
}
