package DSL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.DriverFactory.getDriver;

public class Label {

    public static String recuperaTexto(WebElement texto){

        return texto.getText();
    }

    public static boolean textoPresente(WebElement texto){

        try{
            texto.getText();
            return true;
        } catch (Exception e){
            return false;
        }
    }


    public static boolean textoNaoPresente(WebElement texto){


        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOf(texto));
           texto.getText();
            return false;
        } catch (Exception e){
            return true;
        }
    }

}
