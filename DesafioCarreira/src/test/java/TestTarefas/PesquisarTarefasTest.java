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
    CriarTarefasTest criarTarefa = new CriarTarefasTest();
    TarefasPage pesquisaTarefa = new TarefasPage();
    LoginPage logout = new LoginPage();
    ApagarTarefasTest excluirTarefa = new ApagarTarefasTest();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarTarefa.criarNovaTarefa();
    }

    @Test
    public void pesquisarAtividade(){

        pesquisaTarefa.euPesquisoTarefa(pesquisaTarefa.euVerificoIdTarefaCriada());
        Assert.assertTrue((pesquisaTarefa.euVerificoPesquisaIdTarefaCriada()));

    }

    @After
    public void tearDown(){

        excluirTarefa.apagarTarefa();
        logout.euRealizoLogout();
    }
}
