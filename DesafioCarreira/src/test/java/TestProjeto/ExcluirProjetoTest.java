package TestProjeto;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.ProjetoPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class ExcluirProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();

    }


    @Test
    public void excluirProjeto(){


        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarProjetoEmGrid();
        projeto.acionarComandoApagarProjeto();
        projeto.acionarComandoApagarProjeto();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.verificarProjetoNaoEstaEmGrid());
        logout.realizarLogout();
    }
}
