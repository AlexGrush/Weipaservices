package com.example.weipaservices.controller;

import com.example.weipaservices.domain.Message;
import com.example.weipaservices.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        List<Message> messages = messageRepo.findByTag(filter);
        model.put("messages" , messages);

        return "main";
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