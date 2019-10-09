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
        alterarMarcador.verificoSeExisteMarcador();

    }


    @Test
    public void alterarMarcador(){

        alterarMarcador.euAcionoMenuGerenciar();
        alterarMarcador.euAcionoMenuGerenciaMarcador();
        alterarMarcador.euAcionoMarcadorEmGrid();
        alterarMarcador.euAcionoComandoAtualizarMarcador();
        alterarMarcador.euPreenchoCampoDescricaoMarcador(PropriedadesMarcador.nomeDescricaoMarcadorAtualizado);
        alterarMarcador.euAcionoComandoAtualizarMarcador();
        alterarMarcador.euAcionoMenuGerenciar();
        alterarMarcador.euAcionoMenuGerenciaMarcador();


    }

    @After
    public void tearDown(){
        Assert.assertTrue(alterarMarcador.euVerificoMarcadorEmGrid());
        logout.euRealizoLogout();
    }
}
