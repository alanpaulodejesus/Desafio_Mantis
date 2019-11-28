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

public class MonitorarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage monitorarTarefa = new TarefasPage();

    public MonitorarTarefasTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        monitorarTarefa.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void monitorarTarefa(){

        monitorarTarefa.acionarComandoMonitorar();


    }

    @After
    public void tearDown(){

        Assert.assertTrue(monitorarTarefa.verificarTarefaMonitorada());
        logout.realizarLogout();
    }
}
