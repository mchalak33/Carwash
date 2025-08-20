package com.car.base;

import com.car.pages.JustDialPage;
import com.car.pages.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CarBaseTest {
    WebDriver driver;
    // Change this to "chrome" or "edge"
    String browser = "edge";
    @BeforeClass
    void setup(){

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-notifications");
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
            options.addArguments("window-size=1920,1080");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","C:\\Users\\2421188\\Downloads\\edgedriver_win64\\msedgedriver.exe");

            EdgeOptions options = new EdgeOptions();
            // Edge does NOT support setExperimentalOption exactly like Chrome, so just add args
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-notifications");
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
            options.addArguments("window-size=1920,1080");

            driver = new EdgeDriver(options);

        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.justdial.com/");

        ((JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
        );

        driver.manage().window().maximize();

    }

    @Test
    void testMayBe(){
        JustDialPage js= new JustDialPage(driver);
        js.clickMayBe();
        js.closePopup();
        js.setSearch("Car Washing Services");
        js.click();
        js.clickTopRated();
    }
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
