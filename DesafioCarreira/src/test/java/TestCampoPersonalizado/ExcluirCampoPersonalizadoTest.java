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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class ExcluirCampoPersonalizadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage campoPersonalizado = new CampoPersonalizadoPage ();

    public ExcluirCampoPersonalizadoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        campoPersonalizado.verificarSeExisteCampoPersonalidado();

    }


    @Test
    public void excluirCampoPersonalizado() throws InterruptedException {

        campoPersonalizado.acionarComandoMenuGerenciar();
        campoPersonalizado.acionarMenuCampoPersonalizado();
        campoPersonalizado.acionarCampoPersonalizadoEmGrid();
        campoPersonalizado.acionarComandoApagarCampoPersonalizado();
        campoPersonalizado.acionarComandoConfirmarApagarCampoPersonalizado();


    }



    @After
    public void tearDown() throws Exception {

        campoPersonalizado.registrarExcluirCampoPersonalizadoEmProjeto();
        Assert.assertTrue(campoPersonalizado.verificarCampoPersonalizadoExcluidoEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
