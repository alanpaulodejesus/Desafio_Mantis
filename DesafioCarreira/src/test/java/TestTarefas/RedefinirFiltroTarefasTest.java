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

public class RedefinirFiltroTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage redefinirFiltroTarefa = new TarefasPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        redefinirFiltroTarefa.verificoSeExisteTarefa();
        redefinirFiltroTarefa.verificoSeExisteFiltroTarefa();

    }

    @Test
    public void redefinirFiltroAtividade(){

        redefinirFiltroTarefa.euAcionoComandoRedefinir();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(redefinirFiltroTarefa.euVerificoRedefinicaoTarefa());
        logout.euRealizoLogout();
    }
}
