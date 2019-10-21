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
        projeto.verificoSeExisteProjetoPublico();

    }


    @Test
    public void alterarProjetoPrivadoParaPublico(){


        projeto.euAcionoMenuGerenciar();
        projeto.euAcionoMenuGerenciarProjetos();
        projeto.euAcionoProjetoPrivadoEmGrid();
        projeto.euSelecionoComboVisibilidadeProjetoPrivado(PropriedadesProjeto.projetoPublico);
        projeto.euAcionoComandoAtualizarProjeto();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.euVerificoProjetoPublicoEmGrid());
        projeto.euAcionoProjetoPrivadoEmGrid();
        projeto.euAcionoComandoApagarProjeto();
        projeto.euAcionoComandoApagarProjeto();
        logout.euRealizoLogout();
    }
}
