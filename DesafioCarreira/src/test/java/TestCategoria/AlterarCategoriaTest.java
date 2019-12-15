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

public class AlterarCategoriaTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CategoriaPage categoria = new CategoriaPage();

    public AlterarCategoriaTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        categoria.verificarSeExisteCategoriaAAlterar();

    }


    @Test
    public void alterarCategoria(){

        categoria.acionarMenuGerenciar();
        categoria.acionarMenuGerenciarProjetos();
        categoria.acionarAlterarCategoria();
        categoria.preencherCampoNomeCategoria(PropriedadesCategoria.categoriaAlterada);
        categoria.acionarComandoAtualizarCategoria();

    }


    @After
    public void tearDown() throws Exception {

        categoria.registrarAlterarCategoria();
        Assert.assertTrue(categoria.verificarCategoriaEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
