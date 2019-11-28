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
    public void tearDown(){

        Assert.assertTrue(marcarTarefa.verificarTarefaMarcarda());
        logout.realizarLogout();
    }
}
