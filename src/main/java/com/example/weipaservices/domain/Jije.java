package com.example.weipaservices.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "JijeT")
public class Jije {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jije_id;
    private String jijepname;
    private String category;
    private String manufacture;
    private boolean hasNicotine;
    private Long price;

    public Jije() {

    }

//    public Set<Shop> getShops() {
//        return shops;
//    }

//    public void setShops(Set<Shop> shops) {
//        this.shops = shops;
//    }

    public Jije(String jijepname, String category, String manufacture, boolean hasNicotine, Long price) {
        this.jijepname = jijepname;
        this.category = category;
        this.manufacture = manufacture;
        this.hasNicotine = true;
        this.price = price;
    }

    @ManyToMany
    @JoinTable(
            name = "JijeToShop",
            joinColumns = {@JoinColumn(name = "jije_id")},
            inverseJoinColumns = {@JoinColumn(name = "shop_id")}
    )
    private Set<Shop> shops =new HashSet<>();


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "shop_id")
//    private Shop jije_id;


    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    public Long getJije_id() {
        return jije_id;
    }

    public void setJije_id(Long jije_id) {
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
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
