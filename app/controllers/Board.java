package controllers;

import models.Message;
import play.*;
import play.mvc.*;
import play.data.Form;

import views.html.board.*;

import java.util.Date;

public class Board extends Controller {

    static private Form<Message> messageForm = form(Message.class);

    public static Result index() {
        return ok(index.render(Message.all(), messageForm));
    }

    public static Result createMessage() {
        Form<Message> filledForm = messageForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.board.index.render(Message.all(), filledForm)
            );
        } else {
            filledForm.get().save();
            return redirect(routes.Board.index());
        }
    }

    public static Result deleteMessage(Long id) {
        Message.ref(id).delete();
        return redirect(routes.Board.index());
    }
}
