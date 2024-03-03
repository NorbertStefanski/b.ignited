package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver newEdgeDriver(){
        return applyCommonSetup(new EdgeDriver());
    }

    public static WebDriver newChromeDriver(){
        return applyCommonSetup(new ChromeDriver());
    }

    private static WebDriver applyCommonSetup(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
