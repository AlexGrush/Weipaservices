package com.example.weipaservices.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer purchase_id;
    private Integer shop_id;
    private Integer jije_id;
    private Integer generalprice;

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getJije_id() {
        return jije_id;
    }

    public void setJije_id(Integer jije_id) {
        this.jije_id = jije_id;
    }

    public Integer getGeneralprice() {
        return generalprice;
    }

    public void setGeneralprice(Integer generalprice) {
        this.generalprice = generalprice;
    }
}
