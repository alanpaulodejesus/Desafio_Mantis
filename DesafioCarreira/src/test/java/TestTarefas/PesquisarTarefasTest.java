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

public class PesquisarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    TarefasPage pesquisaTarefa = new TarefasPage();
    LoginPage logout = new LoginPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        pesquisaTarefa.verificoSeExisteTarefa();
    }

    @Test
    public void pesquisarAtividade(){

        pesquisaTarefa.euPesquisoTarefa(pesquisaTarefa.euVerificoIdTarefaCriada());


    }

    @After
    public void tearDown(){

        Assert.assertTrue((pesquisaTarefa.euVerificoPesquisaIdTarefaCriada()));
        logout.euRealizoLogout();
    }
}
