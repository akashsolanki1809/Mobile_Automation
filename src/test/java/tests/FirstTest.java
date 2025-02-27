package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.ElementInteractPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    public static AppiumDriver<MobileElement>driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        String url;

         DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                    System.out.println("I am on Android.");
                    desiredCapabilities.setCapability("platformVersion", "13");
                    desiredCapabilities.setCapability("deviceName", "emulator-5554");
                    desiredCapabilities.setCapability("platformName","Android");
                    desiredCapabilities.setCapability("skipUnlock", true);
                    desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
                    desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                    desiredCapabilities.setCapability("noReset", false);
                    url="http://0.0.0.1:4723/wd/hub";
                    driver = new AndroidDriver<MobileElement>(new URL(url), desiredCapabilities);
                    Thread.sleep(3000);
                    System.out.println("Application Started");
                    driver.closeApp();



    }
}
