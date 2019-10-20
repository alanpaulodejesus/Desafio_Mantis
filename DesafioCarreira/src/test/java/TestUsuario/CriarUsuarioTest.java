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

        criarUsuario.euAcionoComandoConvidarUsuario();
        criarUsuario.euPreenchoCampoNomeUsuario(PropriedadesUsuario.nomeUsuario);
        criarUsuario.euPreenchoCampoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiro);
        criarUsuario.euPreenchoCampoEmail(PropriedadesUsuario.email);
        criarUsuario.euSelecionoNivelAcesso(PropriedadesUsuario.nivelAcesso);
        criarUsuario.euAcionoComandoCriarUsuario();
        criarUsuario.euAcionoMenuGerenciarUsuario();
        Assert.assertTrue(criarUsuario.euVerificoUsuarioCriadoEmGrid());

    }

    public void criarNovoUsuarioDesativado(){

        criarUsuario.euAcionoComandoConvidarUsuario();
        criarUsuario.euPreenchoCampoNomeUsuario(PropriedadesUsuario.nomeUsuario);
        criarUsuario.euPreenchoCampoNomeVerdadeiro(PropriedadesUsuario.nomeVerdadeiro);
        criarUsuario.euPreenchoCampoEmail(PropriedadesUsuario.email);
        criarUsuario.euSelecionoNivelAcesso(PropriedadesUsuario.nivelAcesso);
        criarUsuario.euAcionoSelectParaUsuarioDesabilitado();
        criarUsuario.euAcionoComandoCriarUsuario();
        criarUsuario.euAcionoMenuGerenciarUsuario();

    }

    @After
    public void tearDown(){
        criarUsuario.excluirTodosUsuarios();
        logout.euRealizoLogout();
    }
}
