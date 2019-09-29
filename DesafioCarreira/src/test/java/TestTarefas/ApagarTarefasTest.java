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
    CriarTarefasTest criarTarefa = new CriarTarefasTest();
    PesquisarTarefasTest pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage excluirTarefas = new TarefasPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarTarefa.criarNovaTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void apagarTarefa(){

        Assert.assertTrue((excluirTarefas.euVerificoPesquisaIdTarefaCriada()));
        excluirTarefas.euAcionoComandoApagarTarefas();
        Assert.assertTrue(excluirTarefas.euVerificoGridVazio());
    }

    @After
    public void tearDown(){
        logout.euRealizoLogout();
    }
}
