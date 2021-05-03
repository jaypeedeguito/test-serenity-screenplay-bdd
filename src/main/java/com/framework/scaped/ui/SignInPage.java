package com.framework.scaped.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage {
    public final static Target EMAIL_ADDRESS = Target.the("'Email Address' textbox").located(By.xpath("//input[@id='username']"));
    public final static Target PASSWORD = Target.the("'Password' textbox").located(By.xpath("//input[@id='password']"));
    public final static Target LOGIN = Target.the("'Login' button").located(By.xpath("//input[@id='submit-btn']"));
    public final static Target FORGOT_PASSWORD = Target.the("'Forgot Password' link").located(By.xpath("//a[@id='forgot-password']"));
    public final static Target REGISTER = Target.the("'Register' link").located(By.xpath("//a[@class='btn-register']"));
}

