package Pages;

import DSL.Comando;
import DSL.CampoTexto;
import DSL.Label;
import Utils.Generetor;
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static Core.DriverFactory.getDriver;

public class LoginPage {

    @FindBy(name = "username") private WebElement campoUserName;
    @FindBy(name = "password") private WebElement campoSenha;
    @FindBy(xpath = "//input[@value=\"Entrar\"]") private WebElement comandoEntrar;
   //@FindBy(xpath = "//*[text()=\""+Propriedades.USUARIO+"\"]") private WebElement validaAcessoUsuario;
    @FindBy(xpath = "//span[text()=\" MantisBT \"]") private WebElement validaAcessoDeUsuario;
    @FindBy(xpath = "//*[text()=\"Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.\"]")private WebElement validaAcessoNegado;
    @FindBy(linkText = "Sair")private WebElement comandoSair;
    @FindBy(xpath = "//span[@class=\"user-info\"]") private WebElement comandoSairUsuario;

    public static String mensagemAcessoInvalido ="Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";

    public LoginPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void preencherCampoUsername(String username)  {
        Tempo.aguardar(2, campoUserName);
        CampoTexto.preencher(campoUserName,username);
    }

    public void preencherCampoSenha(String password)  {
        Tempo.aguardar(2, campoSenha);
        CampoTexto.preencher(campoSenha, password);
    }

    public void acionarComandoEntrar()  {
        Tempo.aguardar(2, comandoEntrar);
        Comando.clicar(comandoEntrar);
    }


    public Boolean validarAcessoLogin(){
        Tempo.aguardar(2, validaAcessoDeUsuario);
        return Label.textoPresente(validaAcessoDeUsuario);
    }

    public String validarAcessoNegado(){
        Tempo.aguardar(2, validaAcessoNegado);
        return Label.recuperaTexto(validaAcessoNegado);
    }

    public void realizarLogout(){
        Tempo.aguardar(2, comandoSairUsuario);
        Comando.clicar(comandoSairUsuario);
        Tempo.aguardar(1,comandoSair);
        Comando.clicar(comandoSair);
    }

    public void registrarLoginInvalido() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioLogin"+ File.separator +"Login Inválido"+ Generetor.dataHora()+".png");
    }

    public void registrarLoginValido() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioLogin" + File.separator +"Login valido"+ Generetor.dataHora()+".png");
    }
}
