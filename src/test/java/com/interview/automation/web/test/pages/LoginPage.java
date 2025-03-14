package com.interview.automation.web.test.pages;

import com.interview.automation.page.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Login page
 */
public class LoginPage extends BaseWebPage {

    private String url = "https://dev.everfit.io/";

    @FindBy(css = "input[placeholder='Your Email Address']")
    private WebElement emailAddressSel;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordSel;

    @FindBy(css = "button[type='Submit']")
    private WebElement loginBtnSel;

    @Step("Open Login page")
    public LoginPage open() {
        driver.get(url);
        return this;
    }

    @Step("Login page")
    public void login(String email, String password) {
        emailAddressSel.sendKeys(email);
        passwordSel.sendKeys(password);
        loginBtnSel.click();
    }
}
