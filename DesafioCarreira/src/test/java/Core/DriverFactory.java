package Core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static Core.Propriedades.browser;

public class DriverFactory {

    private static WebDriver driver;

    protected DriverFactory() {}

    public static synchronized WebDriver getDriver() throws Exception {
        if (driver == null) {
            if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {


                if (browser.name().equals( "FIREFOX" )) {
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
            } if(Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
                DesiredCapabilities cap = null;
                switch (Propriedades.browser) {
                    case FIREFOX: cap = DesiredCapabilities.firefox();
                    cap.setPlatform( Platform.WINDOWS ); break;
                    case CHROME: cap = DesiredCapabilities.chrome();
                    cap.setPlatform( Platform.WINDOWS ); break;
                }
                try {
                    URL url = new URL("http://localhost:4444/wd/hub");
                    driver = new RemoteWebDriver(url, cap);
                } catch (MalformedURLException e) {
                    System.err.println("Falha na conexão com o GRID");
                    e.printStackTrace();
                }

            }



                /*
                try {

                    String url = "http://localhost:35602/wd/hub";

                    //SeleniumHub.executaSeleniumGrid();
                    driver = new RemoteWebDriver( new URL( url ), cap );

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                */

                //}


        }
            driver.manage().window().maximize();
            return driver;

        }
}
