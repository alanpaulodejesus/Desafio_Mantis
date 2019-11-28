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

public class AlterarStatusTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    LoginPage logout = new LoginPage();
    TarefasPage alterarStatusTarefas = new TarefasPage();

    public AlterarStatusTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        alterarStatusTarefas.verificarSeExisteTarefa();

    }

    @Test
    public void alterarStatusAtividade(){

        alterarStatusTarefas.acionarMenuVerTarefas();
        alterarStatusTarefas.acionarIconeEditar();
        alterarStatusTarefas.selecionarGravidadeObstaculoBug(PropriedadesTarefas.gravidadeBugObstaculo);
        alterarStatusTarefas.acionarComandoAtualizacaoInformacaoEmTarefa();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(alterarStatusTarefas.verificarAlteracaoStatusEmAtividade());
        alterarStatusTarefas.excluirTodasTarefas();
        logout.realizarLogout();
    }
}
