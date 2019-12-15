package TestMarcador;

import Core.Propriedades;
import Core.PropriedadesMarcador;
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

public class AlterarMarcadorTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage alterarMarcador = new MarcadorPage();

    public AlterarMarcadorTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        alterarMarcador.verificarSeExisteMarcador();

    }


    @Test
    public void alterarMarcador(){

        alterarMarcador.acionarMenuGerenciar();
        alterarMarcador.acionarMenuGerenciaMarcador();
        alterarMarcador.acionarMarcadorEmGrid();
        alterarMarcador.acionarComandoAtualizarMarcador();
        alterarMarcador.preencherCampoDescricaoMarcador(PropriedadesMarcador.nomeDescricaoMarcadorAtualizado);
        alterarMarcador.acionarComandoAtualizarMarcador();
        alterarMarcador.acionarMenuGerenciar();
        alterarMarcador.acionarMenuGerenciaMarcador();


    }

    @After
    public void tearDown() throws Exception {
        alterarMarcador.registrarAlterarMarcador();
        Assert.assertTrue(alterarMarcador.verificarMarcadorEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
