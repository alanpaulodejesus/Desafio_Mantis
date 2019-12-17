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

public class PesquisarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    TarefasPage pesquisaTarefa = new TarefasPage();
    LoginPage logout = new LoginPage();

    public PesquisarTarefasTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        pesquisaTarefa.verificarSeExisteTarefa();
    }

    @Test
    public void pesquisarAtividade(){

        pesquisaTarefa.euPesquisoTarefa(pesquisaTarefa.verificarIdTarefaCriada());


    }

    @After
    public void tearDown() throws Exception {

        pesquisaTarefa.registrarPesquisarTarefas();
        Assert.assertTrue((pesquisaTarefa.verificarPesquisaIdTarefaCriada()));
        logout.realizarLogout();
        closeRelatorio();
    }
}
