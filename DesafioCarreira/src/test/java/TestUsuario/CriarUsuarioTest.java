package TestUsuario;

import Core.Propriedades;
import Core.PropriedadesUsuario;
import Pages.LoginPage;
import Pages.UsuarioPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class CriarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage criarUsuario = new UsuarioPage();

    public CriarUsuarioTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
    }


    @Test
    public void criarNovoUsuario() throws Exception {

        criarUsuario.acionarComandoConvidarUsuario();
        criarUsuario.preencherCampoNomeUsuario(PropriedadesUsuario.nomeUsuario);
        criarUsuario.preencherCampoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiro);
        criarUsuario.preencherCampoEmail(PropriedadesUsuario.email);
        criarUsuario.selecionarNivelAcesso(PropriedadesUsuario.nivelAcesso);
        criarUsuario.acionarComandoCriarUsuario();
        criarUsuario.acionarMenuGerenciarUsuario();
        criarUsuario.registrarCriarUsuarioEmProjeto();
        Assert.assertTrue(criarUsuario.verificarUsuarioCriadoEmGrid());

    }

    public void criarNovoUsuarioDesativado(){

        criarUsuario.acionarComandoConvidarUsuario();
        criarUsuario.preencherCampoNomeUsuario(PropriedadesUsuario.nomeUsuario);
        criarUsuario.preencherCampoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiro);
        criarUsuario.preencherCampoEmail(PropriedadesUsuario.email);
        criarUsuario.selecionarNivelAcesso(PropriedadesUsuario.nivelAcesso);
        criarUsuario.acionarSelectParaUsuarioDesabilitado();
        criarUsuario.acionarComandoCriarUsuario();
        criarUsuario.acionarMenuGerenciarUsuario();

    }

    @After
    public void tearDown() throws Exception {
        criarUsuario.excluirTodosUsuarios();
        logout.realizarLogout();
        closeRelatorio();
    }
}
