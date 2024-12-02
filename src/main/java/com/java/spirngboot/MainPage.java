package com.java.spirngboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("")
@Controller
public class MainPage {

    @Autowired
    ServerStorage serverStorage;

    @GetMapping("")
    public String viewMainPage(Model model) {

        List<ContentClass> contents = serverStorage.getContents();
        model.addAttribute("contents", contents);
        return "main";
    }

    @GetMapping("/{user}")
    public String viewContent(Model model, @PathVariable String user) {
        System.out.println(user);

        List<ContentClass> contents = serverStorage.getContents();
        List<ContentClass> filtered = new ArrayList<>();

        for(ContentClass content : contents){
            if(user.equals(content.getUser())){
                filtered.add(content);
            }
        }

        model.addAttribute("user", user);
        if(!filtered.isEmpty()){
            model.addAttribute("contents", filtered);
        }
        return "contents";
    }

    @PostMapping("")
    public String addContent(@RequestParam String user, @RequestParam String content) {

        System.out.println("User : " + user + ", Content : " + content);

        ContentClass newContent = new ContentClass(user, content);
        serverStorage.addContent(newContent);

        return "redirect:/";
    }
}
