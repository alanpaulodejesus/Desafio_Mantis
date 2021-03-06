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

public class PararDeMonitorarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage monitorarTarefa = new TarefasPage();
    ProjetoPage projeto = new ProjetoPage();

    public PararDeMonitorarTarefasTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();
        projeto.selecionarProjeto();
        monitorarTarefa.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void monitorarTarefa(){

        monitorarTarefa.acionarComandoPararDeMonitorar();

    }

    @After
    public void tearDown() throws Exception {

        monitorarTarefa.registrarParaMonitorarTarefas();
        Assert.assertTrue(monitorarTarefa.verificarTarefaSemEstarMonitorada());
        logout.realizarLogout();
        closeRelatorio();
    }
}
