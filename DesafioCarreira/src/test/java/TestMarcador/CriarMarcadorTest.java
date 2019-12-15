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

public class CriarMarcadorTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage marcador = new MarcadorPage();

    public CriarMarcadorTest() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        marcador.verificarSeExisteMarcadorAExcluir();

    }

    @Test
    public void criarMarcador() {

        marcador.acionarMenuGerenciar();
        marcador.acionarMenuGerenciaMarcador();
        marcador.preencherCampoNomeMarcador(PropriedadesMarcador.nomeMacador);
        marcador.preencherCampoDescricaoMarcador(PropriedadesMarcador.nomeDescricaoMarcador);
        marcador.acionarComandoCriarMarcador();


    }

    @After
    public void tearDown() throws Exception {
        marcador.registrarCriarMarcador();
        Assert.assertTrue(marcador.verificarMarcadorCriadoEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
