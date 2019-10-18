package TestCategoria;

import Core.Propriedades;
import Core.PropriedadesCategoria;
import Pages.CategoriaPage;
import Pages.LoginPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class CadastrarCategoriaTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CategoriaPage categoria = new CategoriaPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        categoria.euVerificoSeExisteCategoriaCriada();
    }


    @Test
    public void cadastraCategoria(){

        categoria.euAcionoMenuGerenciar();
        categoria.euAcionoMenuGerenciarProjetos();
        categoria.euPreenchoCampoNomeCategoria(PropriedadesCategoria.categoria);
        categoria.euAcionoComandoAdicionarCategoria();


    }


    @After
    public void tearDown(){

        Assert.assertTrue(categoria.euVerificoCategoriaEmGrid());
        logout.euRealizoLogout();
    }
}
