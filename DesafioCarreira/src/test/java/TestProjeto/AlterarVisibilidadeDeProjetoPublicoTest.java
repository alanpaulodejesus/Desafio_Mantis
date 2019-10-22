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

public class AlterarVisibilidadeDeProjetoPublicoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificarSeExisteProjetoPublico();

    }


    @Test
    public void alterarProjetoPrivadoParaPublico(){


        projeto.acionarMenuGerenciar();
        projeto.acionarMenuGerenciarProjetos();
        projeto.acionarProjetoPrivadoEmGrid();
        projeto.selecionarComboVisibilidadeProjetoPrivado(PropriedadesProjeto.projetoPublico);
        projeto.acionarComandoAtualizarProjeto();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.verificarProjetoPublicoEmGrid());
        projeto.acionarProjetoPrivadoEmGrid();
        projeto.acionarComandoApagarProjeto();
        projeto.acionarComandoApagarProjeto();
        logout.realizarLogout();
    }
}
