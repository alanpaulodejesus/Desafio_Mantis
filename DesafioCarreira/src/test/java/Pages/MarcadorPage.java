package Pages;

import Core.PropriedadesMarcador;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestMarcador.CriarMarcadorTest;
import TestMarcador.ExcluirMarcadorTest;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class MarcadorPage {

    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(linkText = "Gerenciar Marcadores") private WebElement menuGerenciarMarcadores;
    @FindBy(xpath = "//*[contains(text(),'"+ PropriedadesMarcador.nomeMacador+"')]") private WebElement marcadorEmGrid;
    @FindBy(id = "tag-name")private WebElement campoNomeMarcador;
    @FindBy(id = "tag-description")private WebElement campoDescricaoMarcador;
    @FindBy(name = "config_set") private WebElement comandoCriarMarcador;
    @FindBy(xpath = "//input[@value=\"Apagar Marcador\"]") private WebElement comandoApagarMarcador;
    @FindBy(xpath = "//input[@value=\"Atualizar Marcador\"]") private WebElement comandoAtualizarMarcador;


    public MarcadorPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euAcionoMenuGerenciar()  {
        Comando.clicar(menuGerenciar);
    }
    public void euAcionoMenuGerenciaMarcador()  {
        Comando.clicar(menuGerenciarMarcadores);
    }
    public void euAcionoComandoAtualizarMarcador()  {
        Comando.clicar(comandoAtualizarMarcador);
    }


    public void euAcionoMarcadorEmGrid()  {
        Comando.clicar(marcadorEmGrid);
    }

    public void euAcionoComandoApagarMarcador()  {
        Comando.clicar(comandoApagarMarcador);
    }

    public void euPreenchoCampoNomeMarcador(String texto){
        CampoTexto.preencher(campoNomeMarcador,texto );
    }

    public void euPreenchoCampoDescricaoMarcador(String texto){
        CampoTexto.limpar(campoDescricaoMarcador);
        CampoTexto.preencher(campoDescricaoMarcador, texto);
    }

    public void euAcionoComandoCriarMarcador(){
        Comando.clicar(comandoCriarMarcador);
    }

    public void verificoSeExisteMarcadorAExcluir(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarMarcadores);
        ExcluirMarcadorTest exluirMarcador = new ExcluirMarcadorTest();

        if(Label.textoPresente(marcadorEmGrid)){
            exluirMarcador.excluirMarcador();
        }else {

        }
    }

    public Boolean euVerificoMarcadorEmGrid(){
        Tempo.aguardar(5, marcadorEmGrid);
        try {
            Label.textoPresente(marcadorEmGrid);
            marcadorEmGrid.getSize();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Boolean euVerificoMarcadorNaoEstaEmGrid(){
        //Tempo.aguardar(5, comboSelecionarPerfil);


        try {
            Label.textoPresente(marcadorEmGrid);
            marcadorEmGrid.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void verificoSeExisteMarcador(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarMarcadores);
        CriarMarcadorTest criarMarcador = new CriarMarcadorTest();


        if(Label.textoPresente(marcadorEmGrid)){

        }else {
            criarMarcador.criarMarcador();

        }
    }

}
