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

public class AlterarMarcadorTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage alterarMarcador = new MarcadorPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
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
    public void tearDown(){
        Assert.assertTrue(alterarMarcador.verificarMarcadorEmGrid());
        logout.realizarLogout();
    }
}
