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

public class RemoverCampoPersonalizadoEmProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage removerCampoPersonalizado = new CampoPersonalizadoPage ();
    ProjetoPage projeto = new ProjetoPage();

    public RemoverCampoPersonalizadoEmProjetoTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();
        removerCampoPersonalizado.verificarSeExisteCampoPersonalidado();
        removerCampoPersonalizado.verificarSeExisteCampoPersonalizadoAdicionado();

    }


    @Test
    public void removerCampoPersonalizadoEmProjeto(){

        removerCampoPersonalizado.acionarComandoMenuGerenciar();
        removerCampoPersonalizado.acionarMenuCampoPersonalizado();
        removerCampoPersonalizado.acionarCampoPersonalizadoParaAdicionarEmGrid();
        removerCampoPersonalizado.acionarComandoRemover();
        removerCampoPersonalizado.acionarComandoConfirmaRemover();


    }


    @After
    public void tearDown(){
        Assert.assertFalse(removerCampoPersonalizado.verificarCampoVinculadoEmGrid());
        logout.realizarLogout();
    }
}
