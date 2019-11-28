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

public class RedefinirFiltroTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage redefinirFiltroTarefa = new TarefasPage();

    public RedefinirFiltroTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        redefinirFiltroTarefa.verificarSeExisteTarefa();
        redefinirFiltroTarefa.verificarSeExisteFiltroTarefa();

    }

    @Test
    public void redefinirFiltroAtividade(){

        redefinirFiltroTarefa.acionarComandoRedefinir();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(redefinirFiltroTarefa.verificarRedefinicaoTarefa());
        logout.realizarLogout();
    }
}
