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


public class GerarTokenTest {

    LoginValidoTest login = new LoginValidoTest();
    TokenPage token = new TokenPage();
    LoginPage logout = new LoginPage();


    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        token.euVerificoSeExisteTokenParaGerar();
    }


    @Test
    public void gerarToken()  {

        token.euAcionoComandoSair();
        token.euAcionoComandoMinhaConta();
        token.euAcionoComandoTokenApi();
        token.euPreenchoCampoNomeToken(PropriedadesToken.Token);
        token.euAcionoComandoCriarToken();
        token.tokenGerado();
        token.euAcionoComandoTokenApi();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(token.euVerificoTokenEmGrid());
        logout.euRealizoLogout();

    }

}
