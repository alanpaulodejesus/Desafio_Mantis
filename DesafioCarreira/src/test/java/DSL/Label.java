package DSL;

import org.openqa.selenium.WebElement;

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

}
