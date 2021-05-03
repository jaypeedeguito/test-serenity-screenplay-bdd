package com.framework.scaped.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:registration.page")
public class CreateAccountPage extends PageObject {

    public final static Target HOMEOWNER = Target.the("'HOMEOWNER' button")
            .located(By.xpath("//div[@role='radiogroup']//span[text()='Homeowner']"));
    public final static Target PROFESSIONAL = Target.the("'LICENSED CONTRACTOR' button")
            .located(By.xpath("//div[@role='radiogroup']//span[text()='Professional']"));
    public final static Target SUPPLIER = Target.the("'SUPPLIER' button")
            .located(By.xpath("//div[@role='radiogroup']//span[text()='Supplier']"));
    public final static Target CONTINUE = Target.the("'CONTINUE' button")
            .located(By.xpath("//button[text()='Continue']"));

    public final static Target ADDRESS_1 = Target.the("'Address 1' textbox")
            .located(By.xpath("//div[@class='address-autocomplete']//input"));
    public final static Target ADDRESS_1_SUGGESTION = Target
            .the("'Address 1 - Autocomplete Suggestion' label")
            .located(By.xpath("//div[@class='address-autocomplete__autocomplete-container']"));
    public final static Target I_HAVE_A_PO_BOX = Target
            .the("'I have a PO Box' checkbox")
            .located(By.xpath("//label[@class='checkbox-label form-check-label']"));
    public final static Target PO_BOX = Target
            .the("'PO Box' textbox")
            .located(By.xpath("//input[@name='poBox']"));
    public final static Target PO_CITY = Target
            .the("'PO City' textbox")
            .located(By.xpath("//input[@name='poCity']"));
    public final static Target PO_STATE = Target
            .the("'PO State' listbox")
            .located(By.xpath("//select[@name='select-state']"));
    public final static Target PO_LOCATION = Target
            .the("'PO Location' listbox")
            .located(By.xpath("//select[@name='polocation']"));
    public final static Target PO_SEARCH_ICON = Target
            .the("'PO Search' icon")
            .located(By.xpath("//img[@alt='Search']"));




}
