package App.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import App.config.Pers.PersonDetails;
import App.domain.User;
import App.repos.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("Login:" + login);
        User user = service.getUserByLogin(login);
        if (user != null)
            System.out.println(user.getUsername() + "-" + user.getPassword());
        else
            System.out.println("false");
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        return new PersonDetails(user);
    }
}
