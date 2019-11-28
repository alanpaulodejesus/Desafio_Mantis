package Core;

import Connection.SeleniumHub;
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

        if(Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            if (driver == null) {

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
            }
        }
        if(Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID){
            if (driver == null) {
                SeleniumHub.executaSeleniumGrid();
                DesiredCapabilities cap = null;
                switch (browser) {


                    case CHROME:
                        cap = DesiredCapabilities.chrome();
                        break;
                   case FIREFOX:
                       cap = DesiredCapabilities.firefox();
                        break;
                }

                try {
                    driver = new RemoteWebDriver( new URL( "http://localhost:4443/grid/console" ), cap );
                } catch (MalformedURLException e) {
                    System.out.println( "Parrou aqui" );
                    e.printStackTrace();
                }

            }
        }

        //http://localhost:4443/grid/console
        //http://localhost:4443/wd/hb
        //http://localhost:4443/grid/register
        driver.manage().window().maximize();

        return driver;
    }
}
