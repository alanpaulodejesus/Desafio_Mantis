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

public class CriarCampoPersonalizadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage campoPersonalizado = new CampoPersonalizadoPage ();

    public CriarCampoPersonalizadoTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        campoPersonalizado.verificarSeExisteCampoPersonalidadoAExcluir();

    }


    @Test
    public void criarCampoPersonalizado() throws InterruptedException {

        campoPersonalizado.acionarComandoMenuGerenciar();
        campoPersonalizado.acionarMenuCampoPersonalizado();
        campoPersonalizado.preencherCampoNomePersonalizado(PropriedadesCampoPersonalizado.nomeCampoPersonalizado);
        campoPersonalizado.euAcionoComandoNovoCampoPersonalizado();
        Thread.sleep( 2000 );
        campoPersonalizado.acionarMenuCampoPersonalizado();


    }


    @After
    public void tearDown() throws Exception {


        campoPersonalizado.registrarCriarCampoPersonalizadoEmProjeto();
        Assert.assertTrue(campoPersonalizado.verificarCampoPersonalizadoEmGrid());
        campoPersonalizado.excluirTodosCamposPersonalizados();
        logout.realizarLogout();
    }
}
