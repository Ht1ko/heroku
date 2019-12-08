package App;

import App.dateBasa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MessageRepository messRepo;

    @GetMapping("/hello")
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping("/hello")
    public String add(@RequestParam String name, @RequestParam String password, Map<String, Object> model) {
        User user = new User(name, password);

        User newUser = userRepo.save(user);
        model.put("user_id", newUser.getId());
        return "writer";
    }

    @PostMapping("/nameSS")
    public String nameS(@RequestParam int user_id, @RequestParam String text, Map<String, Object> model) {
        User user = userRepo.findById(user_id).get();
        Message message = new Message();
        message.setUser(user);
        message.setMessage(text);
        messRepo.save(message);
        Iterable<Message> messages;
        messages = messRepo.findAll();
        model.put("user_id", 0);
        model.put("messages", messages);

        return "writer";
    }
}