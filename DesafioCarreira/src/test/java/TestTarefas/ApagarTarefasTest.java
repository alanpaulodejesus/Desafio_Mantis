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

public class ApagarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage excluirTarefas = new TarefasPage();

    public ApagarTarefasTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        excluirTarefas.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void apagarTarefa(){

        excluirTarefas.acionarComandoApagarTarefas();

    }

    @After
    public void tearDown(){

        excluirTarefas.excluirTodasTarefas();
        Assert.assertTrue(excluirTarefas.verificarGridVazio());
        logout.realizarLogout();
    }
}
