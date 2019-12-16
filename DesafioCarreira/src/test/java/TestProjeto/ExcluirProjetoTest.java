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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class ExcluirProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    public ExcluirProjetoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
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
    public void tearDown() throws Exception {

        projeto.registrarExcluirProjeto();
        Assert.assertTrue(projeto.verificarProjetoNaoEstaEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
