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

public class AdicionarFiltroTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage adicionarFiltroTarefa = new TarefasPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        adicionarFiltroTarefa.verificoSeExisteTarefa();
    }

    @Test
    public void adicionarFiltroAtividade(){

        adicionarFiltroTarefa.euAcessoMenuVerTarefas();
        adicionarFiltroTarefa.euAcionoRelatorGrid();
        adicionarFiltroTarefa.euSelecionoRelator(PropriedadesTarefas.relatorAdministrador);
        adicionarFiltroTarefa.euAcionoComandoAplicaFiltro();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(adicionarFiltroTarefa.euVerificoTarefaEmGrid());
        logout.euRealizoLogout();
    }
}
