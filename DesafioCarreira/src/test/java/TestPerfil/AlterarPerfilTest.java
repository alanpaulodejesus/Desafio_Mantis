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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class AlterarPerfilTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    PerfilPage perfil = new PerfilPage();

    public AlterarPerfilTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
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
    public void tearDown() throws Exception {

        perfil.registrarAlterarPerfil();
        Assert.assertTrue(perfil.verificarPerfilEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }

}
