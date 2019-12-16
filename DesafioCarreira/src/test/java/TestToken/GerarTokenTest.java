package TestToken;

import Core.Propriedades;
import Core.PropriedadesToken;
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


public class GerarTokenTest {

    LoginValidoTest login = new LoginValidoTest();
    TokenPage token = new TokenPage();
    LoginPage logout = new LoginPage();

    public GerarTokenTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        token.verificarSeExisteTokenParaGerar();
    }


    @Test
    public void gerarToken()  {

        token.acionarComandoSair();
        token.acionarComandoMinhaConta();
        token.acionarComandoTokenApi();
        token.preencherCampoNomeToken(PropriedadesToken.Token);
        token.acionarComandoCriarToken();
        token.tokenGerado();
        token.acionarComandoTokenApi();

    }

    @After
    public void tearDown() throws Exception {

        token.registrarGerarToken();
        Assert.assertTrue(token.verificarTokenEmGrid());
        logout.realizarLogout();
        closeRelatorio();

    }

}
