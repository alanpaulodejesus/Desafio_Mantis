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

public class CriarTarefasTest {

    TarefasPage criarTarefa = new TarefasPage();
    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
    }


    @Test
    public void criarNovaTarefa(){


        criarTarefa.euAcessoMenuCriarTarefas();
        criarTarefa.euAcessoCategoriaTarefa(PropriedadesTarefas.categoriaBug);
        criarTarefa.euAcessoFrequenciaTarefa(PropriedadesTarefas.frequenciaBug);
        criarTarefa.euAcessoGravidadeTarefa(PropriedadesTarefas.gravidadeBug);
        criarTarefa.euAcessoPrioridadeTarefa(PropriedadesTarefas.prioridadeBug);
        criarTarefa.euAcessoAtribuicaoTarefa(Propriedades.USUARIO);

        criarTarefa.euInformoResumoTarefa(PropriedadesTarefas.resumoBug);
        criarTarefa.euInformoDescricaoBug(PropriedadesTarefas.descricaoBug);
        criarTarefa.euInformoReproducaoBug(PropriedadesTarefas.reproduzirBug);

        criarTarefa.euAcionoComandoCriarTarefa();
        criarTarefa.euVerificoIdTarefaCriada();
        Assert.assertTrue(criarTarefa.euConfirmoCadastroComSucesso());
    }

    @After
    public void tearDown(){

        logout.euRealizoLogout();
    }
}
