package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AppTest {

    @Test
    public void test(){
        WebDriver driver = new EdgeDriver();
        driver.quit();
    }
}

