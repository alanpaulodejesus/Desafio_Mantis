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

public class RepresentarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage representarUsuario = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
    PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuario();
        pesquisaUsuario.pesquisaUsuario();

    }

    @Test
    public void redefinirSenhaUsuario(){

        representarUsuario.euAcionoNomeDeUsuarioEmGrid();
        representarUsuario.euAcionoComandoRepresentarUsuario();
        Assert.assertTrue(representarUsuario.euVerificoMensagemRepresentacaoRealizada());
        representarUsuario.euAcionoComandoProsseguir();

    }

    @After
    public void tearDown(){

        logout.euRealizoLogout();
        login.realizarLoginValido();
        representarUsuario.excluirTodosUsuarios();
        logout.euRealizoLogout();
    }
}
