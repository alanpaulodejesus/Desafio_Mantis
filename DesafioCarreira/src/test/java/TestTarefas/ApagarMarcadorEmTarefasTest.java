package TestTarefas;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.MarcadorPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class ApagarMarcadorEmTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage apagarMarcadorEmTarefa = new TarefasPage();
    MarcadorPage marcadorDeTarefas = new MarcadorPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        apagarMarcadorEmTarefa.verificoSeTarefaPossuiMarcador();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void apagarMarcadorEmAtividade(){

        apagarMarcadorEmTarefa.euAcionoIconeExluirMarcador();
    }

    @After
    public void tearDown(){

        Assert.assertFalse(apagarMarcadorEmTarefa.euVerificoMarcadorEmTarefa());
        apagarMarcadorEmTarefa.excluirTodasTarefas();
        logout.euRealizoLogout();
    }
}
