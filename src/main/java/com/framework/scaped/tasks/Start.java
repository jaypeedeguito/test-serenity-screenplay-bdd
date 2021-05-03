package com.framework.scaped.tasks;

import com.framework.scaped.ui.ApplicationHomePage;
import com.framework.scaped.ui.CreateAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {
    private String title;
    private String page;
    private ApplicationHomePage homePage;
    private CreateAccountPage createAccountPage;

    public Start(String title, String page) {
        this.title = title;
        this.page = page;
    }

    @Step("{0} starts the app.")
    public <T extends Actor> void performAs(T actor) {
        OnStage.withCurrentActor(Check.whether(StringUtils.equals(page, "LOGIN")).andIfSo(Open.browserOn().thePageNamed("login.page")),
                Check.whether(StringUtils.equals(page, "REGISTRATION")).andIfSo(Open.browserOn().thePageNamed("registration.page")));
    }

    public static Start openLoginPage() {
        return instrumented(Start.class, "Go to Login Page", "LOGIN");
    }

    public static Start openRegistrationPage() {
        return instrumented(Start.class, "Go to Registration Page", "REGISTRATION");
    }
}
