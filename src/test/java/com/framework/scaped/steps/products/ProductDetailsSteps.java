package com.framework.scaped.steps.products;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ProductDetailsSteps {

    @Then("^(?:he|she|they) should see Add to Cart Success Message$")
    public void user_see_success_message() throws IOException {
        Target target = Target.the("Add to Cart Success Message")
                .located(By.xpath("//div[contains(@class,'swal2-popup')]//div[@class='swal2-header']"));
        withCurrentActor(WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(15).seconds());
    }
}
