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


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificoSeExisteProjeto();
        removerCampoPersonalizado.verificoSeExisteCampoPersonalidado();
        removerCampoPersonalizado.verificoSeExisteCampoPersonalizadoAdicionado();

    }


    @Test
    public void removerCampoPersonalizadoEmProjeto(){

        removerCampoPersonalizado.euAcionoComandoMenuGerenciar();
        removerCampoPersonalizado.euAcionoMenuCampoPersonalizado();
        removerCampoPersonalizado.euAcionoCampoPersonalizadoParaAdicionarEmGrid();
        removerCampoPersonalizado.euAcionoComandoRemover();
        removerCampoPersonalizado.euAcionoComandoConfirmaRemover();


    }


    @After
    public void tearDown(){
        Assert.assertFalse(removerCampoPersonalizado.euVerificoCampoVinculadoEmGrid());
        logout.euRealizoLogout();
    }
}
