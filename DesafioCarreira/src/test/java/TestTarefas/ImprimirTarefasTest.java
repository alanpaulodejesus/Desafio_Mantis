package TestTarefas;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class ImprimirTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    LoginPage logout = new LoginPage();
    TarefasPage imprimirTarefas = new TarefasPage();

    public ImprimirTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        imprimirTarefas.verificarSeExisteTarefaParaImprimir();

    }

    @Test
    public void imprimirAtividade(){

        imprimirTarefas.acionarComandoImprimirTarefa();

    }

    @After
    public void tearDown() throws Exception {

        imprimirTarefas.registrarImprimirTarefas();
        Assert.assertTrue(imprimirTarefas.tarefaEmGriImprimir());
        imprimirTarefas.retornarImpressao();
        imprimirTarefas.excluirTodasTarefas();
        logout.realizarLogout();
        closeRelatorio();
    }
}
