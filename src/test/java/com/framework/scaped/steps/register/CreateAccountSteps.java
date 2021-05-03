package com.framework.scaped.steps.register;

import com.framework.scaped.questions.PageTitle;
import com.framework.scaped.tasks.Start;
import com.framework.scaped.utils.DateUtil;
import com.framework.scaped.utils.ElementFinder;
import com.framework.scaped.utils.RandomDataGenerator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.framework.scaped.tasks.CreateAccountTask.search_address;
import static com.framework.scaped.ui.CreateAccountPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.hamcrest.Matchers.equalTo;

public class CreateAccountSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^that (.*) is non-registered (?:Homeowner|Contractor|Supplier)$")
    public void user_is_not_registered_member(String actor) {
        theActorCalled(actor)
                .wasAbleTo(Start.openRegistrationPage());
        theActorInTheSpotlight()
                .should(seeThat(PageTitle.loaded(),
                        displays("title", equalTo("Scaped Registration"))));
    }

    @Given("^that (.*) is in the Registration page.$")
    public void user_wants_to_register(String actor) {
        theActorCalled(actor)
                .wasAbleTo(Start.openRegistrationPage());
    }

    @When("^(?:he|she|they) wants to create an account as (Homeowner|Professional|Supplier)$")
    public void user_wants_to_create_account(String accountType) {
        theActorInTheSpotlight()
                .attemptsTo(Check.whether(StringUtils.equals(accountType, "Homeowner")).andIfSo(Click.on(HOMEOWNER)),
                        Check.whether(StringUtils.equals(accountType, "Professional")).andIfSo(Click.on(PROFESSIONAL)),
                        Check.whether(StringUtils.equals(accountType, "Supplier")).andIfSo(Click.on(SUPPLIER)),
                        Click.on(CONTINUE));
    }

    @When("^(?:he|she|they) populates the User Profile$")
    public void user_populate_user_profile(DataTable table) throws IOException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String value = columns.get("value");
            if (columns.get("field").contentEquals("Email address")) {
                String s1 = value.substring(0, value.indexOf("@"));
                value = value.replace(s1, s1 + DateUtil.getTimeStamp());
            }
            if (columns.get("field").contentEquals("First Name")) {
                value = RandomDataGenerator.generateFirstName();
            }
            if (columns.get("field").contentEquals("Last Name")) {
                value = RandomDataGenerator.generateLastName();
            }

            withCurrentActor(Enter.theValue(value).into(ElementFinder.getInputField(columns.get("field"))));
        }
    }

    @When("^(?:he|she|they) selects the platform (.*) in survey how did you hear about us$")
    public void user_provides_info_in_survey(String platform) {
        Target target = Target.the(platform + " radio button")
                .located(By.xpath("//input[@type='radio'][@value='" + platform.toUpperCase() + "']/parent::div"));
        withCurrentActor(WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(5).seconds(),
                Click.on(target));
    }

    @When("^(?:he|she|they) searches (.*) in Address 1 field$")
    public void user_create_account_with_invalid_credentials(String address) {
        withCurrentActor(search_address(address));
    }

    @When("^(?:he|she|they) selects first suggestion result in Address 1 field$")
    public void user_select_first_address1_result() {
        withCurrentActor(Hit.the(Keys.ARROW_DOWN).into(ADDRESS_1), Hit.the(Keys.ENTER).into(ADDRESS_1),
                WaitUntil.angularRequestsHaveFinished());
    }

    @When("^(?:he|she|they) enters Business Name (.*)$")
    public void user_enter_business_name(String businessName) throws IOException {
        withCurrentActor(Enter.theValue(businessName + " " + DateUtil.getTimeStamp())
                .into(ElementFinder.getInputField("Business Name")));
    }

    @When("^(?:he|she|they) selects the Services licensed to offer:$")
    public void user_selects_services(DataTable table) throws IOException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            Target target = ElementFinder.getTextLabel(columns.get("services"));
            withCurrentActor(WaitUntil.the(target, isCurrentlyVisible()).
                    forNoMoreThan(15).seconds(), Click.on(target));
        }
    }

    @Then("^(?:he|she|they) should be able to view the Scaped Registration page.$")
    public void user_should_be_able_to_view_their_account_profile() {
        theActorInTheSpotlight()
                .should(seeThat(PageTitle.loaded(),
                        displays("title", equalTo("Scaped Registration"))));
    }

    @When("^(?:he|she|they) provides PO Box Address:$")
    public void user_provides_po_box(DataTable table) {
        withCurrentActor(CheckCheckbox.of(I_HAVE_A_PO_BOX).afterWaitingUntilEnabled());
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String value = columns.get("value");
            if (columns.get("field").contentEquals("PO BOX#")) {
                withCurrentActor(WaitUntil.the(PO_BOX, isCurrentlyVisible()).forNoMoreThan(5)
                        .seconds(), Enter.theValue(value).into(PO_BOX));
            }
            if (columns.get("field").contentEquals("City")) {
                withCurrentActor(Enter.theValue(value).into(PO_CITY));
            }
            if (columns.get("field").contentEquals("State")) {
                withCurrentActor(new SelectByVisibleTextFromTarget(PO_STATE, value), Click.on(PO_SEARCH_ICON));
            }
            if (columns.get("field").contentEquals("Post Office")) {
                withCurrentActor(WaitUntil.the(PO_LOCATION, isCurrentlyVisible())
                        .forNoMoreThan(30).seconds(), new SelectByVisibleTextFromTarget(PO_LOCATION, value));
            }
        }
    }
}
