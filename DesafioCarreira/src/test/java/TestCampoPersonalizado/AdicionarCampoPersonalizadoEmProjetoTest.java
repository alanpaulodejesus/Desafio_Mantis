package TestCampoPersonalizado;

import Core.Propriedades;
import Pages.CampoPersonalizadoPage;
import Pages.LoginPage;
import Pages.ProjetoPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class AdicionarCampoPersonalizadoEmProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage adicionarCampoPersonalizado = new CampoPersonalizadoPage ();
    ProjetoPage projeto = new ProjetoPage();

    public AdicionarCampoPersonalizadoEmProjetoTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();
        adicionarCampoPersonalizado.verificarSeExisteCampoPersonalidado();

    }


    @Test
    public void adicionaCampoPersonalizadoEmProjeto(){

        adicionarCampoPersonalizado.acionarComandoMenuGerenciar();
        adicionarCampoPersonalizado.acionarMenuCampoPersonalizado();
        adicionarCampoPersonalizado.acionarCampoPersonalizadoParaAdicionarEmGrid();
        adicionarCampoPersonalizado.acionarProjetoParaCampoPersonalizado();
        adicionarCampoPersonalizado.acionarComandoVincularProjeto();


    }


    @After
    public void tearDown(){
        Assert.assertTrue(adicionarCampoPersonalizado.verificarCampoVinculadoEmGrid());
        logout.realizarLogout();
    }
}
