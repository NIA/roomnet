package helpers;

import controllers.Secured;
import models.User;
import play.mvc.Http;

public class AuthHelper {
    public static String currentUserLogin() {
        return Secured.currentUserLogin(Http.Context.current().session());
    }

    public static User currentUser() {
        return Secured.currentUser(Http.Context.current().session());
    }
}
