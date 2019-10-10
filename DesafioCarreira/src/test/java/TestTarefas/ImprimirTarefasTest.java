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

public class ImprimirTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    //PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage imprimirTarefas = new TarefasPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        imprimirTarefas.verificoSeExisteTarefaParaImprimir();

    }

    @Test
    public void imprimirAtividade(){

        imprimirTarefas.euAcionoComandoImprimirTarefa();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(imprimirTarefas.tarefaEmGriImprimir());
        imprimirTarefas.euRetornoImpressao();
        imprimirTarefas.excluirTodasTarefas();
        logout.euRealizoLogout();
    }
}
