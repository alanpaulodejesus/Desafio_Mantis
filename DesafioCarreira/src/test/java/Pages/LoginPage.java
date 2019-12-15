package Pages;

import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.extent;

public class LoginPage {

    @FindBy(name = "username") private WebElement campoUserName;
    @FindBy(name = "password") private WebElement campoSenha;
    @FindBy(xpath = "//input[@value=\"Entrar\"]") private WebElement comandoEntrar;
   //@FindBy(xpath = "//*[text()=\""+Propriedades.USUARIO+"\"]") private WebElement validaAcessoUsuario;
    @FindBy(xpath = "//span[text()=\" MantisBT \"]") private WebElement validaAcessoDeUsuario;
    @FindBy(xpath = "//*[text()=\"Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.\"]")private WebElement validaAcessoNegado;
    @FindBy(linkText = "Sair")private WebElement comandoSair;
    @FindBy(xpath = "//span[@class=\"user-info\"]") private WebElement comandoSairUsuario;

    public static ExtentTest test2=null;
    public static  ExtentTest test1=null;

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


    public Boolean validarAcessoLogin() throws IOException, InterruptedException {

        test1 = extent.createTest( "Realizar Login com Sucesso" );
        if(Label.textoPresente( validaAcessoDeUsuario ))
        {

            test1.log(Status.PASS, "Teste realizado com sucesso");

            test1.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioLogin" + File.separator +"Login valido.png");//+ Generetor.dataHora()+".png");
            extent.flush();
            return true;
        }else {
            test1.log(Status.FAIL, "Ocorreu uma falha no teste");
            test1.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioLogin" + File.separator +"Login valido.png");//+ Generetor.dataHora()+".png");

            extent.flush();
            return false;
        }
    }


    public boolean validarAcessoNegado() throws IOException, InterruptedException {

        test2 = extent.createTest( "Validar Acesso Negado" );
        if(Label.textoPresente( validaAcessoNegado )){

            test2.log(Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                    "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioLogin"+ File.separator +"Login Inválido.png");//+ Generetor.dataHora()+".png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioLogin"+ File.separator +"Login Inválido.png");//+ Generetor.dataHora()+".png");

            extent.flush();
            return false;
        }
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
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioLogin"+ File.separator +"Login Inválido.png");//+ Generetor.dataHora()+".png");
    }

    public void registrarLoginValido() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioLogin" + File.separator +"Login valido.png" );//+ Generetor.dataHora()+".png");
    }


}
