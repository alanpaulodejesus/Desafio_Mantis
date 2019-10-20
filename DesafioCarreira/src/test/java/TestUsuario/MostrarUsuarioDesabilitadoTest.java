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

public class MostrarUsuarioDesabilitadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage mostrarUsuarioAtivo = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
    PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuarioDesativado();
        pesquisaUsuario.pesquisaUsuarioDesabilitado();

    }

    @Test
    public void mostrarUsuarioNaoAtivo(){

        Assert.assertFalse(mostrarUsuarioAtivo.euVerificoUsuarioNaoAtivoEmGrid());

    }

    @After
    public void tearDown(){


        mostrarUsuarioAtivo.excluirTodosUsuarios();
        logout.euRealizoLogout();

    }
}
