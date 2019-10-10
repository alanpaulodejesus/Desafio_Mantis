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


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificoSeExisteProjeto();
        adicionarCampoPersonalizado.verificoSeExisteCampoPersonalidado();

    }


    @Test
    public void adicionaCampoPersonalizadoEmProjeto(){

        adicionarCampoPersonalizado.euAcionoComandoMenuGerenciar();
        adicionarCampoPersonalizado.euAcionoMenuCampoPersonalizado();
        adicionarCampoPersonalizado.euAcionoCampoPersonalizadoParaAdicionarEmGrid();
        adicionarCampoPersonalizado.euAcionoProjetoParaCampoPersonalizado();
        adicionarCampoPersonalizado.euAcionoComandoVincularProjeto();


    }


    @After
    public void tearDown(){
        Assert.assertTrue(adicionarCampoPersonalizado.euVerificoCampoVinculadoEmGrid());
        logout.euRealizoLogout();
    }
}
