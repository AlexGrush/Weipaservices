package com.example.weipaservices.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ShopT")
public class Shop<jijess> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shop_id;

    private String shopname;
    private String address;
    private boolean electroParkingAvailable;

    @ManyToMany
    @JoinTable(
            name = "JijeToShop",
            joinColumns = {@JoinColumn(name = "shop_id")},
            inverseJoinColumns = {@JoinColumn(name = "jije_id")}
    )
    private Set<Jije> jijes =new HashSet<>();

    public Set<Jije> getJijes() {
        return jijes;
    }

    public void setJijes(Set<Jije> jijes) {
        this.jijes = jijes;
    }
//    @OneToMany
//    private Set<jijess> jijess;
//
//    public Integer getShop_id() { return shop_id; }
//
//    public Set<jijess> getJijess() {
//        return jijess;
//    }

//    public void setJijess(Set<jijess> jijess) {
//        this.jijess = jijess;
//    }


    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long id) {
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
