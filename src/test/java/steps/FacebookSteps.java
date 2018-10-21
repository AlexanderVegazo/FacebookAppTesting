package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FacebookPage;

import java.util.List;

public class FacebookSteps extends BaseUtil {

    public BaseUtil base;


    public FacebookSteps(BaseUtil base) {
        this.base = base;
    }


    @Given("^User navigated to facebook login page$")
    public void navigateToFacebookPage() {


        System.out.println("Navigate Facebook login Page");
        base.Driver.navigate().to("https://www.facebook.com/");
    }

    @When("^User fills in Email and Password$")
    public void userFillsInEmailAndPassword(DataTable table) {

        FacebookPage facebookPage = new FacebookPage(base.Driver);

        List<String> credentials = table.raw().get(1);
        facebookPage.fillInLoginCredentials(credentials.get(0), credentials.get(1));

    }

    @And("^User clicks on Log-In Button$")
    public void userClicksOnButton() {
        FacebookPage facebookPage = new FacebookPage(base.Driver);
        facebookPage.clickLogin();


    }


    @And("^User post Status \"([^\"]*)\"$")
    public void sendStatus(String status) {

        FacebookPage facebookPage = new FacebookPage(base.Driver);
        facebookPage.statusTextArea.click();
        facebookPage.statusTextArea.sendKeys(status);
        WebDriverWait wait = new WebDriverWait(base.Driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='1']//span[contains(text(),'Share')]")));
        facebookPage.shareBtn.click();
    }


}
