package com.framework.scaped.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public final static Target PICKUP = Target.the("'Pickup' radio button")
            .located(By.xpath("//label[.//span[text()='Pickup']]"));
    public final static Target DELIVERY = Target.the("'Delivery' radio button")
            .located(By.xpath("//label[.//span[text()='Delivery']]"));
    public final static Target PICKUP_RADIUS = Target.the("'Pickup Location Radius' dropdown")
            .located(By.xpath("//div[contains(@class, 'MuiFormControl-root')][.//label[.='Pickup Location']]"));
    public final static Target PICKUP_ADDRESS = Target.the("'Pickup Location Address' textbox")
            .located(By.xpath("//input[@class='search-input']"));
    public final static Target PICKUP_DATE = Target.the("'Pickup Date' datepicker")
            .located(By.xpath("//div[contains(@class, 'MuiFormControl-root')][.//label[.='Select Pickup Date']]"));
    public final static Target INSTRUCTIONS = Target.the("'Instructions' textarea")
            .located(By.xpath("//textarea[@name='deliveryInstructions']"));
    public final static Target PICKUP_WINDOW = Target.the("'Pickup Window' dropdown")
            .located(By.xpath("//div[contains(@class, 'MuiFormControl-root')][.//label[.='Select Pickup Window']]"));


    public final static Target DELIVERY_SELECT_ADDRESS = Target.the("'Select Address' button")
            .located(By.xpath("//button[.//span[text()='Select Address']]"));
    public final static Target DELIVERY_DATE = Target.the("'Delivery Date' datepicker")
            .located(By.xpath("//div[contains(@class, 'MuiFormControl-root')][.//label[.='Select Delivery Date']]"));
    public final static Target DELIVERY_WINDOW = Target.the("'Pickup Window' dropdown")
            .located(By.xpath("//div[contains(@class, 'MuiFormControl-root')][.//label[.='Select Delivery Window']]"));

    public final static Target CONTINUE = Target.the("'Continue' button")
            .located(By.xpath("//button[.//span[text()='Continue']]"));
}

