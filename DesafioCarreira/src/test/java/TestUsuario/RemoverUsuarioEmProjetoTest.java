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

public class RemoverUsuarioEmProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage removerUsuarioEmProjeto = new UsuarioPage();
    ProjetoPage projeto = new ProjetoPage();
    AdicionarUsuarioEmProjetoTest adicionaUsuario = new AdicionarUsuarioEmProjetoTest();
    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();
        removerUsuarioEmProjeto.verificarSeExisteUsuarioCriado();
        adicionaUsuario.adicionarUsuarioEmProjeto();

    }


    @Test
    public void RemoverUsuarioEmProjeto(){

        removerUsuarioEmProjeto.acionarComandoRemover();

    }

    @After
    public void tearDown(){

        Assert.assertFalse(removerUsuarioEmProjeto.verificarUsuarioAdicionadoEmProjeto());
        removerUsuarioEmProjeto.excluirTodosUsuarios();
        logout.realizarLogout();
    }
}
