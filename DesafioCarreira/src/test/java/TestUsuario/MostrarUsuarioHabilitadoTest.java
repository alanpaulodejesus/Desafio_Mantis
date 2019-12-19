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

public class MostrarUsuarioHabilitadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage mostrarUsuarioAtivo = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
    PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();

    public MostrarUsuarioHabilitadoTest() throws Exception {
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
    public void mostrarUsuarioAtivo() throws IOException {

        Assert.assertTrue(mostrarUsuarioAtivo.verificarUsuarioAtivoEmGrid());

    }

    @After
    public void tearDown() throws Exception {


        mostrarUsuarioAtivo.excluirTodosUsuarios();
        logout.realizarLogout();
        closeRelatorio();

    }
}
