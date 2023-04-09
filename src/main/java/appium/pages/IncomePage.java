package appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class IncomePage {
    private AndroidDriver<MobileElement> driver;
    public IncomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By btnMenuIncome = By.id("com.chad.financialrecord:id/btnIncome");
    By categoryTabungan = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[12]/android.widget.LinearLayout/android.widget.TextView");
    By category = By.id("com.chad.financialrecord:id/spCategory");
    By pickDate = By.xpath("//android.view.View[@content-desc=\"05 Maret 2023\"]");
    By btnOkPickDate = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
    By btnCloseBackUpGoogleDriver = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
    By btnAdd = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageButton");
    By dateIncome = By.id("com.chad.financialrecord:id/tvDate");
    By amount = By.id("com.chad.financialrecord:id/etAmount");
    By notes = By.id("com.chad.financialrecord:id/etNote");
    By btnSave = By.id("com.chad.financialrecord:id/btSave");
    By txtCategory = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
    By txtNotes = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
    By txtAmount = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[4]");

    public void btnCloseBackUpGoogleDriver(){
        driver.findElement(btnCloseBackUpGoogleDriver).click();
    }
    public void btnAdd(){
        driver.findElement(btnAdd).click();
    }
    public void setDateExpance(){
        driver.findElement(dateIncome).click();
        driver.findElement(pickDate).click();
        driver.findElement(btnOkPickDate).click();
    }
    public void setCategory(){
        driver.findElement(category).click();
        driver.findElement(categoryTabungan).click();
    }
    public void setAmount(String amount){
        driver.findElement(this.amount).sendKeys(amount);
    }
    public void setNotes(String notes){
        driver.findElement(this.notes).sendKeys(notes);
    }
    public void clickBtnSave(){
        driver.findElement(btnSave).click();
    }
    public String getTextCategory(){
        return driver.findElement(txtCategory).getText();
    }
    public String getTextAmount(){
        return driver.findElement(txtAmount).getText();
    }
    public String getTextNotes(){
        return driver.findElement(txtNotes).getText();
    }
    public void btnMenuIncome(){
        driver.findElement(btnMenuIncome).click();
    }
}
