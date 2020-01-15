package TestProjeto;

import Core.Propriedades;
import Core.PropriedadesProjeto;
import Pages.LoginPage;
import Pages.ProjetoPage;
import TestLogin.LoginValidoTest;
import Utils.DataBaseConector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.DataBaseConector.fecharConexao;
import static Utils.DataBaseConector.iniciaConexao;
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

        iniciaConexao();
        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarComandoCriarProjetos();
        projeto.preencherCampoNomeProjeto( DataBaseConector.nomeProjeto);
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

        fecharConexao();
        projeto.registrarCriarProjeto();
        Thread.sleep( 4000 );
        Assert.assertTrue(projeto.verificarCriarProjetoEmGrid());
        logout.realizarLogout();
        closeRelatorio();

    }
}
