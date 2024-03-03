package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTestClass {

    public WebDriver driver;
    public GeneratorPage page;
    @BeforeEach
    public void StartTest(){
        driver = DriverFactory.newEdgeDriver();
        page = GeneratorPage.createNew(driver);
        page.goTo();
    }

    @AfterEach
    public void CloseTest(){
        driver.quit();
    }
}
