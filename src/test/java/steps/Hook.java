package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;


/**
 * Created by Karthik on 10/17/2016.
 */
public class Hook extends BaseUtil {


    private BaseUtil base;
    private static ChromeDriverService service;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() throws IOException {

/*
        System.out.println("Opening the browser : Firefox driver");
        String firefoxDriverPath = "C:\\Users\\alexa\\IdeaProjects\\SeleniumWithCucucumber\\src\\test\\drivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setBrowserName("gecko");
        caps.setPlatform(Platform.WINDOWS);
        base.Driver = new FirefoxDriver();

        base.Driver.manage().window().maximize();
 */

        //Chrome driver
        System.out.println("Opening the browser : Chrome driver");
        String chromeDriverPath = "C:\\Users\\alexa\\IdeaProjects\\SeleniumWithCucucumber\\src\\test\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        base.Driver = new ChromeDriver(options);
        base.Driver.manage().window().maximize();


    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        base.Driver.close();
        base.Driver.quit();
    }


}
