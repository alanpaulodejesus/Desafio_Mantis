package TestToken;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.TokenPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;


public class RevogarTokenTest {

    LoginValidoTest login = new LoginValidoTest();
    LoginPage logout = new LoginPage();
    TokenPage token = new TokenPage();

    public RevogarTokenTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        token.verificarSeExisteToken();
    }


    @Test
    public void revogarToken()  {

        token.acionarComandoRevogarToken();
        token.acionarComandoTokenApi();

    }

    @After
    public void tearDown() throws Exception {

        token.registrarGerarTokenRevogado();
        Assert.assertTrue(token.verificarTokenRevogadoEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }

}
