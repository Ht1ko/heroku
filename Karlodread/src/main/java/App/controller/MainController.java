package App.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import App.config.Pers.PersonDetails;
import App.repos.MessageService;

@Controller
public class MainController {
    @Autowired
    private MessageService messageService;
    
    private Integer userId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((PersonDetails) auth.getPrincipal()).getUser().getId();
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        model.put("messages", messageService.findAll());
        return "main";
    }

    @PostMapping("/")
    public String add(@RequestParam String text, Map<String, Object> model) {
        messageService.save(text, userId());
        return "redirect:/";
    }

}
