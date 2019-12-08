package App.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.domain.Message;
import App.domain.User;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    public Iterable<Message> findAll() {
        return messageRepo.findAll();
    }

    public void save(String text, Integer userId) {
        User user = userRepo.findById(userId).get();
        Message mess = new Message();
        mess.setText(text);
        mess.setUser(user);
        messageRepo.save(mess);

    }

}
