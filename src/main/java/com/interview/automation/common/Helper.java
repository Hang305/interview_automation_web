package com.interview.automation.common;

import com.interview.automation.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Constructor
    public Helper(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeoutInSeconds);
    }

    // Custom method to wait for an element to appear
    public WebElement waitForElementToAppear(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Custom method to wait for an element to be clickable
    public WebElement waitForElementToBeClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForElementToBeInvisible(By element) {
        driver.navigate().refresh();
        return wait.until(driver -> driver.findElements(element).size() == 0);
    }

    // Custom method to wait for a URL to contain a specific text
    public boolean waitForUrlToContain(String partialUrl) {
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForNextStep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void hoverAndClick(WebElement locator) {
        this.actions = new Actions(driver);
        actions.moveToElement(locator).click().perform();
    }

    public void hover(WebElement locator) {
        this.actions = new Actions(driver);
        actions.moveToElement(locator).perform();
    }
}
