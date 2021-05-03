package com.framework.scaped.steps;

import com.framework.scaped.actions.WaitForLoadingIcon;
import com.framework.scaped.questions.PageTitle;
import com.framework.scaped.utils.ElementFinder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.equalTo;


public class VerificationSteps {

    @Then("^(?:he|she|they) should be able to view (.*) Page$")
    public void user_should_be_able_to_view_the_page(String page) {
        withCurrentActor(WaitForLoadingIcon.toDisappear());
        theActorInTheSpotlight()
                .should(seeThat(PageTitle.loaded(),
                        displays("title", equalTo(page))));
    }

    @Then("^(?:he|she|they) should be able to view the labels:$")
    public void user_should_be_able_to_view_labels(DataTable table) throws IOException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            withCurrentActor(WaitUntil.the(ElementFinder.getTextLabel(columns.get("Text Label")), isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                    Ensure.that(ElementFinder.getTextLabel(columns.get("Text Label"))).isDisplayed());
        }
    }

    @Then("^(?:he|she|they) should see the input field (.*) is (blank|notBlank)$")
    public void user_check_input_value_isblank(String field, String status) throws IOException {
        Target target = ElementFinder.getInputField(field);
        withCurrentActor(Check.whether(status.contentEquals("blank"))
                .andIfSo(Ensure.that(target).text().isBlank())
                .otherwise(Ensure.that(target).text().isNotBlank()));
    }

    @Then("^(?:he|she|they) should see the input field (.*) contains value (.*)$")
    public void user_check_input_contains_value(String field, String value) throws IOException {
        Target target = ElementFinder.getInputField(field);
        withCurrentActor(WaitUntil.the(target, hasValue(value)).forNoMoreThan(5).seconds());
    }
}
