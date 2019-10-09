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

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        marcarTarefa.verificoSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
        marcarTarefa.verificoSeTarefaEstaDesmarcada();
    }

    @Test
    public void marcarTarefaPegajosa(){

        marcarTarefa.euAcionoComandoMarcarTarefasPegajosa();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(marcarTarefa.euVerificoTarefaMarcarda());
        logout.euRealizoLogout();
    }
}
