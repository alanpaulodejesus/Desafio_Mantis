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


public class RevogarTokenTest {

    LoginValidoTest login = new LoginValidoTest();
    LoginPage logout = new LoginPage();
    TokenPage token = new TokenPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        token.euVerificoSeExisteToken();
    }


    @Test
    public void revogarToken()  {

        token.euAcionoComandoRevogarToken();
        token.euAcionoComandoTokenApi();

    }

    @After
    public void tearDown(){

        Assert.assertFalse(token.euVerificoTokenEmGrid());
        logout.euRealizoLogout();
    }

}
