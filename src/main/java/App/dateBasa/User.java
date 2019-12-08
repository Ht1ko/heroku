package App.dateBasa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer user_id;
    
    @OneToMany
    private List<Message> message;
   
    
    private String name;
    private String password;
    public User() {
        
    }public User(String name, String tag) {
        this.name = name;
        this.password = tag;
    }
    public List<Message> getMessage() {
        return message;
    }
    public void setMessage(List<Message> message) {
        this.message = message;
    }
    public Integer getId()
    {
        return user_id;
    }
    public void setId(Integer id)
    {
        this.user_id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

}
