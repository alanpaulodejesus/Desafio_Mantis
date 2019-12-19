package TestUsuario;

import Core.Propriedades;
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

public class RedefinirSenhaUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage redefinirSenha = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
    PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();

    public RedefinirSenhaUsuarioTest() throws Exception {
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
    public void redefinirSenhaUsuario(){

        redefinirSenha.acionarNomeDeUsuarioEmGrid();
        redefinirSenha.acionarComandoRedefinirSenha();

    }

    @After
    public void tearDown() throws Exception {


        Assert.assertTrue(redefinirSenha.verificarMensagemValidacaoEnvioEmail());
        redefinirSenha.excluirTodosUsuarios();
        logout.realizarLogout();
        closeRelatorio();
    }
}
