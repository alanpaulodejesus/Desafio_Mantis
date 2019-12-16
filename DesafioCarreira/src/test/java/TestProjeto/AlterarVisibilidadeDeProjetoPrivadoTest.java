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

public class AlterarVisibilidadeDeProjetoPrivadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    public AlterarVisibilidadeDeProjetoPrivadoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        projeto.verificarSeExisteProjetoPrivado();

    }


    @Test
    public void alterarProjetoPublicoParaPrivado(){


        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarProjetoPublicoEmGrid();
        projeto.selecionarComboVisibilidadeProjetoPrivado(PropriedadesProjeto.projetoPrivado);
        projeto.acionarComandoAtualizarProjeto();

    }

    @After
    public void tearDown() throws Exception {

        projeto.registrarVisibilidadeProjetoPrivado();
        Assert.assertTrue(projeto.verificarProjetoPrivadoEmGrid());
        projeto.acionarProjetoPublicoEmGrid();
        projeto.acionarComandoApagarProjeto();
        projeto.acionarComandoApagarProjeto();
        logout.realizarLogout();
        closeRelatorio();

    }
}
