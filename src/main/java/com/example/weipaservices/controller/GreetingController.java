package com.example.weipaservices.controller;

import com.example.weipaservices.domain.Message;
import com.example.weipaservices.domain.Shop;
import com.example.weipaservices.domain.User;
import com.example.weipaservices.repos.MessageRepo;
import com.example.weipaservices.repos.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.Map;

@Controller
@WebServlet("/myservlet")
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private ShopRepo shopRepo;

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