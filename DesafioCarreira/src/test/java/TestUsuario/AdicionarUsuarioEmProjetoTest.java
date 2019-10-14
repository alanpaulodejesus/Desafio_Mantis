package TestUsuario;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.ProjetoPage;
import Pages.UsuarioPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class AdicionarUsuarioEmProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage adicionaUsuarioEmProjeto = new UsuarioPage();
    ProjetoPage projeto = new ProjetoPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificoSeExisteProjeto();
        adicionaUsuarioEmProjeto.euVerificoSeExisteUsuarioCriado();

    }


    @Test
    public void adicionarUsuarioEmProjeto(){

        adicionaUsuarioEmProjeto.euAcionoNomeDeUsuarioEmGrid();
        adicionaUsuarioEmProjeto.euSelecionoProjetoAUsuario();
        adicionaUsuarioEmProjeto.euAcionoComandoAdicionarUsuario();


    }

    @After
    public void tearDown(){

        Assert.assertTrue(adicionaUsuarioEmProjeto.euVerificoUsuarioAdicionadoEmProjeto());
        adicionaUsuarioEmProjeto.excluirTodosUsuarios();
        logout.euRealizoLogout();
    }
}
