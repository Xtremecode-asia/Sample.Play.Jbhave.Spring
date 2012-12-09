package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(".:: Play 2.0 & Spring's Sample ::.", "Let us do simple math of adding 2 numbers on this page :D"));
    }

}
