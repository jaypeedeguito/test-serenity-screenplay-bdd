package com.framework.scaped.steps.products;

import com.framework.scaped.actions.WaitForLoadingIcon;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class ProductListingSteps {

    @When("^(?:he|she|they) selects (.*) in Product page$")
    public void user_select(String product) throws IOException {
        Target target = Target.the(product).located(By.xpath("//h6[text()='" + product + "']/parent::div/preceding-sibling::button"));
        withCurrentActor(WaitForLoadingIcon.toDisappear(), Click.on(target));
    }
}
