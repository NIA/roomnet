package controllers;

import play.*;
import play.i18n.Messages;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

public class Secured extends Security.Authenticator {
    public static final String sessionKey = "login";

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get(sessionKey);
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.login());
    }

    public static String currentUserLogin(Session session) {
        return session.get(sessionKey);
    }

    public static User currentUser(Session session) {
        return User.findByLogin(currentUserLogin(session));
    }
}
