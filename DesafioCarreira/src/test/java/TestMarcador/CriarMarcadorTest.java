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

public class CriarMarcadorTest {

    LoginPage logout = new LoginPage();
    LoginValidoTest login = new LoginValidoTest();
    MarcadorPage marcador = new MarcadorPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
        login.realizarLoginValido();
        marcador.verificarSeExisteMarcadorAExcluir();

    }


    @Test
    public void criarMarcador(){

        marcador.acionarMenuGerenciar();
        marcador.acionarMenuGerenciaMarcador();
        marcador.preencherCampoNomeMarcador(PropriedadesMarcador.nomeMacador);
        marcador.preencherCampoDescricaoMarcador(PropriedadesMarcador.nomeDescricaoMarcador);
        marcador.acionarComandoCriarMarcador();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(marcador.verificarMarcadorEmGrid());
        logout.realizarLogout();
    }
}
