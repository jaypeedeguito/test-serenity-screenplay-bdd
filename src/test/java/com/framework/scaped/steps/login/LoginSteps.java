package com.framework.scaped.steps.login;


import com.framework.scaped.tasks.Start;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static com.framework.scaped.ui.SignInPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class LoginSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^that (.*) is a registered (?:Homeowner|LicensedContractor|Supplier)$")
    public void user_is_a_registered_member(String actor) {
        theActorCalled(actor)
                .wasAbleTo(Start.openLoginPage());
    }

    @When("^(?:he|she|they) logs in with valid credentials$")
    public void user_has_signed_in_with_their_account(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            withCurrentActor(Enter.theValue(columns.get("Username")).into(EMAIL_ADDRESS),
                    Enter.theValue(columns.get("Password")).into(PASSWORD), Click.on(LOGIN));
        }
    }
}
