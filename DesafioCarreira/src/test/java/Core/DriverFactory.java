package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {}

    public static synchronized WebDriver getDriver() {
        if(driver == null) {

            if (Propriedades.browser.name().equals("FIREFOX")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                        "drivers" + File.separator + "geckodriver.exe");

                driver = new FirefoxDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                        "drivers" + File.separator + "chromedriver.exe");

                driver = new ChromeDriver();

            }
        }

        driver.manage().window().maximize();

        return driver;
    }
}
