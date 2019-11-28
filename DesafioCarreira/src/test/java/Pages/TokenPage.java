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

    public TokenPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }


    public String tokenGerado(){
        return Label.recuperaTexto(tokenGerado);
    }

    public void acionarComandoSair()  {
        Comando.clicar(comandoSairUsuario);
    }

    public void acionarComandoMinhaConta(){
        Comando.clicar(comandoMinhaConta);
    }

    public void acionarComandoTokenApi(){
        Comando.clicar(comandoTokenApi);
    }

    public void preencherCampoNomeToken(String texto){
        CampoTexto.preencher(campoNOmeToken, texto);
    }

    public void acionarComandoCriarToken(){
        Comando.clicar(comandoCriarToken);
    }

    public boolean verificarTokenEmGrid(){
        return Label.textoPresente(tokenEmGrid);
    }

    public void verificarSeExisteToken() throws Exception {

        acionarComandoSair();
        acionarComandoMinhaConta();
        acionarComandoTokenApi();
        GerarTokenTest gerarToken = new GerarTokenTest();
        if(Label.textoPresente(tokenEmGrid)){

        }else{
            gerarToken.gerarToken();
        }
    }

    public void verificarSeExisteTokenParaGerar() throws Exception {

        acionarComandoSair();
        acionarComandoMinhaConta();
        acionarComandoTokenApi();

        RevogarTokenTest revogarToken = new RevogarTokenTest();
        if(Label.textoPresente(tokenEmGrid)){
            revogarToken.revogarToken();
        }else{

        }
    }

    public void acionarComandoRevogarToken(){
        Comando.clicar(comandoRevogarToken);
    }
}
