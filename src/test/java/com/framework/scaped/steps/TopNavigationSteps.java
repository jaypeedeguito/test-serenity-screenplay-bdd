package com.framework.scaped.steps;

import com.framework.scaped.utils.ElementFinder;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;

import static com.framework.scaped.ui.ApplicationHomePage.*;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class TopNavigationSteps {

    @When("^(?:he|she|they) select (.*) from (Products|Hauling|Services) menu bar$")
    public void user_select(String item, String menu) throws IOException {
        Target targetItem = Target.the(item).located(By.xpath("//div[@role='tooltip']//p[contains(text(), '" + item + "')]"));
        Target targetMenu = ElementFinder.getButtonField(menu);
        withCurrentActor(Click.on(targetMenu), Click.on(targetItem));
    }

    @When("^(?:he|she|they) navigates to (Orders|Settings|Favorites) from Account icon$")
    public void user_click_from_account_icon(String menu) throws IOException {
        Target targetMenu = Target.the(menu).located(By.xpath("//div[@role='tooltip']//a[text()='" + menu + "']"));
        withCurrentActor(MoveMouse.to(ACCOUNT_ICON), Click.on(targetMenu));
    }

    @When("^(?:he|she|they) navigates to Cart")
    public void user_navigate_to_cart() {
        withCurrentActor(Click.on(CART_ICON));
    }

    @When("^(?:he|she|they) opens the Notifications")
    public void user_navigate_to_notifications() {
        withCurrentActor(Click.on(NOTIFICATIONS_ICON));
    }

    @When("^(?:he|she|they) logs out from page")
    public void user_logs_out() {
        Target targetMenu = Target.the("Logout").located(By.xpath("//form[@id='logoutForm']"));
        withCurrentActor(MoveMouse.to(ACCOUNT_ICON), Click.on(targetMenu));
    }
}
