package TestLogin;

import Core.Propriedades;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;


public class LoginInvalidoTest {

    LoginPage login = new LoginPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarLoginInvalido()  {

        login.euPreenchoCampoUsername(Propriedades.USUARIO);
        login.euAcionoComandoEntrar();
        login.euPreenchoCampoSenha(Propriedades.SENHA_INVALIDA);
        login.euAcionoComandoEntrar();
        Assert.assertEquals(login.mensagemAcessoInvalido,login.euValidoAcessoNegado());
        login.euRegistroLoginInvalido();


    }

    @After
    public void tearDown(){
    }

}
