package TestTarefas;

import Core.Propriedades;
import Core.PropriedadesTarefas;
import Pages.LoginPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class FecharTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    CriarTarefasTest criarTarefa = new CriarTarefasTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    ApagarTarefasTest apagarTarefa = new ApagarTarefasTest();
    TarefasPage fecharTarefas = new TarefasPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarTarefa.criarNovaTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void alterarAtividade(){

        fecharTarefas.euAcionoComandoFecharTarefa();
        fecharTarefas.euAdicionoInformacaoTarefa(PropriedadesTarefas.informacaoAdicionadaEmTarefa);
        fecharTarefas.euConfirmoFechamentoComandoFecharTarefa();
        Assert.assertTrue(fecharTarefas.euVerificoStatusFechado());

    }

    @After
    public void tearDown(){

        apagarTarefa.apagarTarefa();
        logout.euRealizoLogout();
    }
}
