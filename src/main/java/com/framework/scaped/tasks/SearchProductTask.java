package com.framework.scaped.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static com.framework.scaped.ui.ApplicationHomePage.SEARCHBOX;
import static com.framework.scaped.utils.ElementFinder.getTextLabel;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SearchProductTask {

    public static Performable selectSearchType(String type) throws IOException {
        return Click.on(getTextLabel(type));
    }

    public static Performable enterSearchbox(String toSearch) throws IOException {
        return Enter.theValue(toSearch).into(SEARCHBOX);
    }

    /**
     * Task to search product by type and select the first item in the suggested result
     *
     * @param type    - Marketplace|Suppliers|Contractors
     * @param product - any product
     * @return - interaction/performable
     * @throws IOException
     */
    public static Performable search(String type, String product) throws IOException {
        return Interaction.where("Search " + product + " in " + type, selectSearchType(type), enterSearchbox(product));
    }

    /**
     * Task to search product by type and select the item in the suggested result
     *
     * @param type    - Marketplace|Suppliers|Contractors
     * @param product - any valid product
     * @return - interaction/performable
     * @throws IOException
     */
    public static Performable searchAndSelect(String type, String product) throws IOException {
        Target target = Target.the(product)
                .located(By.xpath("//div[@class='item-results'][starts-with(normalize-space(),'" + product + "')] "));
        return Interaction.where("Search and select" + product + " in " + type, selectSearchType(type), enterSearchbox(product),
                WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(30).seconds(), Click.on(target));
    }
}
