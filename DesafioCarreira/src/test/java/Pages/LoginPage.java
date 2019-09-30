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

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euPreenchoCampoUsername(String username)  {
        CampoTexto.preencher(campoUserName,username);
    }

    public void euPreenchoCampoSenha(String password)  {
        CampoTexto.preencher(campoSenha, password);
    }

    public void euAcionoComandoEntrar()  {
        Comando.clicar(comandoEntrar);
    }


    public Boolean euValidoAcessoLogin(){
        return Label.textoPresente(validaAcessoDeUsuario);
    }

    public String euValidoAcessoNegado(){
        return Label.recuperaTexto(validaAcessoNegado);
    }

    public Boolean euValidoLogoutComSucesso(){
        Tempo.aguardar(5, comandoEntrar);
        return Label.textoPresente(comandoEntrar);
    }

    public void euRealizoLogout(){
        Tempo.aguardar(2, comandoSairUsuario);
        Comando.clicar(comandoSairUsuario);
        Tempo.aguardar(1,comandoSair);
        Comando.clicar(comandoSair);
    }

    public void euRegistroLoginInvalido(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoLoginInvalido"+ File.separator +"Login Inválido"+ Generetor.dataHora()+".png");
    }

    public void euRegistroLoginValido(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator +"ArquivoLoginValido"+ File.separator +"Login valido"+ Generetor.dataHora()+".png");
    }
}
