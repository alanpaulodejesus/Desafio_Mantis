package TestPerfil;

import Core.Propriedades;
import Core.PropriedadesPerfil;
import Pages.LoginPage;
import Pages.PerfilPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class CriarPerfilTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    PerfilPage perfil = new PerfilPage();

    public CriarPerfilTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        perfil.verificarSeExistePerfilAExcluir();

    }


    @Test
    public void criarPerfil(){

        perfil.acionarComandoMenuGerenciar();
        perfil.acionarComandoMenuGerenciarPerfisGlobais();
        perfil.preencherCampoPlataforma(PropriedadesPerfil.PLATAFORMA);
        perfil.preencherCampoOS(PropriedadesPerfil.SO);
        perfil.preencherCampoVersaoOS(PropriedadesPerfil.VERSAOSO);
        perfil.acionarComandoAdicionarPerfil();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(perfil.verificarPerfilEmGrid());
        logout.realizarLogout();
    }
}
