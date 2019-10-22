package TestTarefas;

import Core.Propriedades;
import Core.PropriedadesMarcador;
import Pages.LoginPage;
import Pages.MarcadorPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class AdicionarMarcadorEmTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage adicionarMarcadorEmTarefa = new TarefasPage();
    MarcadorPage marcadorDeTarefas = new MarcadorPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        marcadorDeTarefas.verificarSeExisteMarcador();
        adicionarMarcadorEmTarefa.verificarSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void adicionarMarcadorEmAtividade(){

        adicionarMarcadorEmTarefa.selecionarMarcador(PropriedadesMarcador.nomeMacador);
        adicionarMarcadorEmTarefa.acionarComandoAplicar();
    }

    @After
    public void tearDown(){

        Assert.assertTrue(adicionarMarcadorEmTarefa.verificarMarcadorEmTarefa());
        logout.realizarLogout();
    }
}
