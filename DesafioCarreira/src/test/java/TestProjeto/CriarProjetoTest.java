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

public class CriarProjetoTest {


    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();

    }


    @Test
    public void criarNovoProjeto(){

        projeto.euAcionoMenuGerenciar();
        projeto.euAcionoMenuGerenciarProjetos();
        projeto.euAcionoComandoCriarProjetos();
        projeto.euPreenchoCampoNomeProjeto(PropriedadesProjeto.nomeProjeto);
        projeto.euAcionoComandoAdicionarProjeto();





    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.euVerificoProjetoEmGrid());
        logout.euRealizoLogout();
    }
}
