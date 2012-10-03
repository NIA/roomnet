package controllers;

import play.i18n.Messages;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.*;

public class Application extends Controller {
    // -- Authentication

    public static class Login {

        public String login;
        public String password;

        public String validate() {
            if(User.authenticate(login, password) == null) {
                return Messages.get("invalid_login");
            }
            return null;
        }
    }

    /**
     * Login page.
     */
    public static Result login() {
        return ok(
                login.render(form(Login.class))
        );
    }

    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            String userLogin = loginForm.get().login;
            session(Secured.sessionKey, userLogin);
            flash("success", Messages.get("logged_in", userLogin));
            return redirect(
                    routes.Board.index()
            );
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", Messages.get("logged_out"));
        return redirect(
                routes.Application.login()
        );
    }

    public static Result index() {
        return redirect(routes.Board.index());
    }
  
}