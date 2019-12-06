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

    public LoginInvalidoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        getDriver().get(Propriedades.URL);
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

        Assert.assertEquals(login.mensagemAcessoInvalido,login.validarAcessoNegado());
        login.registrarLoginInvalido();

    }

}
