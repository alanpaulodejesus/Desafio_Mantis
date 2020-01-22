package Utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;

import static Utils.RelatorioExtentReport.extent;

public class RelatórioStatus {

    public static ExtentTest test1=null;


    public void testStatusPass(ExtentTest test1, String textoPng) throws IOException {
        test1.log( Status.PASS, "Test Finalized with sucess");
        test1.addScreenCaptureFromPath(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +textoPng);
        extent.flush();

    }

    public void testStatusFail(ExtentTest test1,String textoPng) throws IOException {
        test1.log(Status.FAIL, "Ocorred a fail in test");
        test1.addScreenCaptureFromPath(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +textoPng);

        extent.flush();
    }

}
