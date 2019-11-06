package com.example.weipaservices.domain;

import javax.persistence.*;

@Entity
@Table(name = "ShopT")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shop_id;

    private String shopname;
    private String address;
    private boolean electroParkingAvailable;

    public Integer getShop_id() { return shop_id; }

    public void setShop_id(Integer id) {
        this.shop_id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isElectroParkingAvailable() {
        return electroParkingAvailable;
    }

    public void setElectroParkingAvailable(boolean electroParkingAvailable) {
        this.electroParkingAvailable = electroParkingAvailable;
    }

    public Shop(){
    }

    public Shop(String shopname, String address) {
        this.shopname = shopname;
        this.address = address;
        this.electroParkingAvailable = false;
    }


}
