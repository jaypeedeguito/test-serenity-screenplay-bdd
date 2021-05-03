package com.framework.scaped.steps.cart;

import com.framework.scaped.actions.WaitForLoadingIcon;
import com.framework.scaped.utils.ElementFinder;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.util.List;

import static com.framework.scaped.ui.ApplicationHomePage.CART_COUNTER;
import static com.framework.scaped.ui.ApplicationHomePage.CART_ICON;
import static com.framework.scaped.utils.ElementFinder.getButtonField;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CartPageSteps {

    @Then("^(?:he|she|they) should see the Cart Page$")
    public void user_should_see_cart_page() throws IOException {
        withCurrentActor(WaitForLoadingIcon.toDisappear(), Check.whether(the(CART_COUNTER), containsText("0"))
                .andIfSo(Ensure.that(ElementFinder.getTextLabel("Cart has no available items.")).isDisplayed())
                .otherwise(WaitUntil.the(ElementFinder.getTextLabel("MY CART"), isCurrentlyVisible())
                        .forNoMoreThan(15).seconds()));
    }

    @Then("^(?:he|she|they) should see (.*) in the Cart Counter")
    public void user_see_cart_count(String count) {
        withCurrentActor(WaitUntil.the(CART_COUNTER, containsText(count)).forNoMoreThan(15).seconds());
    }

    @When("^(?:he|she|they) remove all from cart$")
    public void user_remove_all_from_cart() throws IOException {
        List<WebElementFacade> element;
        withCurrentActor(Click.on(CART_ICON), WaitForLoadingIcon.toDisappear());
        element = Target.the("Remove")
                .locatedBy("(//button[.='Remove'])").resolveAllFor(theActorInTheSpotlight());
        int size = element.size();
        System.out.println("Size: " + size);
        if (size > 0) {
            System.out.println("Size in if: " + size);
            while (size > 0) {
                size--;
                withCurrentActor(Click.on(getButtonField("Remove")), WaitForLoadingIcon.toDisappear());
                System.out.println("Size in while loop: " + size);
            }
        }
        withCurrentActor(Click.on(getButtonField("Go Back")), WaitForLoadingIcon.toDisappear());
    }

    @When("^(?:he|she|they) add the item to cart$")
    public void user_add_the_item_to_cart() throws IOException {
        withCurrentActor(WaitForLoadingIcon.toDisappear(), Click.on(getButtonField("Add to Cart")),
                WaitForLoadingIcon.toDisappear());
    }
}
