package TestCampoPersonalizado;

import Core.Propriedades;
import Core.PropriedadesCampoPersonalizado;
import Pages.CampoPersonalizadoPage;
import Pages.LoginPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class AlterarCampoPersonalizadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage campoPersonalizado = new CampoPersonalizadoPage ();


    @Before
    public void setUp() {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        campoPersonalizado.verificoSeExisteCampoPersonalidado();

    }


    @Test
    public void alterarCampoPersonalizado(){

        campoPersonalizado.euAcionoComandoMenuGerenciar();
        campoPersonalizado.euAcionoMenuCampoPersonalizado();
        campoPersonalizado.euAcionoCampoPersonalizadoEmGrid();
        campoPersonalizado.euPreenchoCampoNomePersonalizado(PropriedadesCampoPersonalizado.nomeCampoPersonalizadoAlterado);
        campoPersonalizado.euAcionoComandoAlterarCampoPersonalizado();


    }

    @After
    public void tearDown(){

        Assert.assertTrue(campoPersonalizado.euVerificoCampoPersonalizadoAlteradoEmGrid());
        logout.euRealizoLogout();
    }
}
