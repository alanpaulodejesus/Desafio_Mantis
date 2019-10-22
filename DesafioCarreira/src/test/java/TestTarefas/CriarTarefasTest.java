package TestTarefas;

import Core.Propriedades;
import Core.PropriedadesTarefas;
import Pages.LoginPage;
import Pages.ProjetoPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class CriarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    TarefasPage criarTarefa = new TarefasPage();
    LoginPage logout = new LoginPage();
    ProjetoPage validarProjeto = new ProjetoPage();



    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        validarProjeto.verificarSeExisteProjeto();

    }


    @Test
    public void criarNovaTarefa(){

        criarTarefa.acessarMenuCriarTarefas();
        criarTarefa.acionarCategoriaTarefa(PropriedadesTarefas.categoriaBug);
        criarTarefa.acessarFrequenciaTarefa(PropriedadesTarefas.frequenciaBug);
        criarTarefa.acessarGravidadeTarefa(PropriedadesTarefas.gravidadeBugPequeno);
        criarTarefa.acessarPrioridadeTarefa(PropriedadesTarefas.prioridadeBug);
        criarTarefa.acessarAtribuicaoTarefa(Propriedades.USUARIO);
        criarTarefa.informarResumoTarefa(PropriedadesTarefas.resumoBug);
        criarTarefa.informarDescricaoBug(PropriedadesTarefas.descricaoBug);
        criarTarefa.informarReproducaoBug(PropriedadesTarefas.reproduzirBug);
        criarTarefa.acionarComandoCriarTarefa();
        criarTarefa.verificarIdTarefaCriada();
        Assert.assertTrue(criarTarefa.confirmarCadastroComSucesso());
    }

    @After
    public void tearDown(){

        logout.realizarLogout();
    }
}
