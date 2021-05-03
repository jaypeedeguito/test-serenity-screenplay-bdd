package com.framework.scaped.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomChromeDriver {

//    @Override
//    public WebDriver newDriver() {
//        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
//        //Added to avoid yellow warning in chrome 35
//        ChromeOptions options = new ChromeOptions();
//
//
//        options.addArguments("no-first-run");
//        options.addArguments("homepage=about:blank");
//        options.addArguments("test-type");
//        options.addArguments("disable-download-notification");
//        options.addArguments("incognito");
////        options.addArguments("headless");
////        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//
//        ChromeDriver chromeDriver = new ChromeDriver(ChromeDriverService.createDefaultService(),options);
//
//        return chromeDriver;
//    }
//
//    @Override
//    public boolean takesScreenshots() {
//        return true;
//    }

}
