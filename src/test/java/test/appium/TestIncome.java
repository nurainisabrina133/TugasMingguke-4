package test.appium;

import appium.pages.IncomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestIncome {
    private static AndroidDriver<MobileElement> driver;
    public IncomePage incomePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 2019");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        //capabilities.setCapability("noReset","true");
        capabilities.setCapability("autoGrantPermissions","true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        incomePage = new IncomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        incomePage.btnCloseBackUpGoogleDriver();
    }
    @Test
    public void addIncomeValid(){
        //Step action
        incomePage.btnAdd();
        incomePage.btnMenuIncome();
        incomePage.setDateExpance();
        incomePage.setCategory();
        incomePage.setAmount("50000");
        incomePage.setNotes("Tabungan 50,000");
        incomePage.clickBtnSave();
        //step Validation
        Assert.assertTrue(incomePage.getTextCategory().contains("Tabungan"));
        Assert.assertTrue(incomePage.getTextAmount().contains("50.000"));
        Assert.assertTrue(incomePage.getTextNotes().contains("Tabungan 50,000"));
        delay(2);
    }
    @AfterClass
    public void closeApp(){
        driver.quit();
    }
    public void delay(long second)  {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
