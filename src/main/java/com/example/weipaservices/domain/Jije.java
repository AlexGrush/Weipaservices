package com.example.weipaservices.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jije {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jije_id;
    private String jijepname;
    private String category;
    private String manufacture;
    private boolean hasNicotine;
    private Long Price;


    public Integer getJije_id() {
        return jije_id;
    }

    public void setJije_id(Integer jije_id) {
        this.jije_id = jije_id;
    }

    public String getJijepname() {
        return jijepname;
    }

    public void setJijepname(String jijepname) {
        this.jijepname = jijepname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isHasNicotine() {
        return hasNicotine;
    }

    public void setHasNicotine(boolean hasNicotine) {
        this.hasNicotine = hasNicotine;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
