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

public class CriarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage criarUsuario = new UsuarioPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
    }


    @Test
    public void criarNovoUsuario(){

        criarUsuario.acionarComandoConvidarUsuario();
        criarUsuario.preencherCampoNomeUsuario(PropriedadesUsuario.nomeUsuario);
        criarUsuario.preencherCampoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiro);
        criarUsuario.preencherCampoEmail(PropriedadesUsuario.email);
        criarUsuario.selecionarNivelAcesso(PropriedadesUsuario.nivelAcesso);
        criarUsuario.acionarComandoCriarUsuario();
        criarUsuario.acionarMenuGerenciarUsuario();
        Assert.assertTrue(criarUsuario.verificarUsuarioCriadoEmGrid());

    }

    public void criarNovoUsuarioDesativado(){

        criarUsuario.acionarComandoConvidarUsuario();
        criarUsuario.preencherCampoNomeUsuario(PropriedadesUsuario.nomeUsuario);
        criarUsuario.preencherCampoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiro);
        criarUsuario.preencherCampoEmail(PropriedadesUsuario.email);
        criarUsuario.selecionarNivelAcesso(PropriedadesUsuario.nivelAcesso);
        criarUsuario.acionarSelectParaUsuarioDesabilitado();
        criarUsuario.acionarComandoCriarUsuario();
        criarUsuario.acionarMenuGerenciarUsuario();

    }

    @After
    public void tearDown(){
        criarUsuario.excluirTodosUsuarios();
        logout.realizarLogout();
    }
}
