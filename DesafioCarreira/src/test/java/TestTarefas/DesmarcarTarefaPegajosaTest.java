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

public class DesmarcarTarefaPegajosaTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage desMarcarTarefa = new TarefasPage();

    public DesmarcarTarefaPegajosaTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        desMarcarTarefa.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
        desMarcarTarefa.verificarSeTarefaEstaMarcada();

    }

    @Test
    public void desmarcarTarefaPegajosa(){

        desMarcarTarefa.acionarComandoDesmarcarTarefasPegajosa();

    }

    @After
    public void tearDown() throws Exception {

        desMarcarTarefa.registrarDesmarcarTarefaPegajosa();
        Assert.assertTrue(desMarcarTarefa.verificarTarefaDesmarcarda());
        logout.realizarLogout();
        closeRelatorio();
    }
}
