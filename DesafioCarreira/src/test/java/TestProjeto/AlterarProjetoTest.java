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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class AlterarProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    public AlterarProjetoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
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
    public void tearDown() throws Exception {

        projeto.registrarAlterarProjeto();
        Assert.assertTrue(projeto.verificarProjetoEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
