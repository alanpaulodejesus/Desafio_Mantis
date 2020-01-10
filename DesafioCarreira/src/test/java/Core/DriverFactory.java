package Core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class DriverFactory {

    private static WebDriver driver;

    protected DriverFactory() {}

    public static synchronized WebDriver getDriver() throws Exception {

        if (driver == null) {

            if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {

                if (Propriedades.browser.name().equals( "FIREFOX" )) {
                    System.setProperty( "webdriver.gecko.driver", System.getProperty( "user.dir" ) + File.separator +
                            "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                            "drivers" + File.separator + "geckodriver.exe" );

                    driver = new FirefoxDriver();
                } else {
                    System.setProperty( "webdriver.chrome.driver", System.getProperty( "user.dir" ) + File.separator +
                            "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                            "drivers" + File.separator + "chromedriver.exe" );

                    driver = new ChromeDriver();

                }
            }else

            if(Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
               DesiredCapabilities cap = new DesiredCapabilities( );

                switch (Propriedades.browser) {
                    case FIREFOX:

                        cap.setBrowserName("firefox" );
                        FirefoxOptions opt1 = new FirefoxOptions(  );
                        opt1.merge( cap );
                        cap = DesiredCapabilities.firefox();
                        cap.setBrowserName( "firefox" );
                        cap.setPlatform( Platform.WINDOWS ); break;
                    case CHROME:
                        cap.setBrowserName("chrome" );
                        ChromeOptions opt = new ChromeOptions();
                        opt.merge( cap );
                        cap = DesiredCapabilities.chrome();
                        cap.setBrowserName( "chrome" );
                        //cap.setCapability( "marionette", true );
                        cap.setPlatform( Platform.WINDOWS );
                        break;
                }

                try {

                    String nodeURL = "http://localhost:4444/wd/hub";
                    //URL url = new URL("http://localhost:4444/wd/hub");

                    //driver = new RemoteWebDriver(url, cap);
                    driver = new RemoteWebDriver(new URL(nodeURL), cap);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


            }


        }
        driver.manage().window().maximize();

        return driver;

    }


}