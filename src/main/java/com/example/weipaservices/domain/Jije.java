package com.example.weipaservices.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Jije {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jijepname;
    private String category;
    private boolean hasNicotine;
    private Long Price;
}