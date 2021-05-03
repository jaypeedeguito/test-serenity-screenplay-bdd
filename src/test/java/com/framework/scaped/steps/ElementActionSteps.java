package com.framework.scaped.steps;

import com.framework.scaped.utils.ElementFinder;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ElementActionSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @When("^(?:he|she|they) enter (.*) into input field (.*)$")
    public void user_wants_to_create_account(String value, String label) throws IOException {
        theActorInTheSpotlight()
                .attemptsTo(Enter.theValue(value).into(ElementFinder.getInputField(label)));
    }

    @When("^(?:he|she|they) clicks the button (.*)$")
    public void user_create_account_with_valid_credentials(String label) throws IOException {
        Target target = ElementFinder.getButtonField(label);
        withCurrentActor(WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(15).seconds(), Scroll.to(target), Click.on(target));
    }
}
