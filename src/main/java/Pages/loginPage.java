package Pages;

import BaseClass.baseClass;
import Helper.actionHandler;
import Helper.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class loginPage extends baseClass
{
    @FindBy(xpath = "//span[.=\"Sign in\"]")
    private WebElement signinbtn;

    @FindBy(id = "field-email")
    private WebElement email;

    @FindBy(id = "field-password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement loginBtn;

    public loginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void loginPerform() throws InterruptedException
    {
        Reporter.log("Login Test Start");
        log.startTestCase("Start Login Test");
        if(signinbtn != null)
        {
            actionHandler.click(signinbtn);
            email.sendKeys(super.pros.getProperty("email"));
            password.sendKeys(super.pros.getProperty("password"));
            loginBtn.click();
            log.info("Complete Test");
        }
        else
        {
            log.error("Failed Test");
        }
        log.endTestCase("End Login Test");
        Reporter.log("Login Test End");
        Thread.sleep(2000);
    }



}
