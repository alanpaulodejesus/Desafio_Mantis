package DSL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Combo {

    public static void selecionarCombo(WebElement elemento, String texto) {

        Select seleciona = new Select(elemento);
        seleciona.selectByVisibleText(texto);

    }
}
