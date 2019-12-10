package Pages;

import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import Utils.Generetor;
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
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

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

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
        //return Label.textoPresente(validaAcessoDeUsuario);

        if(Label.textoPresente( validaAcessoDeUsuario ))
        {
            test = extent.createTest( "Realizar Login com Sucesso" );
            test.log(Status.PASS, "Teste realizado com sucesso");
            return true;

        }else {
            test.log(Status.FAIL, "Ocorreu um erro no teste");
            return false;
        }

    }
    public void closeRelatorio()
    {
        extent.flush();

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

    public void startRelatorio() {


        htmlReporter = new ExtentHtmlReporter(System.getProperty( "user.dir" ) + File.separator +
                "src" + File.separator + "test" + File.separator + "resources" + File.separator + "relatorio.html" );

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Desafio de Carreira");
        htmlReporter.config().setReportName("Resultado de Automação de Testes");
        htmlReporter.config().setTheme( Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Automation Tester", "Alan Paulo de Jesus");
        extent.setSystemInfo("Organization", "Base2");


    }

}
