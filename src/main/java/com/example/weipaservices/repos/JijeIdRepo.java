package com.example.weipaservices.repos;

import com.example.weipaservices.domain.Jije;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JijeIdRepo extends CrudRepository<Jije, Long> {


//    Optional<Jije> findByCategory (String category);
}

