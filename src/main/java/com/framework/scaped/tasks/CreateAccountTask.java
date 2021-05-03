package com.framework.scaped.tasks;

import com.framework.scaped.ui.CreateAccountPage;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.UncheckCheckbox;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.framework.scaped.ui.CreateAccountPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CreateAccountTask {

    /**
     * Method to search address in Address 1 field.
     *
     * @param address - Address 1
     * @return - Performable
     */
    public static Performable search_address(String address) {
        return Interaction.where("Search Address", Enter.theValue(address).into(ADDRESS_1),
                WaitUntil.the(ADDRESS_1_SUGGESTION, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Hit.the(Keys.ARROW_DOWN).into(ADDRESS_1), Hit.the(Keys.ENTER).into(ADDRESS_1),
                WaitUntil.angularRequestsHaveFinished());
    }

    public static Performable provide_po_box_address() {
        return Interaction.where("Provide PO Box", CheckCheckbox.of(I_HAVE_A_PO_BOX).afterWaitingUntilPresent(),
                WaitUntil.the(ADDRESS_1_SUGGESTION, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Hit.the(Keys.ARROW_DOWN).into(ADDRESS_1), Hit.the(Keys.ENTER).into(ADDRESS_1),
                WaitUntil.angularRequestsHaveFinished());
    }

    /**
     * Method to check/uncheck PO box
     * @param state - true (checked) or false (unchecked)
     * @return Performable
     */
    public static Performable tick_i_have_po_box(boolean state) {
        Performable perform;
        if (state) {
            perform = CheckCheckbox.of(I_HAVE_A_PO_BOX);
        } else {
            perform = UncheckCheckbox.of(I_HAVE_A_PO_BOX);
        }
        return perform;
    }

}
