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

public class AdicionarFiltroTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage adicionarFiltroTarefa = new TarefasPage();

    public AdicionarFiltroTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        adicionarFiltroTarefa.verificarSeExisteTarefa();
    }

    @Test
    public void adicionarFiltroAtividade() throws InterruptedException {

        adicionarFiltroTarefa.acionarMenuVerTarefas();
        adicionarFiltroTarefa.acionarRelatorGrid();
        //Thread.sleep( 2000 );
        adicionarFiltroTarefa.selecionarRelator( PropriedadesTarefas.relatorAdministrador);
        adicionarFiltroTarefa.acionarComandoAplicaFiltro();

    }

    @After
    public void tearDown() throws Exception {

        adicionarFiltroTarefa.registrarAdicionarFiltroTarefas();
        Assert.assertTrue(adicionarFiltroTarefa.verificarTarefaEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
