package TestTarefas;

import Core.Propriedades;
import Core.PropriedadesProjeto;
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

public class MoverTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage moverTarefas = new TarefasPage();
    ProjetoPage verProjeto= new ProjetoPage();

    public MoverTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        verProjeto.verificarSeExisteProjeto();
        verProjeto.verificarSeExisteProjetoParaMoverTarefa();
        verProjeto.selecionarProjeto();
        moverTarefas.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void moverAtividade() {

        moverTarefas.acionarComandoMoverAtividade();
        moverTarefas.selecionarTarefaParaRemover(PropriedadesProjeto.nomeProjetoMoverTarefa);
        moverTarefas.acionarComandoConfirmarMoverAtividade();
        verProjeto.selecionarProjetoComTarefaMovida();

    }

    @After
    public void tearDown() throws Exception {

        moverTarefas.registrarMoverTarefas();
        Assert.assertTrue(moverTarefas.verificarMoverTarefa());
        moverTarefas.excluirTodasTarefas();
        logout.realizarLogout();
        closeRelatorio();
    }
}
