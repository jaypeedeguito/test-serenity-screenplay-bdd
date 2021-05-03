package com.framework.scaped.steps.request_bids;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.framework.scaped.tasks.CheckoutDeliveryTask.*;
import static com.framework.scaped.tasks.CheckoutPickUpTask.*;
import static com.framework.scaped.ui.CheckoutPage.DELIVERY;
import static com.framework.scaped.ui.CheckoutPage.PICKUP;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CheckoutSteps {

    @When("^(?:he|she|they) selects checkout type as (Pickup|Delivery)$")
    public void user_select_checkout_type(String type) {
        theActorInTheSpotlight()
                .attemptsTo(Check.whether(StringUtils.equals(type, "Pickup")).andIfSo(WaitUntil
                        .the(PICKUP, isCurrentlyVisible()).forNoMoreThan(15).seconds(), Click.on(PICKUP)),
                        Check.whether(StringUtils.equals(type, "Delivery")).andIfSo(WaitUntil
                                        .the(DELIVERY, isCurrentlyVisible()).forNoMoreThan(15).seconds(),
                                Click.on(DELIVERY)));
    }

    @When("^(?:he|she|they) populate Pickup details:$")
    public void user_checkout_bids_for_pickup(DataTable table) throws IOException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String radius = "";
        String locAddr = "";
        String pickWindow = "";
        String instruction = "";
        for (Map<String, String> row : rows) {
            radius = row.get("loc_radius");
            locAddr = row.get("loc_address");
            pickWindow = row.get("pick_window");
            instruction = row.get("instruction");
        }

        withCurrentActor(selectPickupRadius(radius), selectPickupAddress(locAddr), selectPickupDateToCurrent(),
                selectPickupWindow(pickWindow), enterPickupInstruction(instruction));
    }

    @When("^(?:he|she|they) populate Delivery details:$")
    public void user_checkout_bids_for_delivery(DataTable table) throws IOException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String pickWindow = "";
        String instruction = "";
        for (Map<String, String> row : rows) {
            pickWindow = row.get("pick_window");
            instruction = row.get("instruction");
        }
        withCurrentActor(selectDeliveryAddress(), selectDeliveryDateToCurrent(),
                selectDeliveryWindow(pickWindow), enterDeliveryInstruction(instruction));
    }
}
