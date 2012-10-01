package models;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class User extends Model {

    public String login;
    // TODO: plaint-text passwords are BAD
    public String password;

    public static Finder<Long,User> find = new Finder<>(Long.class, User.class);

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User connect(String login, String password) {
        return find.where().eq("login", login).eq("password", password).findUnique();
    }

}