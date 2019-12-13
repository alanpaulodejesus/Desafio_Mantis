package TestCampoPersonalizado;

import Core.Propriedades;
import Pages.CampoPersonalizadoPage;
import Pages.LoginPage;
import Pages.ProjetoPage;
import TestLogin.LoginValidoTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;

public class RemoverCampoPersonalizadoEmProjetoTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    CampoPersonalizadoPage removerCampoPersonalizado = new CampoPersonalizadoPage ();
    ProjetoPage projeto = new ProjetoPage();

    public RemoverCampoPersonalizadoEmProjetoTest() throws Exception {
    }


    @Before
    public void setUp() throws Exception {

        getDriver().get(Propriedades.URL);
        startRelatorio();
        login.realizarLoginValido();
        projeto.verificarSeExisteProjeto();
        removerCampoPersonalizado.verificarSeExisteCampoPersonalidado();
        removerCampoPersonalizado.verificarSeExisteCampoPersonalizadoAdicionado();

    }


    @Test
    public void removerCampoPersonalizadoEmProjeto(){

        removerCampoPersonalizado.acionarComandoMenuGerenciar();
        removerCampoPersonalizado.acionarMenuCampoPersonalizado();
        removerCampoPersonalizado.acionarCampoPersonalizadoParaAdicionarEmGrid();
        removerCampoPersonalizado.acionarComandoRemover();
        removerCampoPersonalizado.acionarComandoConfirmaRemover();


    }


    @After
    public void tearDown() throws Exception {

        removerCampoPersonalizado.registrarRemoverCampoPersonalizadoEmProjeto();
        Assert.assertTrue(removerCampoPersonalizado.verificarRemocaoCampoVinculadoEmGrid());
        logout.realizarLogout();
        closeRelatorio();
    }
}
