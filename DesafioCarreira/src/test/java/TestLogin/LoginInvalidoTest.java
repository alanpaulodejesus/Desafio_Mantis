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


public class LoginInvalidoTest {

    LoginPage login = new LoginPage();

    public LoginInvalidoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        getDriver().get(Propriedades.URL);
        startRelatorio();
    }

    @Test
    public void realizarLoginInvalido()  {

        login.preencherCampoUsername(Propriedades.USUARIO);
        login.acionarComandoEntrar();
        login.preencherCampoSenha(Propriedades.SENHA_INVALIDA);
        login.acionarComandoEntrar();


    }

    @After
    public void tearDown() throws Exception {

        Assert.assertTrue( login.validarAcessoNegado() );
        login.registrarLoginInvalido();
        closeRelatorio();
    }

}
