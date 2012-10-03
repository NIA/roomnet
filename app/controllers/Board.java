package controllers;

import models.*;
import play.*;
import play.mvc.*;
import play.data.Form;

import views.html.board.*;

@Security.Authenticated(Secured.class)
public class Board extends Controller {

    static private Form<Message> messageForm = form(Message.class);

    // TODO: make this action accessible for not logged in (but hide form)
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
            Message m = filledForm.get();
            m.author = Secured.currentUser(session());
            m.save();
            return redirect(routes.Board.index());
        }
    }

    public static Result deleteMessage(Long id) {
        Message.ref(id).delete();
        return redirect(routes.Board.index());
    }
}
