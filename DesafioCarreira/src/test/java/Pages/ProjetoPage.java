package Pages;

import Core.PropriedadesProjeto;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import TestProjeto.CriarProjetoTest;
import TestProjeto.ExcluirProjetoTest;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class ProjetoPage {

    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(linkText = "Gerenciar Projetos") private WebElement menuGerenciarProjetos;
    @FindBy(xpath = "//button[text()=\"Criar Novo Projeto\"]") private WebElement comandoCriarProjeto;
    @FindBy(id = "project-name") private WebElement campoNomeProjeto;
    @FindBy(xpath = "//input[@value=\"Adicionar projeto\"]") private WebElement comandoAdicionarProjeto;
    @FindBy(linkText = PropriedadesProjeto.nomeProjeto) private WebElement projetoEmGrid;
    @FindBy(xpath = "//td[text()=\"privado\"]") private  WebElement projetoPrivado;
    @FindBy(xpath = "//td[text()=\"público\"]") private  WebElement projetoPublico;
    @FindBy(linkText = PropriedadesProjeto.nomeProjetoPrivado) private WebElement projetoPrivadoEmGrid;
    @FindBy(linkText = PropriedadesProjeto.nomeProjetoPublico) private WebElement projetoPublicoEmGrid;
    @FindBy(linkText = PropriedadesProjeto.nomeProjetoMoverTarefa) private WebElement projetoEmGridParaMoverTarefa;
    @FindBy(id = "project-description") private WebElement campoDescricaoProjeto;
    @FindBy(xpath = "//input[@value=\"Atualizar Projeto\"]") private WebElement comandoAtualizarProjeto;
    @FindBy(xpath = "//input[@value=\"Apagar Projeto\"]") private WebElement comandoApagarProjeto;
    @FindBy(xpath = "//i[@class=\"ace-icon fa fa-angle-down bigger-110\"]") private WebElement selecionarProjeto;
    @FindBy(linkText = ""+PropriedadesProjeto.nomeProjetoMoverTarefa+"") private WebElement projetoTarefaMovida;
    @FindBy(id = "project-view-state") private WebElement comboVisibilidadeProjeto;

    public ProjetoPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }


    public void acionarMenuGerenciar(){

        Comando.clicar(menuGerenciar);
    }

    public void acionarMenuGerenciarProjetos(){

        Comando.clicar(menuGerenciarProjetos);
    }
    public void acionarComandoCriarProjetos(){

        Comando.clicar(comandoCriarProjeto);
    }
    public void preencherCampoNomeProjeto(String texto){

        CampoTexto.preencher(campoNomeProjeto, texto);
    }

    public void acionarComandoAdicionarProjeto(){

        Comando.clicar(comandoAdicionarProjeto);
    }

    public Boolean verificarProjetoEmGrid(){
        Tempo.aguardar(5, projetoEmGrid);
        try {
            Label.textoPresente(projetoEmGrid);
            projetoEmGrid.getSize();
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public Boolean verificarProjetoNaoEstaEmGrid(){
        try {
            Label.textoPresente(projetoEmGrid);
            projetoEmGrid.getSize();
            return false;

        }catch (Exception e){
            return true;
        }

    }

    public Boolean verificarProjetoPrivadoEmGrid(){

        if (Label.textoPresente(projetoPublicoEmGrid) && Label.textoPresente(projetoPrivado)){
            return true;
        }else{
            return false;
        }

    }

    public Boolean verificarProjetoPublicoEmGrid(){

        if (Label.textoPresente(projetoPrivadoEmGrid) && Label.textoPresente(projetoPublico)){
            return true;
        }else{
            return false;
        }

    }

    public void acionarComandoAtualizarProjeto(){
        Comando.clicar(comandoAtualizarProjeto);
    }

    public void preencherDescricaoProjeto(String texto){
        CampoTexto.limpar(campoDescricaoProjeto);
        CampoTexto.preencher(campoDescricaoProjeto, texto);
    }
    public void acionarProjetoEmGrid() {
        Comando.clicar(projetoEmGrid);
    }

    public void acionarProjetoPrivadoEmGrid() {
        Comando.clicar(projetoPrivadoEmGrid);
    }

    public void acionarProjetoPublicoEmGrid() {
        Comando.clicar(projetoPublicoEmGrid);
    }

    public void acionarComandoApagarProjeto() {
        Comando.clicar(comandoApagarProjeto);
    }


    public void verificarSeExisteProjetoAExcluir() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);
        CriarProjetoTest criaProjeto = new CriarProjetoTest();
        ExcluirProjetoTest excluirProjeto = new ExcluirProjetoTest();

        if(Label.textoPresente(projetoEmGrid)){
            excluirProjeto.excluirProjeto();
        }else {

        }
    }

    public void verificarSeExisteProjeto() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);
        CriarProjetoTest criaProjeto = new CriarProjetoTest();


        if(Label.textoPresente(projetoEmGrid)){

        }else {
            criaProjeto.criarNovoProjeto();

        }
    }

    public void verificarSeExisteProjetoPrivado() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);
        CriarProjetoTest criaProjeto = new CriarProjetoTest();


        if(Label.textoPresente(projetoPrivadoEmGrid)){

        }else {
            criaProjeto.criarNovoProjetoPublico();

        }
    }

    public void verificarSeExisteProjetoPublico() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);
        CriarProjetoTest criaProjeto = new CriarProjetoTest();


        if(Label.textoPresente(projetoPublicoEmGrid)){


        }else {
            criaProjeto.criarNovoProjetoPrivado();

        }
    }

    public void verificarSeExisteProjetoParaMoverTarefa() {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);

        if(Label.textoPresente(projetoEmGridParaMoverTarefa)){

        }else {
            acionarMenuGerenciar();
            acionarMenuGerenciarProjetos();
            acionarComandoCriarProjetos();
            preencherCampoNomeProjeto(PropriedadesProjeto.nomeProjetoMoverTarefa);
            acionarComandoAdicionarProjeto();

        }
    }

    public void selecionarProjetoComTarefaMovida(){
        Comando.clicar(selecionarProjeto);
        Comando.clicar(projetoTarefaMovida);
    }

    public void selecionarProjeto(){
        Comando.clicar(selecionarProjeto);
        Comando.clicar(projetoEmGrid);
    }

    public void selecionarComboVisibilidadeProjetoPublico(String texto){
        Combo.selecionarCombo(comboVisibilidadeProjeto, texto);
    }

    public void selecionarComboVisibilidadeProjetoPrivado(String texto){
        Combo.selecionarCombo(comboVisibilidadeProjeto, texto);
    }
}
