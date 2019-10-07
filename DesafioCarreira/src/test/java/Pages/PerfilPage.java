package Pages;

import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import TestPerfil.CriarPerfilTest;
import TestPerfil.ExcluirPerfilTest;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class PerfilPage {

    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(linkText = "Gerenciar Perfís Globais") private WebElement menuGerenciarPerfisGlobais;
    @FindBy(name = "platform") private WebElement campoPlataforma;
    @FindBy(name = "os") private WebElement campoOS;
    @FindBy(id = "os-version") private WebElement campoVersaoOS;
    @FindBy(xpath = "//input[@value=\"Adicionar Perfil\"]") private WebElement comandoAdicionarPerfil;
    @FindBy(xpath = "//input[@value=\"Atualizar Perfil\"]") private WebElement comandoAlterarPerfil;
    @FindBy(id = "select-profile") private WebElement comboSelecionarPerfil;
    @FindBy(xpath = "//span[@class=\"lbl\"]") private WebElement comandoRadioAlterar;
    @FindBy(xpath = "//tr[2]//td[2]//label[1]//span[1]") private WebElement comandoRadioApagar;

    @FindBy(xpath = "//input[@value=\"Enviar\"]") private WebElement comandoEnviar;
    @FindBy(id = "description") private WebElement campoDescricaoAdicional;
    @FindBy(name= "description") private WebElement campoDescricaoAdicionalAlteracao;

    @FindBy(name = "os_build") private WebElement campoVersaoOSAlteracao;

    public PerfilPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euAcionoComandoMenuGerenciar()  {
        Comando.clicar(menuGerenciar);
    }

    public void euAcionoComandoMenuGerenciarPerfisGlobais()  {
        Comando.clicar(menuGerenciarPerfisGlobais);
    }

    public void euPreenchoCampoPlataforma(String texto)  {
        CampoTexto.preencher(campoPlataforma, texto);
    }

    public void euPreenchoCampoOS(String texto)  {
        CampoTexto.preencher(campoOS, texto);
    }

    public void euPreenchoCampoVersaoOS(String texto)  {
        CampoTexto.preencher(campoVersaoOS, texto);
    }

    public void euAcionoComandoAdicionarPerfil()  {
        Comando.clicar(comandoAdicionarPerfil);
    }
    public void euAcionoComandoAtualizarPerfil()  {
        Comando.clicar(comandoAlterarPerfil);
    }


    public Boolean euVerificoPerfilEmGrid(){
        Tempo.aguardar(5, comboSelecionarPerfil);
        try {
            Label.textoPresente(comboSelecionarPerfil);
            comboSelecionarPerfil.getSize();
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public Boolean euVerificoPerfilNaoEstaEmGrid(){
        //Tempo.aguardar(5, comboSelecionarPerfil);


        try {
            Label.textoPresente(comboSelecionarPerfil);
            comboSelecionarPerfil.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void euSelecionoComboPerfil(String texto){
        Combo.selecionarCombo(comboSelecionarPerfil,texto);
    }

    public void euSelecionoRadioAlterar(){
        Comando.clicar(comandoRadioAlterar);
    }

    public void euSelecionoRadioApagar(){
        Comando.clicar(comandoRadioApagar);
    }

    public void euAcionoComandoEnviar(){
        Comando.clicar(comandoEnviar);
    }

    public void euPreenchoDescricaoAdicional(String texto){
        CampoTexto.preencher(campoDescricaoAdicional, texto);
    }

    public void euPreenchoDescricaoAdicionalAlteracao(String texto){
        CampoTexto.preencher(campoDescricaoAdicionalAlteracao, texto);
    }

    public void euPreenchoCampoVersaoOSAlteracao(String texto) {
        CampoTexto.preencher(campoVersaoOSAlteracao, texto);
    }

    public void verificoSeExistePerfilAExcluir(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarPerfisGlobais);
        ExcluirPerfilTest excluiPerfil = new ExcluirPerfilTest();

        if(Label.textoPresente(comboSelecionarPerfil)){
            excluiPerfil.excluirPerfil();
        }else {

        }
    }

    public void verificoSeExistePerfil(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarPerfisGlobais);
        CriarPerfilTest criaPerfil = new CriarPerfilTest();


        if(Label.textoPresente(comboSelecionarPerfil)){
            //cria.criarNovaTarefa();
        }else {
            criaPerfil.criarPerfil();

        }
    }
}
