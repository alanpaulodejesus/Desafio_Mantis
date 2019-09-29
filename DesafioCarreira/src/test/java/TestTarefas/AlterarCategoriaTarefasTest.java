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

public class AlterarCategoriaTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    CriarTarefasTest criarTarefa = new CriarTarefasTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    ApagarTarefasTest apagarTarefa = new ApagarTarefasTest();
    TarefasPage alterarTarefas = new TarefasPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        criarTarefa.criarNovaTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void alterarAtividade(){

        alterarTarefas.euAcionoComandoAtualizar();
        alterarTarefas.euAcessoCategoriaTarefa(PropriedadesTarefas.categoriaDúvida);
        alterarTarefas.euAcionoComandoAtualizacaoInformacaoEmTarefa();
        Assert.assertEquals(PropriedadesTarefas.categoriaDúvida, alterarTarefas.euVerificoAlteracaoCategoria());
    }

    @After
    public void tearDown(){

        apagarTarefa.apagarTarefa();
        logout.euRealizoLogout();
    }
}
