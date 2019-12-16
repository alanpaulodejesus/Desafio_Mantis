package Pages;

import Core.PropriedadesToken;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestToken.GerarTokenTest;
import TestToken.RevogarTokenTest;
import Utils.RegistrarEvidencia;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.extent;

public class TokenPage {

    @FindBy(xpath = "//span[@class=\"user-info\"]") private WebElement comandoSairUsuario;
    @FindBy(linkText = "Minha Conta") private WebElement comandoMinhaConta;
    @FindBy(linkText = "Tokens API") private WebElement comandoTokenApi;
    @FindBy(id = "token_name") private WebElement campoNOmeToken;
    @FindBy(xpath = "//input[@value=\"Criar Token API\"]")private WebElement comandoCriarToken;
    @FindBy(xpath = "//div[@class=\"well\"]") private WebElement tokenGerado;
    @FindBy(xpath = "//td[contains(text(),'"+ PropriedadesToken.Token+"')]")private WebElement tokenEmGrid;
    @FindBy(xpath = "//input[@value=\"Revogar\"]") private WebElement comandoRevogarToken;

    public static ExtentTest test2=null;

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

    public boolean verificarTokenEmGrid() throws IOException {
        test2 = extent.createTest( "Gerar Token" );

        if (Label.textoPresente( tokenEmGrid )){

            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Gerar Token.png");
            extent.flush();
            return true;
        }else {
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Gerar Token.png");
            extent.flush();
            return false;
        }

    }

    public boolean verificarTokenRevogadoEmGrid() throws IOException {
        test2 = extent.createTest( "Gerar Token Revogado" );

        if (Label.textoPresente( tokenEmGrid )){

            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Gerar Token Revogado.png");
            extent.flush();
            return false;

        }else {
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Gerar Token Revogado.png");
            extent.flush();
            return true;

        }

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

    public void registrarGerarToken() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Gerar Token.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarGerarTokenRevogado() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Gerar Token Revogado.png" );//+ Generetor.dataHora()+".png");
    }
}
