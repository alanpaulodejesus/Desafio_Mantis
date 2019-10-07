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

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuario();
        pesquisaUsuario.pesquisaUsuario();

    }

    @Test
    public void alterarUsuario(){

        alterarUsuario.euAcionoNomeDeUsuarioEmGrid();
        alterarUsuario.euLimpoCamposDeDadosUsuarios();
        alterarUsuario.euPreenchoAlteracaoNomeUsuario(PropriedadesUsuario.nomeUsuarioAlterado);
        alterarUsuario.euPreenchoAlteracaoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiroAlterado);
        alterarUsuario.euAcionoComandoAtualizarUsuario();
        alterarUsuario.euAcionoMenuGerenciarUsuario();
        alterarUsuario.euVerificoUsuarioCriadoEmGridAlterado();
    }

    @After
    public void tearDown(){

        alterarUsuario.excluirTodosUsuarios();
        Assert.assertTrue(alterarUsuario.euVerificoQueNomeUsuarioNaoEstaEmGrid());
        logout.euRealizoLogout();
    }
}
