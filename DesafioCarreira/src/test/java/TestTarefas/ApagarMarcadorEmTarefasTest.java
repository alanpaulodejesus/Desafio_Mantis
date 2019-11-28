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

public class ApagarMarcadorEmTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage apagarMarcadorEmTarefa = new TarefasPage();

    public ApagarMarcadorEmTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        apagarMarcadorEmTarefa.verificarSeTarefaPossuiMarcador();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void apagarMarcadorEmAtividade(){

        apagarMarcadorEmTarefa.acionarIconeExluirMarcador();
    }

    @After
    public void tearDown(){

        Assert.assertFalse(apagarMarcadorEmTarefa.verificarMarcadorEmTarefa());
        apagarMarcadorEmTarefa.excluirTodasTarefas();
        logout.realizarLogout();
    }
}
