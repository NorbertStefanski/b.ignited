package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GeneratorPage {

    private static final String URL = "https://d2r3v7evrrggno.cloudfront.net/";
    private final WebDriver driver;

    private GeneratorPage(WebDriver driver) {
        this.driver = driver;
    }

    public static GeneratorPage createNew(WebDriver driver){
        return new GeneratorPage(driver);
    }

    public void goTo() {
        driver.get(URL);
    }

    public void openCollapse(Values value){
        List<WebElement> collapse = driver.findElements(By.className("accordion-button"));
        collapse.get(value.value).click();
    }

    public WebElement getCollapse(Values value){
        return driver.findElement(By.id("collapse-" + value.value));
    }

    public WebElement getGenerateButton(Values value){
        return driver.findElement(By.id("/" + value.toString().toLowerCase() + "-generate-button"));
    }

    public WebElement getOutput(Values value){
        return driver.findElement(By.id(value.toString().toLowerCase() + "-text"));
    }

    public WebElement getInfo(Values value){
        return driver.findElement(By.id(value.toString().toLowerCase() + "-collapseExample"));
    }
    public WebElement getInfoButton(Values value){
        return driver.findElement(By.id(value.toString().toLowerCase()));
    }

    public List<WebElement> getInputElements(Values value){
        List<WebElement> forms =  driver.findElements(By.tagName("app-form"));
        WebElement form = forms.get(value.value);
        return form.findElements(By.tagName("input"));
    }

    public List<WebElement> getClearButtons(Values value)
    {
        List<WebElement> forms =  driver.findElements(By.tagName("app-form"));
        WebElement form = forms.get(value.value);
        return form.findElements(By.className("clear-button-pos"));
    }

    public int getOutputAmount(Values value){
        String text = getOutput(value).getText();
        String[] array = text.split("\\s+");
        return array.length;
    }

    public void await(int seconds, WebElement element){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(d -> element.isDisplayed());

    }

    public void scrollDown(int number){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,number).perform();
    }
}
