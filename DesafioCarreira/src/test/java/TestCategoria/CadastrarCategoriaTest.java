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

    public CadastrarCategoriaTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        categoria.verificarSeExisteCategoriaCriada();
    }


    @Test
    public void cadastraCategoria(){

        categoria.acionarMenuGerenciar();
        categoria.acionarMenuGerenciarProjetos();
        categoria.preencherCampoNomeCategoria(PropriedadesCategoria.categoria);
        categoria.acionarComandoAdicionarCategoria();


    }


    @After
    public void tearDown(){

        Assert.assertTrue(categoria.verificarCategoriaEmGrid());
        logout.realizarLogout();
    }
}
