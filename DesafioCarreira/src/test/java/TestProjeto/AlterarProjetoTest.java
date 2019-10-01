package TestProjeto;

import Core.Propriedades;
import Core.PropriedadesProjeto;
import Pages.LoginPage;
import Pages.ProjetoPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class AlterarProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();
    CriarProjetoTest criarProjeto = new CriarProjetoTest();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarProjeto.criarNovoProjeto();

    }


    @Test
    public void AlterarProjeto(){

        projeto.euAcionoMenuGerenciar();
        projeto.euAcionoMenuGerenciarProjetos();
        projeto.euAcionoProjetoEmGrid();
        projeto.euPreenchoDescricaoProjeto(PropriedadesProjeto.descricaoProjeto);
        projeto.euAcionoComandoAtualizarProjeto();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.euVerificoProjetoEmGrid());
        logout.euRealizoLogout();
    }
}
