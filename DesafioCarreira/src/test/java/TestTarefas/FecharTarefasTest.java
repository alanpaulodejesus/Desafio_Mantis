package TestTarefas;

import Core.Propriedades;
import Core.PropriedadesTarefas;
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

public class FecharTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage fecharTarefas = new TarefasPage();

    public FecharTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        fecharTarefas.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void fecharAtividade(){

        fecharTarefas.acionarComandoFecharTarefa();
        fecharTarefas.adicionarInformacaoTarefa(PropriedadesTarefas.informacaoAdicionadaEmTarefa);
        fecharTarefas.confirmarFechamentoComandoFecharTarefa();

    }

    @After
    public void tearDown() throws Exception {

        fecharTarefas.registrarFecharTarefas();
        Assert.assertTrue(fecharTarefas.verificarStatusFechado());
        logout.realizarLogout();
        closeRelatorio();
    }
}
