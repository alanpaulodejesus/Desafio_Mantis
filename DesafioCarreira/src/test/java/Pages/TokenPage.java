package Pages;

import Core.PropriedadesToken;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestToken.GerarTokenTest;
import TestToken.RevogarTokenTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class TokenPage {

    @FindBy(xpath = "//span[@class=\"user-info\"]") private WebElement comandoSairUsuario;
    @FindBy(linkText = "Minha Conta") private WebElement comandoMinhaConta;
    @FindBy(linkText = "Tokens API") private WebElement comandoTokenApi;
    @FindBy(id = "token_name") private WebElement campoNOmeToken;
    @FindBy(xpath = "//input[@value=\"Criar Token API\"]")private WebElement comandoCriarToken;
    @FindBy(xpath = "//div[@class=\"well\"]") private WebElement tokenGerado;
    @FindBy(xpath = "//td[contains(text(),'"+ PropriedadesToken.Token+"')]")private WebElement tokenEmGrid;
    @FindBy(xpath = "//input[@value=\"Revogar\"]") private WebElement comandoRevogarToken;

    public TokenPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public String tokenGerado(){
        return Label.recuperaTexto(tokenGerado);
    }

    public void euAcionoComandoSair()  {
        Comando.clicar(comandoSairUsuario);
    }

    public void euAcionoComandoMinhaConta(){
        Comando.clicar(comandoMinhaConta);
    }

    public void euAcionoComandoTokenApi(){
        Comando.clicar(comandoTokenApi);
    }

    public void euPreenchoCampoNomeToken(String texto){
        CampoTexto.preencher(campoNOmeToken, texto);
    }

    public void euAcionoComandoCriarToken(){
        Comando.clicar(comandoCriarToken);
    }

    public boolean euVerificoTokenEmGrid(){
        return Label.textoPresente(tokenEmGrid);
    }

    public void euVerificoSeExisteToken() {

        euAcionoComandoSair();
        euAcionoComandoMinhaConta();
        euAcionoComandoTokenApi();
        GerarTokenTest gerarToken = new GerarTokenTest();
        if(Label.textoPresente(tokenEmGrid)){

        }else{
            gerarToken.gerarToken();
        }
    }

    public void euVerificoSeExisteTokenParaGerar() {

        euAcionoComandoSair();
        euAcionoComandoMinhaConta();
        euAcionoComandoTokenApi();

        RevogarTokenTest revogarToken = new RevogarTokenTest();
        if(Label.textoPresente(tokenEmGrid)){
            revogarToken.revogarToken();
        }else{

        }
    }

    public void euAcionoComandoRevogarToken(){
        Comando.clicar(comandoRevogarToken);
    }
}
