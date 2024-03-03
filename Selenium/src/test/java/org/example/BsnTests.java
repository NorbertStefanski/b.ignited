package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BsnTests extends BaseTestClass{

    @Test
    public void bsnIsClickableAndDisplaysForm(){
        WebElement collapse = page.getCollapse(Values.BSN);
        page.openCollapse(Values.BSN);
        Assert.assertTrue(collapse.isDisplayed());
    }

    @Test
    public void bsnDoesntDisplayFormUnlessClicked(){
        WebElement collapse = page.getCollapse(Values.BSN);
        Assert.assertFalse(collapse.isDisplayed());
    }

    @Test
    public void bsnFormDisplaysCorrectly(){
        page.openCollapse(Values.BSN);

        List<WebElement> inputs = page.getInputElements(Values.BSN);
        WebElement generateButton = page.getGenerateButton(Values.BSN);

        page.await(2, generateButton);

        Assert.assertTrue(inputs.get(0).isDisplayed());
        Assert.assertTrue(generateButton.isDisplayed());
    }

    @Test
    public void bsnDisplaysCorrectAmount(){
        page.openCollapse(Values.BSN);

        WebElement button = page.getGenerateButton(Values.BSN);
        List<WebElement> inputs = page.getInputElements(Values.BSN);
        WebElement amount = inputs.get(0);
        amount.sendKeys("5");


        button.click();

        Assert.assertEquals(5, page.getOutputAmount(Values.BSN));
    }

    @Test
    public void moreInfoIsHiddenUnlessClicked(){
        page.openCollapse(Values.BSN);
        WebElement info = page.getInfo(Values.BSN);

        Assert.assertFalse(info.isDisplayed());
    }

    @Test
    public void moreInfoShowsMoreInfoOnClick(){
        page.openCollapse(Values.BSN);
        WebElement info = page.getInfo(Values.BSN);
        WebElement infoButton = page.getInfoButton(Values.BSN);

        infoButton.click();

        Assert.assertTrue(info.isDisplayed());

    }
}
