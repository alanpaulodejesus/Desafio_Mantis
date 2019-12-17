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

public class MarcarTarefaPegajosaTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage marcarTarefa = new TarefasPage();

    public MarcarTarefaPegajosaTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        marcarTarefa.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
        marcarTarefa.verificarSeTarefaEstaDesmarcada();
    }

    @Test
    public void marcarTarefaPegajosa(){

        marcarTarefa.acionarComandoMarcarTarefasPegajosa();

    }

    @After
    public void tearDown() throws Exception {

        marcarTarefa.registrarMarcarTarefaPegajosa();
        Assert.assertTrue(marcarTarefa.verificarTarefaMarcarda());
        logout.realizarLogout();
        closeRelatorio();
    }
}
