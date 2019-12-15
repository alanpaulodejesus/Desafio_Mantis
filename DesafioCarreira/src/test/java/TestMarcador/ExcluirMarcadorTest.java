package TestMarcador;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.MarcadorPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class ExcluirMarcadorTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage marcador = new MarcadorPage();

    public ExcluirMarcadorTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        marcador.verificarSeExisteMarcador();

    }


    @Test
    public void excluirMarcador(){

        marcador.acionarMenuGerenciar();
        marcador.acionarMenuGerenciaMarcador();
        marcador.acionarMarcadorEmGrid();
        marcador.acionarComandoApagarMarcador();
        marcador.acionarComandoApagarMarcador();


    }

    @After
    public void tearDown() throws Exception {
        marcador.registrarExcluirMarcador();
        Assert.assertTrue(marcador.verificarMarcadorNaoEstaEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
