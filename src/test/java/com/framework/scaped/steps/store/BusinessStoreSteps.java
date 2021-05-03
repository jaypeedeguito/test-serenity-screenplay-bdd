package com.framework.scaped.steps.store;

import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class BusinessStoreSteps {
    @When("^(?:he|she|they) selects (.*) product in Store page$")
    public void user_select_product_in_store(String product) {
        Target target = Target.the(product).located(By.xpath("//div[@title='" + product + "']//button"));
        withCurrentActor(Scroll.to(target), Click.on(target));
    }
}