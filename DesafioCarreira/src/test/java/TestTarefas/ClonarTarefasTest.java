package TestTarefas;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.ProjetoPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class ClonarTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage validarProjeto = new ProjetoPage();
    TarefasPage criarCloneTarefa = new TarefasPage();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        validarProjeto.verificoSeExisteProjeto();
        criarCloneTarefa.verificoSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();

    }


    @Test
    public void clonarTarefa(){

        criarCloneTarefa.euAcionoComandoCriarCloneTarefa();
        criarCloneTarefa.euAcionoComandoCriarTarefa();



    }


    @After
    public void tearDown(){

        Assert.assertTrue(criarCloneTarefa.euConfirmoCadastroComSucesso());
        criarCloneTarefa.excluirTodasTarefas();
        logout.euRealizoLogout();
    }
}
