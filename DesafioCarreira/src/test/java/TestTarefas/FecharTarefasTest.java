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

    public FecharTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        fecharTarefas.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void fecharAtividade(){

        fecharTarefas.acionarComandoFecharTarefa();
        fecharTarefas.adicionarInformacaoTarefa(PropriedadesTarefas.informacaoAdicionadaEmTarefa);
        fecharTarefas.confirmarFechamentoComandoFecharTarefa();
        Assert.assertTrue(fecharTarefas.verificarStatusFechado());

    }

    @After
    public void tearDown(){

        logout.realizarLogout();
    }
}
