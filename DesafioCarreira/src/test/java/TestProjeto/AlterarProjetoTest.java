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

    public AlterarProjetoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();

    }


    @Test
    public void AlterarProjeto(){

        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarProjetoEmGrid();
        projeto.preencherDescricaoProjeto(PropriedadesProjeto.descricaoProjeto);
        projeto.acionarComandoAtualizarProjeto();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.verificarProjetoEmGrid());
        logout.realizarLogout();
    }
}
