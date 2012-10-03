package models;

import javax.persistence.*;
import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import java.util.List;

@Entity
public class User extends Model {
    @Id
    public Long id;

    @Required
    @Column(unique = true)
    public String login;

    // TODO: plaint-text passwords are BAD
    @Required
    public String password;

    @OneToMany(mappedBy="author", cascade=CascadeType.ALL)
    public List<Message> messages;

    public static Finder<Long,User> find = new Finder<>(Long.class, User.class);

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User authenticate(String login, String password) {
        return find.where().eq("login", login).eq("password", password).findUnique();
    }

    public static User findByLogin(String login) {
        return find.where().eq("login", login).findUnique();
    }

    @Override
    public String toString() {
        return login;
    }

}