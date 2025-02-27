package tests;

import base.DriverFactory;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ElementInteractPage;

import java.io.IOException;

public class ElementInteractTest extends DriverFactory {


    @Test(priority = 0)
    public void setUp() throws IOException, ParseException {
        launchApp();
    }

    @Test(priority = 1)
    public void runTest() throws InterruptedException {
        switch (testPlatform){

            case androidapp:
                Assert.assertTrue(elementInteractPage.verifyAndroidElement());
                break;


        }

    }

}
