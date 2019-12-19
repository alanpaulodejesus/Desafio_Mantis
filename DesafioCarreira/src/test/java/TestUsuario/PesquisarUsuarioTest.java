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

public class PesquisarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage pesquisaUsuario = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();

    public PesquisarUsuarioTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuario();
    }


    @Test
    public void pesquisaUsuario(){

        pesquisaUsuario.acionarMenuGerenciar();
        pesquisaUsuario.acionarMenuGerenciarUsuario();
        pesquisaUsuario.preencherFiltroUsuario(PropriedadesUsuario.nomeVerdadeiro);
        pesquisaUsuario.acionarComandoPesquisa();


    }

    public void pesquisaUsuarioDesabilitado(){

        pesquisaUsuario.acionarMenuGerenciar();
        pesquisaUsuario.acionarMenuGerenciarUsuario();
        pesquisaUsuario.acionarSelectPesquisaUsuarioDesabilitado();
        pesquisaUsuario.preencherFiltroUsuario(PropriedadesUsuario.nomeVerdadeiro);
        pesquisaUsuario.acionarComandoPesquisa();


    }

    @After
    public void tearDown() throws Exception {
        Assert.assertTrue(pesquisaUsuario.verificarUsuarioPesquisadoEmGrid());
        pesquisaUsuario.excluirTodosUsuarios();
        logout.realizarLogout();
        closeRelatorio();
    }
}
