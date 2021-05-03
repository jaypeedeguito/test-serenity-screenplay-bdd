package com.framework.scaped.steps.search;

import com.framework.scaped.tasks.SearchProductTask;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SearchSteps {
    @When("^(?:he|she|they) selects to shop (.*) store in Search Results page$")
    public void user_shop_store(String store) {
        Target target = Target.the(store).located(By.xpath("//h6[text()='" + store + "']/ancestor::div[contains(@class,'MuiGrid-item')]/following-sibling::div/a"));
        withCurrentActor(Scroll.to(target), Click.on(target));
    }

    @When("^(?:he|she|they) add (.*) store in his favorites in Search Results page$")
    public void user_add_to_favorites(String store) {
        Target target = Target.the(store).located(By.xpath("//h6[text()='" + store + "']/ancestor::div[contains(@class,'MuiGrid-item')]/following-sibling::div/button"));
        withCurrentActor(Scroll.to(target), Click.on(target));
    }

    @When("^(?:he|she|they) search (.*) in the (Marketplace|Suppliers|Contractors)$")
    public void user_search(String item, String searchType) throws IOException {
        withCurrentActor(SearchProductTask.searchAndSelect(searchType, item));
    }

    @When("^(?:he|she|they) selects (.*) in the suggested Search Result$")
    public void user_selects_in_search_result(String products) {
        Target target = Target.the(products).located(By.xpath("//div[@class='item-results'][.='" + products + "']"));
        withCurrentActor(WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(30).seconds(), Click.on(target));
    }

}