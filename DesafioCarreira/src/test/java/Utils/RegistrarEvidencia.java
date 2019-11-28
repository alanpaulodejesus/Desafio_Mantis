package Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static Core.DriverFactory.getDriver;

public class RegistrarEvidencia {

    public static void registrar( String arquivo) throws Exception {

        File screenshot=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(screenshot, new File(arquivo));
        }catch (Exception e){
            System.out.println("Ocorreu um erro no momento do print");
        }
    }
}
