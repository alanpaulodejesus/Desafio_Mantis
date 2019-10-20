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

public class PesquisarUsuarioTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    UsuarioPage pesquisaUsuario = new UsuarioPage();
    CriarUsuarioTest criarUsuario = new CriarUsuarioTest();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarUsuario.criarNovoUsuario();
    }


    @Test
    public void pesquisaUsuario(){

        pesquisaUsuario.euAcionoMenuGerenciar();
        pesquisaUsuario.euAcionoMenuGerenciarUsuario();
        pesquisaUsuario.euPreenchoFiltroUsuario(PropriedadesUsuario.nomeVerdadeiro);
        pesquisaUsuario.euAcionoComandoPesquisa();


    }

    public void pesquisaUsuarioDesabilitado(){

        pesquisaUsuario.euAcionoMenuGerenciar();
        pesquisaUsuario.euAcionoMenuGerenciarUsuario();
        pesquisaUsuario.euAcionoSelectPesquisaUsuarioDesabilitado();
        pesquisaUsuario.euPreenchoFiltroUsuario(PropriedadesUsuario.nomeVerdadeiro);
        pesquisaUsuario.euAcionoComandoPesquisa();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(pesquisaUsuario.euVerificoUsuarioCriadoEmGrid());
        pesquisaUsuario.excluirTodosUsuarios();
        logout.euRealizoLogout();
    }
}
