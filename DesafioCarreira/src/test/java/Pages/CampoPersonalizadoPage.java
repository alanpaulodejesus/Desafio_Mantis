package Pages;

import Core.PropriedadesCampoPersonalizado;
import Core.PropriedadesProjeto;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestCampoPersonalizado.AdicionarCampoPersonalizadoEmProjetoTest;
import TestCampoPersonalizado.CriarCampoPersonalizadoTest;
import TestCampoPersonalizado.ExcluirCampoPersonalizadoTest;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class CampoPersonalizadoPage {

    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(linkText = "Gerenciar Campos Personalizados") private WebElement menuCampoPersonalizados;
    @FindBy(name = "name") private WebElement campoNomePersonalizado;
    @FindBy(xpath = "//input[@value=\"Novo Campo Personalizado\"]") private WebElement comandoNovoCampoPersonalizado;
    @FindBy(linkText = PropriedadesCampoPersonalizado.nomeCampoPersonalizado) private WebElement campoPersonalizadoEmGrid;
    @FindBy(linkText = PropriedadesCampoPersonalizado.nomeCampoPersonalizadoAlterado) private WebElement campoPersonalizadoAlteradoEmGrid;
    @FindBy(xpath = "//input[@value=\"Atualizar Campo Personalizado\"]") private WebElement comandoNovoCampoPersonalizaoAlterar;
    @FindBy(xpath = "//input[@value=\"Apagar Campo Personalizado\"]") private WebElement comandoApagarCampoPersonalizado;
    @FindBy(xpath = "//input[@value=\"Apagar Campo\"]") private WebElement comandoConfirmaApagarCampoPersonalizado;
    @FindBy(xpath = "//option[text()=\""+ PropriedadesProjeto.nomeProjeto+"\"]") private WebElement projetoParaCampoPersonalizado;
    @FindBy(xpath = "//input[@value=\"Vincular Campo Personalizado\"]") private WebElement comandoVincularProjeto;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-white btn-round btn-xs']") private WebElement comandoRemover;
    @FindBy(xpath = "//input[@value=\"Remover Campo\"]") private WebElement comandoConfirmaRemover;

    public CampoPersonalizadoPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void acionarComandoMenuGerenciar()  {
        Tempo.aguardar(2, menuGerenciar);
        Comando.clicar(menuGerenciar);
    }

    public void acionarComandoApagarCampoPersonalizado(){
        Tempo.aguardar(2,comandoApagarCampoPersonalizado);
        Comando.clicar(comandoApagarCampoPersonalizado);
    }

    public void acionarComandoConfirmarApagarCampoPersonalizado(){
        Tempo.aguardar(2, comandoConfirmaApagarCampoPersonalizado);
        Comando.clicar(comandoConfirmaApagarCampoPersonalizado);
    }

    public void preencherCampoNomePersonalizado(String texto)  {
        Tempo.aguardar(2, campoNomePersonalizado);
        CampoTexto.preencher(campoNomePersonalizado, texto);
    }

    public void acionarMenuCampoPersonalizado(){
        Tempo.aguardar(5, menuCampoPersonalizados);
        Comando.clicar(menuCampoPersonalizados);
    }

    public void euAcionoComandoNovoCampoPersonalizado(){
        Tempo.aguardar(2,comandoNovoCampoPersonalizado);
        Comando.clicar(comandoNovoCampoPersonalizado);
    }

    public void acionarComandoAlterarCampoPersonalizado(){
        Tempo.aguardar(2, comandoNovoCampoPersonalizaoAlterar);
        Comando.clicar(comandoNovoCampoPersonalizaoAlterar);
    }

    public void acionarCampoPersonalizadoEmGrid(){

        if(Label.textoPresente(campoPersonalizadoEmGrid)){
            Comando.clicar(campoPersonalizadoEmGrid);
        }else {
            Comando.clicar(campoPersonalizadoAlteradoEmGrid);
        }

    }

    public void acionarCampoPersonalizadoParaAdicionarEmGrid(){

        if(Label.textoPresente(campoPersonalizadoEmGrid)){
            Comando.clicar(campoPersonalizadoEmGrid);
        }else Comando.clicar(campoPersonalizadoAlteradoEmGrid);

    }

    public Boolean verificarCampoPersonalizadoEmGrid() {
        Tempo.aguardar(15, campoPersonalizadoEmGrid);
        try {
            Label.textoPresente(campoPersonalizadoEmGrid);
            campoPersonalizadoEmGrid.getSize();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verificarCampoPersonalizadoAlteradoEmGrid() {
        Tempo.aguardar(5, campoPersonalizadoAlteradoEmGrid);
        try {

            Label.textoPresente(campoPersonalizadoAlteradoEmGrid);
            campoPersonalizadoAlteradoEmGrid.getSize();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verificarCampoPersonalizadoExcluidoEmGrid() {
        try {

            if (Label.textoNaoPresente(campoPersonalizadoEmGrid)){
                campoPersonalizadoEmGrid.getSize();
            }else if(Label.textoNaoPresente(campoPersonalizadoAlteradoEmGrid)){
                campoPersonalizadoAlteradoEmGrid.getSize();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void verificarSeExisteCampoPersonalidadoAExcluir(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuCampoPersonalizados);
        ExcluirCampoPersonalizadoTest excluiCampoPersonalidado = new ExcluirCampoPersonalizadoTest();

        if(Label.textoPresente(campoPersonalizadoEmGrid)){
            excluiCampoPersonalidado.excluirCampoPersonalizado();
        }else {

        }
    }

    public void verificarSeExisteCampoPersonalidado(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuCampoPersonalizados);
        CriarCampoPersonalizadoTest criaCampoPersonalizado = new CriarCampoPersonalizadoTest();


        if(Label.textoPresente(campoPersonalizadoEmGrid) || Label.textoPresente(campoPersonalizadoAlteradoEmGrid)){

        }else {
            criaCampoPersonalizado.criarCampoPersonalizado();

        }
    }

    public void acionarProjetoParaCampoPersonalizado(){
        Tempo.aguardar(2, projetoParaCampoPersonalizado);
            Comando.clicar(projetoParaCampoPersonalizado);


    }

    public void acionarComandoVincularProjeto(){
        Tempo.aguardar(2, comandoVincularProjeto);
        Comando.clicar(comandoVincularProjeto);
    }


    public Boolean verificarCampoVinculadoEmGrid() {
        try {
            Label.textoPresente(comandoRemover);
            comandoRemover.getSize();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void acionarComandoRemover(){
        Tempo.aguardar(2, comandoRemover);
        Comando.clicar(comandoRemover);
    }

    public void acionarComandoConfirmaRemover(){
        Tempo.aguardar(2, comandoConfirmaRemover);
        Comando.clicar(comandoConfirmaRemover);
    }

    public void verificarSeExisteCampoPersonalizadoAdicionado() {

        AdicionarCampoPersonalizadoEmProjetoTest adicionar = new AdicionarCampoPersonalizadoEmProjetoTest();
        Comando.clicar(campoPersonalizadoEmGrid);

        if(Label.textoPresente(comandoRemover)){

        }else {
            adicionar.adicionaCampoPersonalizadoEmProjeto();
        }
    }

    public void excluirTodosCamposPersonalizados(){

        ExcluirCampoPersonalizadoTest excluiCampoPersonalizado = new ExcluirCampoPersonalizadoTest();
        Comando.clicar(menuGerenciar);
        Comando.clicar(menuCampoPersonalizados);

        if(Label.textoPresente(campoPersonalizadoEmGrid)&& Label.textoPresente(campoPersonalizadoAlteradoEmGrid)){

            while (Label.textoPresente(campoPersonalizadoEmGrid)&&Label.textoPresente(campoPersonalizadoAlteradoEmGrid)){
                excluiCampoPersonalizado.excluirCampoPersonalizado();
            }
        }else if(Label.textoPresente(campoPersonalizadoEmGrid)){
            excluiCampoPersonalizado.excluirCampoPersonalizado();
        }else if (Label.textoPresente(campoPersonalizadoAlteradoEmGrid)){
            excluiCampoPersonalizado.excluirCampoPersonalizado();
        }

    }
}
