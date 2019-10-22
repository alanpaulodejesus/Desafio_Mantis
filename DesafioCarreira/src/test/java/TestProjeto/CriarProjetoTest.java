package TestProjeto;

import Core.Propriedades;
import Core.PropriedadesProjeto;
import Pages.LoginPage;
import Pages.ProjetoPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class CriarProjetoTest {


    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjetoAExcluir();

    }


    @Test
    public void criarNovoProjeto(){

        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarComandoCriarProjetos();
        projeto.preencherCampoNomeProjeto(PropriedadesProjeto.nomeProjeto);
        projeto.acionarComandoAdicionarProjeto();

    }

    public void criarNovoProjetoPublico(){

        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarComandoCriarProjetos();
        projeto.preencherCampoNomeProjeto(PropriedadesProjeto.nomeProjetoPublico);
        projeto.selecionarComboVisibilidadeProjetoPublico(PropriedadesProjeto.projetoPublico);
        projeto.acionarComandoAdicionarProjeto();

    }


    public void criarNovoProjetoPrivado(){

        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarComandoCriarProjetos();
        projeto.preencherCampoNomeProjeto(PropriedadesProjeto.nomeProjetoPrivado);
        projeto.selecionarComboVisibilidadeProjetoPublico(PropriedadesProjeto.projetoPrivado);
        projeto.acionarComandoAdicionarProjeto();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.verificarProjetoEmGrid());
        logout.realizarLogout();
    }
}
