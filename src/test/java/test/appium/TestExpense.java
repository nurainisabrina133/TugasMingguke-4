package test.appium;

import appium.pages.ExpensePage;
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

public class TestExpense {
    private static AndroidDriver<MobileElement> driver;
    public ExpensePage expensePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung pro");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        //capabilities.setCapability("noReset","true");
        capabilities.setCapability("autoGrantPermissions","true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        expensePage = new ExpensePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        expensePage.btnCloseBackUpGoogleDriver();
    }
    @Test
    public void addExpanceValid(){
        //Step action
        expensePage.btnAdd();
        expensePage.setDateExpance();
        expensePage.setCategory();
        expensePage.setAmount("50000");
        expensePage.setNotes("Pengeluaran pulsa 50,000");
        expensePage.clickBtnSave();
        //step Validation
        Assert.assertTrue(expensePage.getTextCategory().contains("Pulsa"));
        Assert.assertTrue(expensePage.getTextAmount().contains("50.000"));
        Assert.assertTrue(expensePage.getTextNotes().contains("Pengeluaran pulsa 50,000"));
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
