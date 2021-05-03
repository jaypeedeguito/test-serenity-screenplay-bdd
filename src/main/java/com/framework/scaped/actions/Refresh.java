package com.framework.scaped.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Refresh implements Interaction {

    private Performable steps;
    private String title;

    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().manage().deleteAllCookies();
        //BrowseTheWeb.loaded(actor).getDriver().navigate().refresh();
    }

    public static Refresh theBrowserSession() {
        return new Refresh();
    }
}
