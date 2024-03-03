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
import java.util.List;

public class BisTests extends BaseTestClass {


    @Test
    public void bisIsClickableAndDisplaysForm(){
        WebElement collapse = page.getCollapse(Values.BIS);
        page.openCollapse(Values.BIS);
        Assert.assertTrue(collapse.isDisplayed());
    }

    @Test
    public void bisDoesntDisplayFormUnlessClicked(){
        WebElement collapse = page.getCollapse(Values.BIS);
        Assert.assertFalse(collapse.isDisplayed());
    }

    @Test
    public void bisFormDisplaysCorrectly(){
        page.openCollapse(Values.BIS);

        List<WebElement> inputs = page.getInputElements(Values.BIS);
        WebElement generateButton = page.getGenerateButton(Values.BIS);

        page.await(2, generateButton);

        Assert.assertTrue(inputs.get(0).isDisplayed());
        Assert.assertTrue(inputs.get(1).isDisplayed());
        Assert.assertTrue(inputs.get(2).isDisplayed());
        Assert.assertTrue(inputs.get(3).isDisplayed());
        Assert.assertTrue(inputs.get(4).isDisplayed());
        Assert.assertTrue(inputs.get(5).isDisplayed());
        Assert.assertTrue(generateButton.isDisplayed());

    }

    @Test
    public void DisplaysOutputWhenClicked(){
        page.openCollapse(Values.BIS);
        WebElement generateButton = page.getGenerateButton(Values.BIS);

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,300).perform();
        generateButton.click();

        WebElement output = page.getOutput(Values.BIS);
        Assert.assertTrue(output.isDisplayed());
    }

    @Test
    public void IsBirthdayKnownDisablesDatePicker(){
        page.openCollapse(Values.BIS);
        List<WebElement> inputs = page.getInputElements(Values.BIS);
        WebElement datePicker = inputs.get(4);
        WebElement radioNo = inputs.get(3);

        radioNo.click();

        Assert.assertFalse(datePicker.isEnabled());
    }

    @Test
    public void moreInfoIsHiddenUnlessClicked(){
        page.openCollapse(Values.BIS);
        WebElement info = page.getInfo(Values.BIS);

        Assert.assertFalse(info.isDisplayed());
    }

    @Test
    public void moreInfoShowsMoreInfoOnClick(){
        page.openCollapse(Values.BIS);
        WebElement info = page.getInfo(Values.BIS);
        WebElement infoButton = page.getInfoButton(Values.BIS);

        infoButton.click();

        Assert.assertTrue(info.isDisplayed());

    }

    @Test
    public void outputDisplaysCorrectAmount(){
        page.openCollapse(Values.BIS);

        WebElement button = page.getGenerateButton(Values.BIS);
        List<WebElement> inputs = page.getInputElements(Values.BIS);
        WebElement amount = inputs.get(5);
        amount.sendKeys("5");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,300).perform();
        button.click();

        Assert.assertEquals(5, page.getOutputAmount(Values.BIS));
    }


}

