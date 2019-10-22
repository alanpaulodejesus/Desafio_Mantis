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

public class AlterarPerfilTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    PerfilPage perfil = new PerfilPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        perfil.verificarSeExistePerfil();

    }


    @Test
    public void alterarPerfil(){

        perfil.acionarComandoMenuGerenciar();
        perfil.acionarComandoMenuGerenciarPerfisGlobais();
        perfil.selecionarComboPerfil(PropriedadesPerfil.PLATAFORMA+" "+PropriedadesPerfil.SO+" "+PropriedadesPerfil.VERSAOSO);
        perfil.selecionarRadioAlterar();
        perfil.acionarComandoEnviar();
        perfil.preencherCampoPlataforma(PropriedadesPerfil.PLATAFORMA);
        perfil.preencherCampoOS(PropriedadesPerfil.SO);
        perfil.preencherCampoVersaoOSAlteracao(PropriedadesPerfil.VERSAOSO);
        perfil.preencherDescricaoAdicionalAlteracao(PropriedadesPerfil.DESCRICAO_ADICIONAL);
        perfil.acionarComandoAtualizarPerfil();



    }

    @After
    public void tearDown(){
        Assert.assertTrue(perfil.verificarPerfilEmGrid());
        logout.realizarLogout();
    }

}
