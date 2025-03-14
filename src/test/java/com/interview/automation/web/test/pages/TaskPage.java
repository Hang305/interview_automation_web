package com.interview.automation.web.test.pages;

import com.interview.automation.Constants;
import com.interview.automation.common.Helper;
import com.interview.automation.page.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BaseWebPage {
    Helper helper = new Helper(driver, Constants.MEDIUM_TIME);
    @FindBy(css = ".calendar-cell__content .view-more .add-new")
    private WebElement btnAddTaskSel;

    @FindBy(css = "#task-id-create-general-task")
    private WebElement btnCreateGeneralTaskSel;

    @FindBy(css = "#task-id-create-progress-photo")
    private WebElement btnCreateProgressPhotoSel;

    @FindBy(css = "#task-id-create-body-metrics")
    private WebElement btnCreateBodyMetricsSel;

    @FindBy(css = ".input--task-name input")
    private WebElement inputTaskNameSel;

    @FindBy(css = ".task--error-message")
    private WebElement txtTaskNameErrorSel;

    @FindBy(css = ".task--noActions")
    private WebElement txtTaskMetricErrorSel;

    @FindBy(css = ".actions__saveClose")
    private WebElement btnSaveAndCloseSel;
    @FindBy(css = ".actions__save")
    private WebElement btnSaveSel;
    @FindBy(css = ".button--back")
    private WebElement btnBackSel;


    @FindBy(css = ".task-card .task-title .title")
    private WebElement txtTitleTaskNameSel;


    @FindBy(css = ".evf-dropdown__trigger")
    private WebElement btnMoreIconSel;
    @FindBy(css = ".task-card")
    private WebElement btnTaskCardSel;
    By btnTaskCard = By.cssSelector(".task-card");
    @FindBy(css = ".task-card .task-title")
    private WebElement eleTaskTitleCardSel;
    @FindBy(css = ".open-task-icon")
    private WebElement openTaskIconSel;
    @FindBy(css = ".action-popup li:nth-child(3)")
    private WebElement btnDeleteCardSel;
    @FindBy(css = ".confirm-yes-button")
    private WebElement btnConfirmYes;

    @FindBy(css = ".confirm-footer button:nth-child(3)")
    private WebElement btnDeleteThisTaskSel;

    @FindBy(css = ".app-navbar__right .open-task-trigger")
    private WebElement btnAddYourTaskSel;

    @FindBy(css = ".list .add_task")
    private WebElement btnAddNewTaskSel;
    @FindBy(css = ".form_button button")
    private WebElement btnAddNewTaskFormSel;
    @FindBy(css = ".error_message")
    private WebElement txtTaskTitleErrorSel;

    @FindBy(css = ".close-button")
    private WebElement btnCloseSel;
    @FindBy(css = ".back-icon")
    private WebElement btnBackIconSel;


    @Step("Click add task view more from a column day")
    public void clickAddTask() {
        helper.hover(btnAddTaskSel);
        helper.waitForElementToBeClickable(btnAddTaskSel);
        btnAddTaskSel.click();
    }

    @Step("Select a general task")
    public void selectGeneralTask() {
        helper.waitForElementToAppear(btnCreateGeneralTaskSel);
        btnCreateGeneralTaskSel.click();
    }

    @Step("Select a progress photo task")
    public void selectProgressPhotoTask() {
        helper.waitForElementToAppear(btnCreateProgressPhotoSel);
        btnCreateProgressPhotoSel.click();
    }

    @Step("Select a body metric task")
    public void selectBodyMetricTask() {
        helper.waitForElementToAppear(btnCreateBodyMetricsSel);
        btnCreateBodyMetricsSel.click();
    }

    @Step("Enter a task name")
    public void enterTaskName(String name) {
        helper.waitForElementToAppear(inputTaskNameSel);
        inputTaskNameSel.sendKeys(name);
    }

    @Step("Clear the task name")
    public void clearTaskName() {
        helper.waitForElementToAppear(inputTaskNameSel);
        inputTaskNameSel.clear();
    }

    @Step("Click on Save and Close button")
    public void clickSaveAndCloseBtn() {
        helper.waitForElementToAppear(inputTaskNameSel);
        btnSaveAndCloseSel.click();
    }

    @Step("Click on Save button")
    public void clickSaveBtn() {
        helper.waitForElementToAppear(btnSaveSel);
        btnSaveSel.click();
    }

    @Step("Click on Back button")
    public void clickBackBtn() {
        helper.waitForElementToAppear(btnBackSel);
        btnBackSel.click();
    }

    @Step("Click on task card ")
    public void clickTaskCard() {
        helper.waitForElementToBeClickable(btnTaskCardSel);
        helper.hoverAndClick(btnTaskCardSel);
    }

    @Step("Get the title task name")
    public String getTitleTaskName() {
        helper.waitForElementToBeVisible(txtTitleTaskNameSel);
        return txtTitleTaskNameSel.getText();
    }

    @Step("Get the error message for the empty task name")
    public String getErrorMessageForEmptyTaskName() {
        helper.waitForElementToAppear(txtTaskNameErrorSel);
        return txtTaskNameErrorSel.getText();
    }

    @Step("Get the error message without selecting a metric")
    public String getErrorMessageWithoutSelectingAMetric() {
        helper.waitForElementToAppear(txtTaskMetricErrorSel);
        return txtTaskMetricErrorSel.getText();
    }

    @Step("Click on open more icon popup")
    public void clickOpenMoreIconPopup() {
        helper.waitForElementToAppear(btnMoreIconSel);
        helper.hoverAndClick(btnMoreIconSel);
    }

    @Step("Click on delete card button")
    public void clickDeleteCard() {
        helper.waitForElementToAppear(btnDeleteCardSel);
        btnDeleteCardSel.click();
    }

    @Step("Click on yes button ")
    public void clickYesBtn() {
        helper.waitForElementToAppear(btnConfirmYes);
        btnConfirmYes.click();
    }

    @Step("Click on delete this task")
    public void clickDeleteThisTaskBtn() {
        btnDeleteThisTaskSel.click();
    }

    @Step("Is task card invisible")
    public boolean isTaskCardInvisible() {
        return helper.waitForElementToBeInvisible(btnTaskCard);
    }

    @Step("Click on close button")
    public void clickCloseBtn() {
        btnCloseSel.click();
    }

    @Step("Add your task from Task icon at header")
    public void addYourTaskFromTaskIcon() {
        helper.hover(btnAddYourTaskSel);
        helper.waitForElementToAppear(btnAddYourTaskSel);
        btnAddYourTaskSel.click();
    }

    @Step("Add a new task button")
    public void addNewTaskBtn() {
        helper.waitForElementToAppear(btnAddNewTaskSel);
        btnAddNewTaskSel.click();
    }

    @Step("Add a new button from form")
    public void addNewTaskFormBtn() {
        helper.waitForElementToAppear(btnAddNewTaskFormSel);
        btnAddNewTaskFormSel.click();
    }

    @Step("Get the error message for the empty your task title")
    public String getErrorMessageForEmptyYourTaskTitle() {
        helper.waitForElementToAppear(txtTaskTitleErrorSel);
        return txtTaskTitleErrorSel.getText();
    }

}
