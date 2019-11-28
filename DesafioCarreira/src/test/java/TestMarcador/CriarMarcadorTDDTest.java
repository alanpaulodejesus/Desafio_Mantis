package TestMarcador;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.MarcadorPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static Core.DriverFactory.getDriver;

public class CriarMarcadorTDDTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage marcador = new MarcadorPage();

    public CriarMarcadorTDDTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();

    }

    // , BiffException exceção tirei da jxl
    @Test
    public void criarMarcadorTDD() throws IOException {

        marcador.acionarMenuGerenciar();
        marcador.acionarMenuGerenciaMarcador();
        marcador.preencherMarcadorTDD();


    }

    @After
    public void tearDown() throws Exception {


        Assert.assertTrue(marcador.verificarMarcadoresTDDEmGrid());
        marcador.excluirMarcadores();
        logout.realizarLogout();
    }
}
