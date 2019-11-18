package com.example.weipaservices.controller;

import com.example.weipaservices.domain.Jije;
import com.example.weipaservices.domain.Message;
import com.example.weipaservices.domain.Shop;
import com.example.weipaservices.domain.User;
import com.example.weipaservices.repos.JijeRepo;
import com.example.weipaservices.repos.JijeIdRepo;
import com.example.weipaservices.repos.MessageRepo;
import com.example.weipaservices.repos.ShopIdRepo;
import com.example.weipaservices.repos.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebServlet;
import java.util.*;

@Controller
@WebServlet("/myservlet")
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private JijeRepo jijeRepo;
    @Autowired
    private JijeRepo jijeIdRepo;
    @Autowired
    private ShopIdRepo shopIdRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @GetMapping("/shop")
    public String shop(Map<String, Object> model) {
        Iterable<Shop> shops = shopRepo.findAll();
        model.put("shops", shops);
        return "shop";
    }

    @GetMapping("/jije")
    public String jije(Map<String, Object> model) {
        Iterable<Jije> jijes = jijeRepo.findAll();
        model.put("jijes", jijes);
        return "jije";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {

        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);


        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/shop")
    public String addShop(
            @RequestParam String shopname,
            @RequestParam String adress, Map<String, Object> model) {
        Shop shop = new Shop(shopname, adress);
//safsaf
        shopRepo.save(shop);

        Iterable<Shop> shops = shopRepo.findAll();
        model.put("shops", shops);

        return "shop";
    }
//    @PostMapping("/purchase")
//    public String addPurchase(
//            @RequestParam Integer purchase_id ,
//            @RequestParam Integer jije_id ,
//            @RequestParam Integer shop_id ,
//            @RequestParam Integer generalprice, Map<String, Object> model) {
//        Purchase purchase = new Purchase(purchase_id, shop_id);
//
//        shopRepo.save(shop);
//
//        Iterable<Shop> shops = shopRepo.findAll();
//        model.put("shops", shops);
//
//        return "shop";
//    }
    @PostMapping("/jije")
    public String addJije(
            @RequestParam String jijepname,
            @RequestParam String category,
            @RequestParam String manufacture,
            @RequestParam boolean hasNicotine,
            @RequestParam Integer price,
            Map<String, Object> model) {
        Jije jije = new Jije(jijepname, category, manufacture, hasNicotine, price);

        jijeRepo.save(jije);

        Iterable<Jije> jijes = jijeRepo.findAll();
        model.put("jijes", jijes);

        return "jije";
    }
    @GetMapping("/shopeditor")
    public String shopeditor(@RequestParam(required=false,name="shopid") String shopid,Map<String, Object> model) {
       Shop shop = shopRepo.findByShopid(Long.valueOf(shopid));
       Long.valueOf(shopid);
//        shopIdRepo.save(shop);
        model.put("shop", shop);
        return "shopdetail";
    }
    @GetMapping("/jijeeditor")
    public String jijeeditor(@RequestParam(required=false,name="category") String category,Map<String, Object> model) {
        Jije jije = jijeIdRepo.findByCategory(category);
//        shopIdRepo.save(shop);
        model.put("jije", jije);
        return "jijeeditor";
    }

    @PostMapping ("/save")
    public String saveShop(
            @RequestParam Long shopid,
            @RequestParam String shopname,
            @RequestParam String address,
            @RequestParam boolean electroParkingAvailable,
            Map<String, Object> model) {


        Shop shop = shopRepo.findById(shopid).get();
        shop.setShopname(shopname);
        shop.setAddress(address);
        shop.setElectroParkingAvailable(electroParkingAvailable);

//        Jije  jije = new Jije( "trava", "fruktovaya", "Egipet", true , 150);
//        Set<Jije> jijes = shop.getJijes();
//        jijes.add(jije);
//        shop.setJijes(jijes);
        shopRepo.save(shop);
        return "shopdetail";
    }
    @PostMapping ("/delete")
    public String saveShop(
            @RequestParam Long shopid,
            Map<String, Object> model) {

        Shop shop = shopRepo.findById(shopid).get();

        shopRepo.delete(shop);

        return "shopdetail";
    }
    @PostMapping ("/deletejije")
    public String saveJije(
            @RequestParam Long jije_id,
            Map<String, Object> model) {

        Jije jije = jijeRepo.findById(jije_id).get();

        jijeRepo.delete(jije);

        return "jijeeditor";
    }
    @PostMapping ("/savejije")
    public String saveJije(
            @RequestParam Long jije_id,
            @RequestParam String jijepname,
            @RequestParam String category,
            @RequestParam String manufacture,
            @RequestParam boolean hasNicotine,
            @RequestParam Integer price,
            Map<String, Object> model) {


        Jije jije = jijeRepo.findById(jije_id).get();
        jije.setJijepname(jijepname);
        jije.setCategory(category);
        jije.setHasNicotine(hasNicotine);

        jijeRepo.save(jije);
        return "jijeeditor";
    }

//     Shop by ID
//    @GetMapping("/shop")
//    public Shop shop(@RequestParam String id) {
//
//        return Shop;
//    }

//    @PostMapping("/shop")
//    public Shop shop(@RequestParam String id) {
//
//        return Shop;
//    }
//
//    @PutMapping("/shop")
//    public Shop shop(@RequestParam String id) {
//
//        return Shop;
//    }
//
//    @DeleteMapping("/shop")
//    public Shop shop(@RequestParam String id) {
//
//        return Shop;
//    }
}