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

public class AlterarVisibilidadeDeProjetoPrivadoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    ProjetoPage projeto = new ProjetoPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        projeto.verificoSeExisteProjetoPrivado();

    }


    @Test
    public void alterarProjetoPublicoParaPrivado(){


        projeto.euAcionoMenuGerenciar();
        projeto.euAcionoMenuGerenciarProjetos();
        projeto.euAcionoProjetoPublicoEmGrid();
        projeto.euSelecionoComboVisibilidadeProjetoPrivado(PropriedadesProjeto.projetoPrivado);
        projeto.euAcionoComandoAtualizarProjeto();

    }

    @After
    public void tearDown(){
        Assert.assertTrue(projeto.euVerificoProjetoPrivadoEmGrid());

        projeto.euAcionoProjetoPublicoEmGrid();
        projeto.euAcionoComandoApagarProjeto();
        projeto.euAcionoComandoApagarProjeto();
        logout.euRealizoLogout();

    }
}
