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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class ApagarCategoriaTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CategoriaPage categoria = new CategoriaPage();

    public ApagarCategoriaTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        categoria.verificarSeExisteCategoriaAExcluir();

    }


    @Test
    public void apagarCategoria(){

        categoria.acionarMenuGerenciar();
        categoria.acionarMenuGerenciarProjetos();
        categoria.acionarExcluirCategoria();
        categoria.confirmarExcluirCategoria();

    }


    @After
    public void tearDown() throws Exception {

        categoria.registrarApagarCategoria();
        Assert.assertFalse(categoria.verificarCategoriaApagadaEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
