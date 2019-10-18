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


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        alterarTarefas.verificoSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void alterarCategoriaAtividade(){

        alterarTarefas.euAcionoComandoAtualizar();
        alterarTarefas.euAcessoCategoriaTarefa(PropriedadesTarefas.categoriaDúvida);
        alterarTarefas.euAcionoComandoAtualizacaoInformacaoEmTarefa();
        Assert.assertEquals(PropriedadesTarefas.categoriaDúvida, alterarTarefas.euVerificoAlteracaoCategoria());
    }

    @After
    public void tearDown(){

        logout.euRealizoLogout();
    }
}
