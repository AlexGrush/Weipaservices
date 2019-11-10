package com.example.weipaservices.controller;

import com.example.weipaservices.domain.Jije;
import com.example.weipaservices.domain.Message;
import com.example.weipaservices.domain.Shop;
import com.example.weipaservices.domain.User;
import com.example.weipaservices.repos.JijeRepo;
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
import java.util.Map;
import java.util.Optional;

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

        shopRepo.save(shop);

        Iterable<Shop> shops = shopRepo.findAll();
        model.put("shops", shops);

        return "shop";
    }
    @PostMapping("/jije")
    public String addJije(
            @RequestParam String jijepname,
            @RequestParam String category,
            @RequestParam String manufacture,
            @RequestParam boolean hasNicotine,
            @RequestParam int price,
            Map<String, Object> model) {
        Jije jije = new Jije(jijepname, category, manufacture, hasNicotine, price);

        jijeRepo.save(jije);

        Iterable<Jije> jijes = jijeRepo.findAll();
        model.put("jijes", jijes);

        return "jije";
    }
    @GetMapping("/shopeditor")
    public String shopeditor(@RequestParam(required=false,name="address") String address,Map<String, Object> model) {
        Shop shop = shopIdRepo.findByAddress(address);
//        shopIdRepo.save(shop);
        model.put("shop", shop);
    return "shopdetail";
    }


    // Shop by ID
//    @GetMapping("/shop")
//    public Shop shop(@RequestParam String id) {
//
//        return Shop;
//    }
//
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