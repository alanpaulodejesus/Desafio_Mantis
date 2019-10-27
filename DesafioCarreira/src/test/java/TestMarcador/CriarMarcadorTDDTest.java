package TestMarcador;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.MarcadorPage;
import TestLogin.LoginValidoTest;
import jxl.read.biff.BiffException;
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

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();

    }

    @Test
    public void criarMarcadorTDD() throws IOException, BiffException {

        marcador.acionarMenuGerenciar();
        marcador.acionarMenuGerenciaMarcador();
        marcador.preencherMarcadorTDD();


    }

    @After
    public void tearDown(){


        Assert.assertTrue(marcador.verificarMarcadoresTDDEmGrid());
        marcador.excluirMarcadores();
        logout.realizarLogout();
    }
}
