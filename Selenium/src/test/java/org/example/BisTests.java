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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BisTests {

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

    public void openBis(){
        WebElement bis = driver.findElement(By.id("/bis-header-button"));
        bis.click();
    }

    @Test
    public void BisIsClickableAndDisplaysForm(){
       // WebDriver driver = new EdgeDriver();
       // driver.get("https://d2r3v7evrrggno.cloudfront.net/");

        WebElement bis = driver.findElement(By.id("/bis-header-button"));
        WebElement collapse = driver.findElement(By.id("collapse-0"));

        Assert.assertFalse(collapse.isDisplayed());

        bis.click();

        Assert.assertTrue(collapse.isDisplayed());

        //driver.quit();
    }

    @Test
    public void BisFormDisplaysCorrectly(){

        openBis();

        WebElement genderYes = driver.findElement(By.id("/bis-yes-0"));
        WebElement genderNo = driver.findElement(By.id("/bis-no-0"));
        WebElement birthdayYes = driver.findElement(By.id("/bis-yes-1"));
        WebElement birthdayNo = driver.findElement(By.id("/bis-no-1"));
        WebElement date = driver.findElement(By.id("/bis-2"));
        WebElement amount = driver.findElement(By.id("/bis-3"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> amount.isDisplayed());
        Assert.assertTrue(genderYes.isDisplayed());
        Assert.assertTrue(genderNo.isDisplayed());
        Assert.assertTrue(birthdayYes.isDisplayed());
        Assert.assertTrue(birthdayNo.isDisplayed());
        Assert.assertTrue(date.isDisplayed());
        Assert.assertTrue(amount.isDisplayed());

    }

    @Test
    public void DisplaysOutputWhenClicked(){

        openBis();
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
        openBis();
        Wait(1);

        WebElement datePicker = driver.findElement(By.id("/bis-2"));
        Assert.assertTrue(datePicker.isEnabled());

        WebElement radioNo = driver.findElement(By.id("/bis-no-1"));
        radioNo.click();
        Assert.assertFalse(datePicker.isEnabled());
    }

    @Test
    public void MoreInfoShowsMoreInfo(){
        openBis();
        Wait(1);
        WebElement info = driver.findElement(By.id("bis-collapseExample"));
        Assert.assertFalse(info.isDisplayed());
        WebElement infoButton = driver.findElement(By.id("bis"));
        infoButton.click();
        Wait(1);
        Assert.assertTrue(info.isDisplayed());
    }


}

