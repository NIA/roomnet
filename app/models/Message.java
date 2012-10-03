package models;

import java.util.Date;
import java.util.List;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Message extends Model {

    @Id
    public Long id;

    @Required
    public String text;

    @ManyToOne
    public User author;

    private Date createdAt;
    public Date getCreatedAt() { return createdAt; }

    public static Finder<Long,Message> find = new Finder<>(Long.class, Message.class);

    public static List<Message> all() {
        List<Message> all = find.orderBy("createdAt DESC").findList();
        // TODO: why the user data is incorrect without it?
        for(Message m : all) {
            m.author.refresh();
        }
        return all;
    }

    @Override
    public void save() {
        createdAt = new Date();
        super.save();
    }

    public static Message ref(Long id) {
        return find.ref(id);
    }
}
