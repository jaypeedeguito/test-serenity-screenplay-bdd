package com.framework.scaped.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:login.page")
public class ApplicationHomePage extends PageObject {

    public final static Target SEARCHBOX = Target.the("'Search' textbox").located(By.xpath("//input[@id='autosuggest-input']"));
    public final static Target SEARCH_RESULT = Target.the("'Search Result' autosuggest").located(By.xpath("//ul[@class='react-autosuggest__suggestions-list']"));
    public final static Target ACCOUNT_ICON = Target.the("'Account' icon").located(By.xpath("//a[@href='/account']//img"));
    public final static Target CART_ICON = Target.the("'Cart' icon").located(By.xpath("//img[contains(@class, 'CartIcon__StyledImage')]"));
    public final static Target CART_COUNTER = Target.the("'Cart Counter' label").located(By.xpath("//img[@alt='Cart']/following-sibling::span"));
    public final static Target NOTIFICATIONS_ICON = Target.the("'Notification' icon").located(By.xpath("//img[@alt='Notification']"));


}