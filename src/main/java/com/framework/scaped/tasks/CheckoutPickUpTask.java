package com.framework.scaped.tasks;

import com.framework.scaped.utils.ElementFinder;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import static com.framework.scaped.ui.CheckoutPage.*;

public class CheckoutPickUpTask {

    public static Performable selectPickupRadius(String value) {
        Target radius = Target.the("Radius: " + value)
                .locatedBy("//ul[@role='listbox']//li[text()='" + value + "']");
        return Check.whether(StringUtils.isNotBlank(value)).andIfSo(Click.on(PICKUP_RADIUS), Click.on(radius));
    }

    public static Performable selectPickupAddress(String address) {
        Target tarAddress = Target.the("Address: " + address)
                .locatedBy("//div[contains(@class, 'suggestion-item')][.//*[.='" + address + "']]");
        return Check.whether(StringUtils.isNotBlank(address)).andIfSo(Enter.theValue(address).into(PICKUP_ADDRESS),
                Click.on(tarAddress));
    }

    public static Performable selectPickupDateToCurrent() throws IOException {
        return Interaction.where("Select Current Date", Click.on(PICKUP_DATE),
                Click.on(ElementFinder.getButtonField("OK")));
    }

    public static Performable selectPickupWindow(String value) {
        Target radius = Target.the("Radius: " + value)
                .locatedBy("//ul[@role='listbox']//li[text()='" + value + "']");
        return Check.whether(StringUtils.isNotBlank(value)).andIfSo(Click.on(PICKUP_WINDOW), Click.on(radius));
    }

    public static Performable enterPickupInstruction(String instruction) {
        return Check.whether(StringUtils.isNotBlank(instruction)).andIfSo(Enter.theValue(instruction).into(INSTRUCTIONS));
    }

}
