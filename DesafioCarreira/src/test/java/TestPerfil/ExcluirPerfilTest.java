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

public class ExcluirPerfilTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    PerfilPage perfil = new PerfilPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        perfil.verificoSeExistePerfil();

    }


    @Test
    public void excluirPerfil(){

        perfil.euAcionoComandoMenuGerenciar();
        perfil.euAcionoComandoMenuGerenciarPerfisGlobais();
        perfil.euSelecionoComboPerfil(PropriedadesPerfil.PLATAFORMA+" "+PropriedadesPerfil.SO+" "+PropriedadesPerfil.VERSAOSO);
        perfil.euSelecionoRadioApagar();
        perfil.euAcionoComandoEnviar();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(perfil.euVerificoPerfilNaoEstaEmGrid());
        logout.euRealizoLogout();
    }
}
