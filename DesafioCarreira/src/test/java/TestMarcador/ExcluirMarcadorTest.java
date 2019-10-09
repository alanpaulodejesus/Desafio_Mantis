package TestMarcador;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.MarcadorPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class ExcluirMarcadorTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage marcador = new MarcadorPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        marcador.verificoSeExisteMarcador();

    }


    @Test
    public void excluirMarcador(){

        marcador.euAcionoMenuGerenciar();
        marcador.euAcionoMenuGerenciaMarcador();
        marcador.euAcionoMarcadorEmGrid();
        marcador.euAcionoComandoApagarMarcador();
        marcador.euAcionoComandoApagarMarcador();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(marcador.euVerificoMarcadorNaoEstaEmGrid());
        logout.euRealizoLogout();
    }
}
