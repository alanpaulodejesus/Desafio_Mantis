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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class CriarProjetoTest {


    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    public CriarProjetoTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
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
    public void tearDown() throws Exception {

        projeto.registrarCriarProjeto();
        Assert.assertTrue(projeto.verificarCriarProjetoEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
