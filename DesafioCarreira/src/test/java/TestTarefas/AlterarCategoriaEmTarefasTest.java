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

public class AlterarCategoriaEmTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage alterarTarefas = new TarefasPage();

    public AlterarCategoriaEmTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        alterarTarefas.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void alterarCategoriaAtividade(){

        alterarTarefas.acionarComandoAtualizar();
        alterarTarefas.acionarCategoriaTarefa(PropriedadesTarefas.categoriaDúvida);
        alterarTarefas.acionarComandoAtualizacaoInformacaoEmTarefa();
        Assert.assertEquals(PropriedadesTarefas.categoriaDúvida, alterarTarefas.verificarAlteracaoCategoria());
    }

    @After
    public void tearDown(){

        logout.realizarLogout();
    }
}
