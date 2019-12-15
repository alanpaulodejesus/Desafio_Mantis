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
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class CadastrarCategoriaTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CategoriaPage categoria = new CategoriaPage();

    public CadastrarCategoriaTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
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
    public void tearDown() throws Exception {

        categoria.registrarCadastrarCategoria();
        Assert.assertTrue(categoria.verificarCategoriaCadastradaEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
