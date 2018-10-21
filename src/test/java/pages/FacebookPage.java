package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {


    public FacebookPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.NAME, using = "email")
    public WebElement userNameTxt;

    @FindBy(how = How.NAME, using = "pass")
    public WebElement passwordTxt;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[2]/td[3]/label[1]/input[1]")
    public WebElement loginBtn;


    @FindBy(how = How.NAME, using = "xhpc_message")
    public WebElement statusTextArea;


    @FindBy(how = How.XPATH, using = "//div[@class='_6c0o']//button[@value='1']")
    public WebElement shareBtn;

    @FindBy(how = How.CLASS_NAME, using = "_3u17 _3_fz")
    public WebElement closePostSectionBtn;


    public void fillInLoginCredentials(String userName, String password) {
        userNameTxt.sendKeys(userName);
        passwordTxt.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

}
