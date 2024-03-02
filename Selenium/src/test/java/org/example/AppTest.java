package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.time.Duration;

public class AppTest {

    WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void StartTest(){
        driver.get("https://d2r3v7evrrggno.cloudfront.net/");
    }

    @AfterEach
    public void CloseTest(){
        driver.quit();
    }

    public void Wait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

    }

    @Test
    public void BisIsClickableAndDisplaysForm(){
       // WebDriver driver = new EdgeDriver();
       // driver.get("https://d2r3v7evrrggno.cloudfront.net/");

        WebElement bis = driver.findElement(By.id("/bis-header-button"));
        bis.click();

        WebElement collapse = driver.findElement(By.id("collapse-0"));
        Assert.assertTrue(collapse.isDisplayed());

        //driver.quit();
    }

    @Test
    public void DisplaysOutputWhenClicked(){

        WebElement bis = driver.findElement(By.id("/bis-header-button"));
        bis.click();
        Wait(1);
        //WebElement amount = driver.findElement(By.id("/bis-3"));
        //amount.sendKeys("5");
        WebElement button = driver.findElement(By.id("/bis-generate-button"));

        Actions actions = new Actions(driver);
        //actions.scrollToElement(button).perform();
        actions.scrollByAmount(0,300).perform();
       // WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(button);
       // actions.scrollFromOrigin(scrollOrigin, 0, 150).perform();

        button.click();
        WebElement output = driver.findElement(By.id("bis-text"));

        Assert.assertTrue(output.isDisplayed());
    }

    @Test
    public void IsBirthdayKnownDisablesDatePicker(){
        WebElement bis = driver.findElement(By.id("/bis-header-button"));
        bis.click();
        Wait(1);

        WebElement datePicker = driver.findElement(By.id("/bis-2"));
        Assert.assertTrue(datePicker.isEnabled());

        WebElement radioNo = driver.findElement(By.id("/bis-no-1"));
        radioNo.click();
        Assert.assertFalse(datePicker.isEnabled());
    }

    @Test
    public void MoreInfoShowsMoreInfo(){
        WebElement bis = driver.findElement(By.id("/bis-header-button"));
        bis.click();
        Wait(1);
        WebElement info = driver.findElement(By.id("bis-collapseExample"));
        Assert.assertFalse(info.isDisplayed());
        WebElement infoButton = driver.findElement(By.id("bis"));
        infoButton.click();
        Assert.assertTrue(info.isDisplayed());
    }


}

