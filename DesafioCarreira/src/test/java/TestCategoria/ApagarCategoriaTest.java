package TestCategoria;

import Core.Propriedades;
import Pages.CategoriaPage;
import Pages.LoginPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;

public class ApagarCategoriaTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CategoriaPage categoria = new CategoriaPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        categoria.euVerificoSeExisteCategoriaAExcluir();

    }


    @Test
    public void apagarCategoria(){

        categoria.euAcionoMenuGerenciar();
        categoria.euAcionoMenuGerenciarProjetos();
        categoria.euAcionoExcluirCategoria();
        categoria.euConfirmoExcluirCategoria();

    }


    @After
    public void tearDown(){

        Assert.assertFalse(categoria.euVerificoCategoriaEmGrid());
        //logout.euRealizoLogout();
    }
}
