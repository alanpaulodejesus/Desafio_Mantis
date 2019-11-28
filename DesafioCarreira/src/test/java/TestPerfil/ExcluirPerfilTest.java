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

    public ExcluirPerfilTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        perfil.verificarSeExistePerfil();

    }


    @Test
    public void excluirPerfil(){

        perfil.acionarComandoMenuGerenciar();
        perfil.acionarComandoMenuGerenciarPerfisGlobais();
        perfil.selecionarComboPerfil(PropriedadesPerfil.PLATAFORMA+" "+PropriedadesPerfil.SO+" "+PropriedadesPerfil.VERSAOSO);
        perfil.selecionarRadioApagar();
        perfil.acionarComandoEnviar();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(perfil.verificarPerfilNaoEstaEmGrid());
        logout.realizarLogout();
    }
}
