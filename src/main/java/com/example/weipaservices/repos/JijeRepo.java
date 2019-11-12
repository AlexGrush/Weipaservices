package com.example.weipaservices.repos;

import com.example.weipaservices.domain.Jije;
import com.example.weipaservices.domain.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JijeRepo extends CrudRepository<Jije, Long> {

//    Optional<Jije> findById(Long id);
    List<Jije> findByjijepname(String jijepname);
    Jije findByCategory(String category);
}

