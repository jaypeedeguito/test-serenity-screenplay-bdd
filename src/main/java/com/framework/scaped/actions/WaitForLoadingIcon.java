package com.framework.scaped.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class WaitForLoadingIcon implements Interaction {
    final Target PROGRESS_CIRCLE = Target.the("Progress Circle")
            .locatedBy("//div[not (contains(@style, 'hidden'))]/div[@role='progressbar']");

    @Override
    public <T extends Actor> void performAs(T t) {

        withCurrentActor(Check.whether(the(PROGRESS_CIRCLE), isCurrentlyVisible())
                .andIfSo(WaitUntil.the(PROGRESS_CIRCLE, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()));

    }

    public static WaitForLoadingIcon toDisappear() {
        return new WaitForLoadingIcon();
    }

}
