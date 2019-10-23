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
        campoPersonalizado.verificarSeExisteCampoPersonalidado();

    }


    @Test
    public void alterarCampoPersonalizado(){

        campoPersonalizado.acionarComandoMenuGerenciar();
        campoPersonalizado.acionarMenuCampoPersonalizado();
        campoPersonalizado.acionarCampoPersonalizadoEmGrid();
        campoPersonalizado.preencherCampoNomePersonalizado(PropriedadesCampoPersonalizado.nomeCampoPersonalizadoAlterado);
        campoPersonalizado.acionarComandoAlterarCampoPersonalizado();


    }

    @After
    public void tearDown(){

        Assert.assertTrue(campoPersonalizado.verificarCampoPersonalizadoAlteradoEmGrid());
        campoPersonalizado.excluirTodosCamposPersonalizados();
        logout.realizarLogout();
    }
}
