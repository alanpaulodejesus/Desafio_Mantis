package TestTarefas;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.ProjetoPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class ClonarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage validarProjeto = new ProjetoPage();
    TarefasPage criarCloneTarefa = new TarefasPage();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();

    public ClonarTarefasTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        validarProjeto.verificarSeExisteProjeto();
        criarCloneTarefa.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();

    }


    @Test
    public void clonarTarefa(){

        criarCloneTarefa.acionarComandoCriarCloneTarefa();
        criarCloneTarefa.acionarComandoCriarTarefa();



    }


    @After
    public void tearDown() throws Exception {

        criarCloneTarefa.registrarClonarTarefas();
        Assert.assertTrue(criarCloneTarefa.confirmarCadastroComSucesso());
        criarCloneTarefa.excluirTodasTarefas();
        logout.realizarLogout();
        closeRelatorio();
    }
}
