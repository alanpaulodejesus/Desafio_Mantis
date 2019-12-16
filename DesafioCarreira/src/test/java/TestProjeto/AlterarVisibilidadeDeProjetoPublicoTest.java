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

public class AlterarVisibilidadeDeProjetoPublicoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    public AlterarVisibilidadeDeProjetoPublicoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        projeto.verificarSeExisteProjetoPublico();

    }


    @Test
    public void alterarProjetoPrivadoParaPublico(){


        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarProjetoPrivadoEmGrid();
        projeto.selecionarComboVisibilidadeProjetoPrivado(PropriedadesProjeto.projetoPublico);
        projeto.acionarComandoAtualizarProjeto();

    }

    @After
    public void tearDown() throws Exception {

        projeto.registrarVisibilidadeProjetoPublico();
        Assert.assertTrue(projeto.verificarProjetoPublicoEmGrid());
        projeto.acionarProjetoPrivadoEmGrid();
        projeto.acionarComandoApagarProjeto();
        projeto.acionarComandoApagarProjeto();
        logout.realizarLogout();
        closeRelatorio();
    }
}
