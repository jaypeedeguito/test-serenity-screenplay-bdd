package com.framework.scaped.questions;

import com.framework.scaped.models.PageTitleInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class PageTitle implements Question<PageTitleInformation> {

    @Override
    public PageTitleInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        return new PageTitleInformation(title);
    }

    public static PageTitle loaded(){
        return new PageTitle();
    }
}
