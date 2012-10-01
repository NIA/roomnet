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

    private Date createdAt;
    public Date getCreatedAt() { return createdAt; }

    public static Finder<Long,Message> find = new Finder<>(Long.class, Message.class);

    public static List<Message> all() {
        return find.orderBy("createdAt DESC").findList();
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
