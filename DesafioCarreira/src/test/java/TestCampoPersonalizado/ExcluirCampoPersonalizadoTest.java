package TestCampoPersonalizado;

import Core.Propriedades;
import Pages.CampoPersonalizadoPage;
import Pages.LoginPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class ExcluirCampoPersonalizadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage campoPersonalizado = new CampoPersonalizadoPage ();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        campoPersonalizado.verificoSeExisteCampoPersonalidado();

    }


    @Test
    public void excluirCampoPersonalizado(){

        campoPersonalizado.euAcionoComandoMenuGerenciar();
        campoPersonalizado.euAcionoMenuCampoPersonalizado();
        campoPersonalizado.euAcionoCampoPersonalizadoEmGrid();
        campoPersonalizado.euAcionoComandoApagarCampoPersonalizado();
        campoPersonalizado.euAcionoComandoConfirmarApagarCampoPersonalizado();



    }


    @After
    public void tearDown(){

        Assert.assertTrue(campoPersonalizado.euVerificoCampoPersonalizadoExcluidoEmGrid());
        logout.euRealizoLogout();
    }
}
