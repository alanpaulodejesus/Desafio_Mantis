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

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();

    }


    @Test
    public void criarPerfil(){

        perfil.euAcionoComandoMenuGerenciar();
        perfil.euAcionoComandoMenuGerenciarPerfisGlobais();
        perfil.euPreenchoCampoPlataforma(PropriedadesPerfil.PLATAFORMA);
        perfil.euPreenchoCampoOS(PropriedadesPerfil.SO);
        perfil.euPreenchoCampoVersaoOS(PropriedadesPerfil.VERSAOSO);
        perfil.euAcionoComandoAdicionarPerfil();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(perfil.euVerificoPerfilEmGrid());
        logout.euRealizoLogout();
    }
}
