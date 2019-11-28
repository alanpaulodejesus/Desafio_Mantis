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

public class AlterarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage alterarUsuario = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
    PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();
    ApagarUsuarioTest excluirUsuario = new ApagarUsuarioTest();

    public AlterarUsuarioTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuario();
        pesquisaUsuario.pesquisaUsuario();

    }

    @Test
    public void alterarUsuario() throws Exception {

        alterarUsuario.acionarNomeDeUsuarioEmGrid();
        alterarUsuario.limparCamposDeDadosUsuarios();
        alterarUsuario.preencherAlteracaoNomeUsuario(PropriedadesUsuario.nomeUsuarioAlterado);
        alterarUsuario.preencherAlteracaoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiroAlterado);
        alterarUsuario.acionarComandoAtualizarUsuario();
        alterarUsuario.acionarMenuGerenciarUsuario();
        alterarUsuario.verificarUsuarioCriadoEmGridAlterado();
    }

    @After
    public void tearDown() throws Exception {

        alterarUsuario.excluirTodosUsuarios();
        Assert.assertTrue(alterarUsuario.verificarQueNomeUsuarioNaoEstaEmGrid());
        logout.realizarLogout();
    }
}
