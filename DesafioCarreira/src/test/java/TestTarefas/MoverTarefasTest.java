package TestTarefas;

import Core.Propriedades;
import Core.PropriedadesProjeto;
import Pages.LoginPage;
import Pages.ProjetoPage;
import Pages.TarefasPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class MoverTarefasTest {

    LoginValidoTest login = new LoginValidoTest();
    PesquisarTarefasTest  pesquisaTarefa = new PesquisarTarefasTest();
    LoginPage logout = new LoginPage();
    TarefasPage moverTarefas = new TarefasPage();
    ProjetoPage verProjeto= new ProjetoPage();


    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        verProjeto.verificoSeExisteProjeto();
        verProjeto.verificoSeExisteProjetoParaMoverTarefa();
        verProjeto.euSelecionoProjeto();
        moverTarefas.verificoSeExisteTarefa();
        pesquisaTarefa.pesquisarAtividade();
    }

    @Test
    public void moverAtividade() {

        moverTarefas.euAcionoComandoMoverAtividade();
        moverTarefas.euSelecionoTarefaParaRemover(PropriedadesProjeto.nomeProjetoMoverTarefa);
        moverTarefas.euAcionoComandoConfirmarMoverAtividade();
        verProjeto.euSelecionoProjetoComTarefaMovida();

    }

    @After
    public void tearDown(){

        Assert.assertTrue(moverTarefas.euVerificoTarefaEmGrid());
        moverTarefas.excluirTodasTarefas();
        logout.euRealizoLogout();
    }
}
