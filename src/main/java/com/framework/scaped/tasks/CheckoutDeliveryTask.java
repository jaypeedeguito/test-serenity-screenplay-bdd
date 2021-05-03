package com.framework.scaped.tasks;

import com.framework.scaped.utils.ElementFinder;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import static com.framework.scaped.ui.CheckoutPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CheckoutDeliveryTask {

    public static Performable selectDeliveryAddress() {
        Target existing_address = Target.the("Address")
                .locatedBy("//div[@role='dialog']//div[@class = 'MuiGrid-root MuiGrid-container']");
        return Interaction.where("Select Existing Address", WaitUntil.the(DELIVERY_SELECT_ADDRESS, isCurrentlyVisible()).
                        forNoMoreThan(15).seconds(), Click.on(DELIVERY_SELECT_ADDRESS),
                Click.on(existing_address));
    }

    public static Performable selectDeliveryDateToCurrent() throws IOException {
        return Interaction.where("Select Current Date", Click.on(DELIVERY_DATE),
                Click.on(ElementFinder.getButtonField("OK")));
    }

    public static Performable selectDeliveryWindow(String value) {
        Target radius = Target.the("Radius: " + value)
                .locatedBy("//ul[@role='listbox']//li[text()='" + value + "']");
        return Check.whether(StringUtils.isNotBlank(value)).andIfSo(Click.on(DELIVERY_WINDOW), Click.on(radius));
    }

    public static Performable enterDeliveryInstruction(String instruction) {
        return Check.whether(StringUtils.isNotBlank(instruction)).andIfSo(Enter.theValue(instruction).into(INSTRUCTIONS));
    }

}
