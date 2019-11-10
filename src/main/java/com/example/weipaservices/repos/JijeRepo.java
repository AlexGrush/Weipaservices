package com.example.weipaservices.repos;

import com.example.weipaservices.domain.Jije;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JijeRepo extends CrudRepository<Jije, Integer> {


    List<Jije> findByCategory (String Category);
}

