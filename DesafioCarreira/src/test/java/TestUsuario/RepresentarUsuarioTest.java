package TestUsuario;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.UsuarioPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class RepresentarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage representarUsuario = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
    PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();

    public RepresentarUsuarioTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuario();
        pesquisaUsuario.pesquisaUsuario();

    }

    @Test
    public void redefinirSenhaUsuario() throws IOException {

        representarUsuario.acionarNomeDeUsuarioEmGrid();
        representarUsuario.acionarComandoRepresentarUsuario();
        Assert.assertTrue(representarUsuario.verificarMensagemRepresentacaoRealizada());
        representarUsuario.acionarComandoProsseguir();

    }

    @After
    public void tearDown() throws Exception {

        logout.realizarLogout();
        login.realizarLoginValido();
        representarUsuario.excluirTodosUsuarios();
        logout.realizarLogout();
        closeRelatorio();
    }
}
