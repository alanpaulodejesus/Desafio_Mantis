package TestLogin;

import Core.Propriedades;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;


public class LoginValidoComJavaScriptTest {


    LoginPage login = new LoginPage();


    public LoginValidoComJavaScriptTest() throws Exception {
    }



    @Before
    public void setUp() throws Exception {
        getDriver().get(Propriedades.URL);
        startRelatorio();
    }


    @Test
    public void realizarLoginValidoComJavaScript() throws Exception {

        login.verificaSite();
        login.preencherCampoUsernameComJavaScript();
        login.acionarComandoEntrarComJavaScript();
        login.preencherCampoSenhaComJavaScript();
        login.acionarComandoEntrarComJavaScript();

    }

    @After
    public void tearDown() throws Exception {

        login.registrarLoginValido();
        Assert.assertTrue(login.validarAcessoLogin());
        login.realizarLogoutComJavaScript();
        closeRelatorio();

    }

}
