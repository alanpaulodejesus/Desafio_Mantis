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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class AdicionarUsuarioEmProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage adicionaUsuarioEmProjeto = new UsuarioPage();
    ProjetoPage projeto = new ProjetoPage();

    public AdicionarUsuarioEmProjetoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();
        adicionaUsuarioEmProjeto.verificarSeExisteUsuarioCriado();

    }


    @Test
    public void adicionarUsuarioEmProjeto(){

        adicionaUsuarioEmProjeto.acionarNomeDeUsuarioEmGrid();
        adicionaUsuarioEmProjeto.selecionarProjetoAUsuario();
        adicionaUsuarioEmProjeto.acionarComandoAdicionarUsuario();


    }

    @After
    public void tearDown() throws Exception {

        adicionaUsuarioEmProjeto.registrarAdicionarUsuarioEmProjeto();
        Assert.assertTrue(adicionaUsuarioEmProjeto.verificarUsuarioAdicionadoEmProjeto());
        adicionaUsuarioEmProjeto.excluirTodosUsuarios();
        logout.realizarLogout();
        closeRelatorio();
    }
}
