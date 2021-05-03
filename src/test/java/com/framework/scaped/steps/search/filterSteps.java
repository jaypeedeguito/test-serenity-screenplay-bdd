package com.framework.scaped.steps.search;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static com.framework.scaped.ui.ApplicationHomePage.SEARCH_RESULT;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class filterSteps {

    @When("^(?:he|she|they) filter the (Products|Hauling|Services)$")
    public void user_filter(String filter) throws IOException {
        Target target = Target.the(filter + " filter").located(By.xpath("//span[text()='" + filter + "']/parent::button"));
        withCurrentActor(Scroll.to(target), Click.on(target));
    }

    @Then("^(?:he|she|they) should see suggested product in Search Box$")
    public void user_should_see_suggested_product() throws IOException {
        withCurrentActor(WaitUntil.the(SEARCH_RESULT, isCurrentlyVisible()).forNoMoreThan(15).seconds());
    }

    @Then("^(?:he|she|they) should see filter results for (.*)$")
    public void user_should_see_filter_results(String filter) throws IOException {
        Target target = Target.the("Filter for " + filter)
                .located(By.xpath("//p[text()='" + filter + "']/parent::div/following-sibling::div"));
        withCurrentActor(WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(15).seconds());
    }
}
