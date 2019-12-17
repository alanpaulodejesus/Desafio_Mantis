package TestTarefas;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class RedefinirFiltroTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage redefinirFiltroTarefa = new TarefasPage();

    public RedefinirFiltroTarefasTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        redefinirFiltroTarefa.verificarSeExisteTarefa();
        redefinirFiltroTarefa.verificarSeExisteFiltroTarefa();

    }

    @Test
    public void redefinirFiltroAtividade(){

        redefinirFiltroTarefa.acionarComandoRedefinir();

    }

    @After
    public void tearDown() throws Exception {

        redefinirFiltroTarefa.registraRedefinirTarefas();
        Assert.assertTrue(redefinirFiltroTarefa.verificarRedefinicaoTarefa());
        logout.realizarLogout();
        closeRelatorio();
    }
}
