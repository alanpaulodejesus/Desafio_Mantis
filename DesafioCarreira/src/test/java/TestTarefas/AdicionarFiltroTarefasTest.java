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
        login.realizarLoginValido();
        adicionarFiltroTarefa.verificarSeExisteTarefa();
    }

    @Test
    public void adicionarFiltroAtividade(){

        adicionarFiltroTarefa.acionarMenuVerTarefas();
        adicionarFiltroTarefa.acionarRelatorGrid();
        adicionarFiltroTarefa.selecionarRelator(PropriedadesTarefas.relatorAdministrador);
        adicionarFiltroTarefa.acionarComandoAplicaFiltro();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(adicionarFiltroTarefa.verificarTarefaEmGrid());
        logout.realizarLogout();
    }
}
