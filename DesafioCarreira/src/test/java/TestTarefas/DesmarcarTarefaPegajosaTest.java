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

public class DesmarcarTarefaPegajosaTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage desMarcarTarefa = new TarefasPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
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
    public void tearDown(){

        Assert.assertTrue(desMarcarTarefa.verificarTarefaDesmarcarda());
        logout.realizarLogout();
    }
}
