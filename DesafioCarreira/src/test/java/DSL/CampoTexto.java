package DSL;

import org.openqa.selenium.WebElement;

public class CampoTexto {

    public static void preencher(WebElement elemento, String valor) {

        elemento.sendKeys(valor);
    }

    public static void limpar(WebElement elemento) {

        elemento.clear();
    }


}
