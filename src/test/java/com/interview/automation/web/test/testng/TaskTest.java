package com.interview.automation.web.test.testng;

import com.interview.automation.Constants;
import com.interview.automation.common.DataObjectBuilder;
import com.interview.automation.common.Helper;
import com.interview.automation.drivermanager.DriverFactory;
import com.interview.automation.model.User;
import com.interview.automation.web.test.pages.DashboardPage;
import com.interview.automation.web.test.pages.LoginPage;
import com.interview.automation.web.test.pages.TaskPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(AllureReportListener.class)
public class TaskTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TaskPage taskPage;
    private WebDriver driver;
    private Helper helper;
    String taskName="";

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        taskPage = new TaskPage();
        helper = new Helper(driver, Constants.MEDIUM_TIME);
    }

    @Test(description = "Verify that a user can log in successfully with valid credentials.", dataProvider = "userData", priority = 1)
    public void LoginAndGoToTaskPage(User userData) {
        loginPage.open().login(userData.getEmailAddress(), userData.getPassword());
        Assert.assertTrue(helper.waitForUrlToContain("/home/client"), "ERROR: Login Failed");
        dashboardPage.openTaskPage();
        Assert.assertTrue(helper.waitForUrlToContain("/task"), "ERROR: Task page is not displayed");
    }

    @Test(description = "Verify that an user can add a Generate task.", dependsOnMethods = "LoginAndGoToTaskPage")
    public void CreateAGeneralTask() {
        taskName = "General task name";
        taskPage.clickAddTask();
        taskPage.selectGeneralTask();
        taskPage.enterTaskName(taskName);
        taskPage.clickSaveAndCloseBtn();
        Assert.assertEquals(taskPage.getTitleTaskName(), taskName,"ERROR: Title name card does not match");
    }

    @Test(description = "Verify that an user can update a Generate task.", dependsOnMethods = "CreateAGeneralTask")
    public void UpdateTheGeneralTask(){
        taskName = "General task update name";
        taskPage.clickTaskCard();
        taskPage.clearTaskName();
        taskPage.enterTaskName(taskName);
        taskPage.clickSaveBtn();
        helper.waitForNextStep(Constants.SHORT_TIME);
        Assert.assertEquals(taskPage.getTitleTaskName(), taskName,"ERROR: Title name card does not match");
    }

    @Test(description = "Verify that an user can delete a Generate task.", dependsOnMethods = "UpdateTheGeneralTask")
    public void DeleteTheGeneralTask(){
        taskPage.clickOpenMoreIconPopup();
        taskPage.clickDeleteCard();
        taskPage.clickYesBtn();
        Assert.assertTrue(taskPage.isTaskCardInvisible(), "ERROR: Task is not deleted");
    }

    @Test(description = "Verify that an error message should be displayed with task name is empty when creating a general task.", dependsOnMethods = "DeleteTheGeneralTask")
    public void EmptyTaskNameForTheGeneralTask() {
        taskName = "";
        helper.waitForNextStep(Constants.SHORT_TIME);
        taskPage.clickAddTask();
        taskPage.selectGeneralTask();
        taskPage.enterTaskName(taskName);
        taskPage.clickSaveAndCloseBtn();
        Assert.assertEquals(taskPage.getErrorMessageForEmptyTaskName(), Constants.EMPTY_TASK_NAME);
        taskPage.clickBackBtn();
    }

    @Test(description = "Verify that an error message should be displayed without selecting a metric when creating a body metrics task", dependsOnMethods = "DeleteTheGeneralTask")
    public void WithoutSelectingAMetricForTheBoyMetric() {
        taskPage.selectBodyMetricTask();
        taskPage.clickSaveBtn();
        Assert.assertEquals(taskPage.getErrorMessageWithoutSelectingAMetric(), Constants.WITHOUT_SELECTING_A_METRIC);
        taskPage.clickCloseBtn();
    }

    @DataProvider()
    public User[] userData() {
        String jsonFileLocation = "/src/test/resources/test_data/user.json";
        return DataObjectBuilder.buildDataObjectFrom(jsonFileLocation, User[].class);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
