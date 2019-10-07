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
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage fecharTarefas = new TarefasPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        fecharTarefas.verificoSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void fecharAtividade(){

        fecharTarefas.euAcionoComandoFecharTarefa();
        fecharTarefas.euAdicionoInformacaoTarefa(PropriedadesTarefas.informacaoAdicionadaEmTarefa);
        fecharTarefas.euConfirmoFechamentoComandoFecharTarefa();
        Assert.assertTrue(fecharTarefas.euVerificoStatusFechado());

    }

    @After
    public void tearDown(){

        logout.euRealizoLogout();
    }
}
