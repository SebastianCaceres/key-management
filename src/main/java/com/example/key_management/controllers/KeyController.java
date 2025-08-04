package com.example.key_management.controllers;


import com.example.key_management.entities.Key;
import com.example.key_management.entities.View;
import com.example.key_management.services.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class KeyController {
    @Autowired
    private KeyService keyService;

    public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }

    @GetMapping("/")
    public String listKeys(Model model) {
        View view = keyService.getCurrentView();
        List<Key> keys = keyService.getKeys();

        model.addAttribute("keys", keys);
        model.addAttribute("view", view);
        return "index.html";
    }

    @GetMapping("/edit")
    public String editKey(Model model, @RequestParam(name = "keyId") Long id ){
        Key key = keyService.findById(id);

        model.addAttribute("key",key);

        return "edit.html";
    }

    @PostMapping("/edit")
    public String editKeyPost(@ModelAttribute(name = "key") Key key){
        keyService.save(key);
        return "redirect:/";
    }

    @PostMapping("/update-view")
    public String updateView(@ModelAttribute View view) {
        keyService.updateView(view);
        return "redirect:/";
    }

    // methods for issue, return, and other actions (unchanged)
}
