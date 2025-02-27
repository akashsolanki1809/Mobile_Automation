package pages;

import actions.Locators;
import base.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

public class ElementInteractPage extends DriverFactory {

    AppiumDriver<MobileElement> appiumDriver;
    Locators loc;

    public ElementInteractPage(WebDriver driver) {
        this.appiumDriver= (AppiumDriver<MobileElement>) driver;
        loc= new Locators(appiumDriver);
    }

    /**
     * This method verify android element is display
     * @return
     */

    public boolean verifyAndroidElement()  {
         loc.appOption.click();
         return true;
    }



}
