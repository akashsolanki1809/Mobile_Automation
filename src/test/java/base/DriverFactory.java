package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.ElementInteractPage;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver driver = null;
    private final String TEST_PLATFORM = "test.platform";
    String url;
   public ElementInteractPage elementInteractPage;



    public enum TestPlatform {
        androidapp, iOSapp
    }

   public  TestPlatform testPlatform = null;

    public DriverFactory() {

        testPlatform = TestPlatform
                .valueOf(System.getProperty(TEST_PLATFORM) != null ? System.getProperty(TEST_PLATFORM)
                        : TestPlatform.androidapp.toString());
    }


    /**
     * Read Data from Json file
     * @param data
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public  String readDataFromJsonFile(String data) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj=null;
        JSONObject jsonObject=null;
        String filepath = null;

        switch (testPlatform) {
            case androidapp:
                filepath="D:/Demo_Android/Demo_Android/src/main/resources/androidCapabilities.json";
                break;

            case iOSapp:
                filepath="/IdeaProjects/Demo_Android/src/main/resources/iosCapabilities.json";
                break;
        }

        obj = parser.parse(new FileReader(filepath));
        jsonObject = (JSONObject) obj;
        return (String) jsonObject.get(data);
    }

    /**
     * Get device specific capabilities and launch the app.
     */
    public void launchApp() throws IOException, ParseException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    switch (testPlatform) {
        case androidapp:
            System.out.println("I am on Android.");
            desiredCapabilities.setCapability("platformVersion", readDataFromJsonFile("platformVersion"));
            desiredCapabilities.setCapability("deviceName", readDataFromJsonFile("deviceName"));
            desiredCapabilities.setCapability("platformName", readDataFromJsonFile("platformName"));
            desiredCapabilities.setCapability("skipUnlock", readDataFromJsonFile("skipUnlock"));
            desiredCapabilities.setCapability("appPackage", readDataFromJsonFile("appPackage"));
            desiredCapabilities.setCapability("appActivity", readDataFromJsonFile("appActivity"));
            desiredCapabilities.setCapability("noReset", readDataFromJsonFile("noReset"));
            url=readDataFromJsonFile("url");
            driver = new AndroidDriver<MobileElement>(new URL(url), desiredCapabilities);
            break;

        case iOSapp:
            System.out.println("I am on iOS.");
            desiredCapabilities.setCapability("platformName", readDataFromJsonFile("platformName"));
            desiredCapabilities.setCapability("platformVersion", readDataFromJsonFile("platformVersion"));
            desiredCapabilities.setCapability("deviceName", readDataFromJsonFile("deviceName"));
            desiredCapabilities.setCapability("udid", readDataFromJsonFile("udid"));
            desiredCapabilities.setCapability("app", readDataFromJsonFile("app"));
            url=readDataFromJsonFile("url");
            driver = new IOSDriver<MobileElement>(new URL(url), desiredCapabilities);
            break;
    }
    elementInteractPage= PageFactory.initElements(driver,ElementInteractPage.class);
    }


}
