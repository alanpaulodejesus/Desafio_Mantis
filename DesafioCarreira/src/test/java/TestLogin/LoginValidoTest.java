package TestLogin;

import Core.Propriedades;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;


public class LoginValidoTest {

    LoginPage login = new LoginPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarLoginValido()  {

        login.euPreenchoCampoUsername(Propriedades.USUARIO);
        login.euAcionoComandoEntrar();
        login.euPreenchoCampoSenha(Propriedades.SENHA);
        login.euAcionoComandoEntrar();
        Assert.assertTrue(login.euValidoAcessoLogin());
        //login.euRegistroLoginValido();

    }

    @After
    public void tearDown(){

        login.euRealizoLogout();
    }

}
