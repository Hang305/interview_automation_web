package com.interview.automation.web.test.pages;

import com.interview.automation.Constants;
import com.interview.automation.common.Helper;
import com.interview.automation.page.BaseWebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BaseWebPage {
    Helper helper = new Helper(driver, Constants.MEDIUM_TIME);

    @FindBy(css = ".table__row:nth-child(3) .name-client")
    private WebElement clientNameSel;

    @FindBy(css = ".header-info .client-menu-item:nth-child(3)")
    private WebElement menuTaskSel;


    public DashboardPage openTaskPage(){
        helper.waitForElementToAppear(clientNameSel);
        clientNameSel.click();
        helper.waitForElementToAppear(menuTaskSel);
        menuTaskSel.click();
        return this;
    }
}
