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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class CriarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    TarefasPage criarTarefa = new TarefasPage();
    LoginPage logout = new LoginPage();
    ProjetoPage validarProjeto = new ProjetoPage();

    public CriarTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        validarProjeto.verificarSeExisteProjeto();

    }


    @Test
    public void criarNovaTarefa() throws InterruptedException {

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

    }

    @After
    public void tearDown() throws Exception {

        criarTarefa.registrarCriarTarefas();
        Assert.assertTrue(criarTarefa.confirmarCriarTarefaComSucesso());
        logout.realizarLogout();
        closeRelatorio();
    }
}
