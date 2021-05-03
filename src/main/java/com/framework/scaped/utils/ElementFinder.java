package com.framework.scaped.utils;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;

public class ElementFinder {

    private static PropertyFileReader file = new PropertyFileReader("locator.properties");

    public static Target getInputField(String label) throws IOException {
        String locator = file.getPropValue("input_field_label_1").replace("&&", label).replace("##", "1");
        return Target.the("'" + label + "' textbox").located(By.xpath(locator));
    }

    public static Target getInputField(String label, String index) throws IOException {
        String locator = file.getPropValue("input_field_label_1").replace("&&", label).replace("##", index);
        return Target.the("'" + label + "' textbox").located(By.xpath(locator));
    }

    public static Target getButtonField(String label) throws IOException {
        String locator = file.getPropValue("button_field_label_1").replace("&&", label).replace("##", "1");
        return Target.the("'" + label + "' button").located(By.xpath(locator));
    }

    public static Target getButtonField(String label, String index) throws IOException {
        String locator = file.getPropValue("button_field_label_1").replace("&&", label).replace("##", index);
        return Target.the("'" + label + "' button").located(By.xpath(locator));
    }

    public static Target getTextLabel(String label) throws IOException {
        String locator1 = file.getPropValue("text_label_1").replace("&&", label).replace("##", "1");
//        String locator2 = file.getPropValue("text_label_2").replace("&&", label).replace("##", "1");
//        String locator3 = file.getPropValue("text_label_3").replace("&&", label).replace("##", "1");
//        String finalLocator = locator1 + " | " + locator2 + " | " + locator3;
        return Target.the("'" + label + "' label").located(By.xpath(locator1));
    }

    public static Target getTextLabel(String label, String index) throws IOException {
        String locator1 = file.getPropValue("text_label_1").replace("&&", label).replace("##", index);
//        String locator2 = file.getPropValue("text_label_2").replace("&&", label).replace("##", index);
//        String locator3 = file.getPropValue("text_label_3").replace("&&", label).replace("##", index);
//        String finalLocator = locator1 + " | " + locator2 + " | " + locator3;
        return Target.the("'" + label + "' label").located(By.xpath(locator1));
    }
}
