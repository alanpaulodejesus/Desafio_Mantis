package Pages;

import Core.DriverFactory;
import Core.PropriedadesProjeto;
import Core.PropriedadesUsuario;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import TestUsuario.ApagarUsuarioTest;
import TestUsuario.CriarUsuarioTest;
import TestUsuario.PesquisarUsuarioTest;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

public class UsuarioPage {

    @FindBy(xpath = "//a[text()=\" Convidar Usuários\"]") private WebElement comandoConvidarUsuario;
    @FindBy(id = "user-username") private WebElement campoNomeDeUsuario;
    @FindBy(id = "user-realname") private WebElement campoNomeVerdadeiro;
    @FindBy(id = "edit-username") private WebElement campoNomeDeUsuarioEditar;
    @FindBy(id = "edit-realname") private WebElement campoNomeVerdadeiroEditar;
    @FindBy(id = "email-field") private WebElement campoEmail;
    @FindBy(id = "user-access-level") private WebElement campoNivelAcesso;
    @FindBy(xpath = "//input[@value=\"Criar Usuário\"]") private WebElement comandoCriarUsuario;
    @FindBy(linkText = "Gerenciar Usuários") private WebElement menuGerenciarUsuario;
    @FindBy(xpath = "//td[text()=\""+ PropriedadesUsuario.email+"\"]") private WebElement verificoUsuarioCriadoEmGrid;
    @FindBy(linkText = PropriedadesUsuario.nomeUsuario) private WebElement nomeUsuarioEmGrid;
    @FindBy(linkText = PropriedadesUsuario.nomeUsuarioAlterado) private WebElement nomeUsuarioEmGridAlterado;
    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(id = "search") private WebElement campoFiltroUsuario;
    @FindBy(xpath = "//input[@value=\"Aplicar Filtro\"]") private WebElement comandoFiltroPesquisa;
    @FindBy(xpath = "//input[@value=\"Apagar Usuário\"]") private WebElement comandoApagarUsuario;
    @FindBy(xpath = "//input[@value=\"Apagar Conta\"]") private WebElement comandoApagarConta;
    @FindBy(xpath = "//input[@value=\"Atualizar Usuário\"]") private WebElement comandoAtualizarUsuario;
    @FindBy(xpath = "//option[text()=\""+ PropriedadesProjeto.nomeProjeto+"\"]")private WebElement projetoCombo;
    @FindBy(xpath = "//input[@value=\"Adicionar Usuário\"]")private WebElement comandoAdicionarUsuario;
    @FindBy(xpath = "//input[@value=\"Remover\"]") private WebElement comandoRemover;

    public UsuarioPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euAcionoComandoConvidarUsuario()  {
        Comando.clicar(comandoConvidarUsuario);
    }

    public void euPreenchoCampoNomeUsuario(String texto){
        CampoTexto.preencher(campoNomeDeUsuario, texto);
    }

    public void euPreenchoCampoNomeVerdadeiro(String texto){
        CampoTexto.preencher(campoNomeVerdadeiro, texto);
    }

    public void euPreenchoCampoEmail(String texto){
        CampoTexto.preencher(campoEmail, texto);
    }

    public void euAcionoComandoAdicionarUsuario(){
        Comando.clicar(comandoAdicionarUsuario);
    }
    public void euSelecionoNivelAcesso(String texto){
        Combo.selecionarCombo(campoNivelAcesso, texto);
    }

    public void euSelecionoProjetoAUsuario(){
        Comando.clicar(projetoCombo);
    }

    public void euAcionoComandoRemover(){
        Comando.clicar(comandoRemover);
    }

    public void euAcionoComandoCriarUsuario(){
        Comando.clicar(comandoCriarUsuario);
    }
    public void euAcionoMenuGerenciarUsuario(){
        Tempo.aguardar(30, menuGerenciarUsuario);
        Comando.clicar(menuGerenciarUsuario);
    }

    public Boolean euVerificoUsuarioCriadoEmGrid(){
        return Label.textoPresente(verificoUsuarioCriadoEmGrid);
    }

    public Boolean euVerificoUsuarioCriadoEmGridAlterado(){
        return Label.textoPresente(nomeUsuarioEmGridAlterado);
    }

    public void euAcionoMenuGerenciar(){
        Comando.clicar(menuGerenciar);
    }

    public void euPreenchoFiltroUsuario(String texto){
        CampoTexto.preencher(campoFiltroUsuario, texto);
    }

    public void euAcionoComandoPesquisa(){
        Comando.clicar(comandoFiltroPesquisa);
    }

    public void euAcionoNomeDeUsuarioEmGrid(){
        Comando.clicar(nomeUsuarioEmGrid);
    }

    public void euAcionoNomeDeUsuarioEmGridAlterado(){
        Comando.clicar(nomeUsuarioEmGridAlterado);
    }

    public void euAcionoComandoApagarUsuario(){
        Comando.clicar(comandoApagarUsuario);
    }


    public void euAcionoComandoApagarConta(){
        Comando.clicar(comandoApagarConta);
    }

    public Boolean euVerificoQueNomeUsuarioNaoEstaEmGrid(){

        try {
            Label.textoPresente(nomeUsuarioEmGrid);
            nomeUsuarioEmGrid.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void euPreenchoAlteracaoNomeUsuario(String texto){
        CampoTexto.preencher(campoNomeDeUsuarioEditar, texto);
    }

    public void euPreenchoAlteracaoNomeVerdadeiro(String texto){
        CampoTexto.preencher(campoNomeVerdadeiroEditar, texto);
    }

    public void euLimpoCamposDeDadosUsuarios(){
        CampoTexto.limpar(campoNomeDeUsuarioEditar);
        CampoTexto.limpar(campoNomeVerdadeiroEditar);
    }

    public void euAcionoComandoAtualizarUsuario(){
        Comando.clicar(comandoAtualizarUsuario);
        DriverFactory.getDriver().navigate().refresh();
    }

    public void excluirTodosUsuarios(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarUsuario);

        if(Label.textoPresente(nomeUsuarioEmGrid)){
            ApagarUsuarioTest excluiUsuarios = new ApagarUsuarioTest();
            excluiUsuarios.excluirUsuario();
        }else if(Label.textoPresente(nomeUsuarioEmGridAlterado)){
            euAcionoNomeDeUsuarioEmGridAlterado();
            euAcionoComandoApagarUsuario();
            euAcionoComandoApagarConta();
        }

    }


    public void euVerificoSeExisteUsuarioCriado() {
        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarUsuario);
        CriarUsuarioTest criarUsuario = new CriarUsuarioTest();
        PesquisarUsuarioTest pesquisaUsuario = new PesquisarUsuarioTest();


        if(Label.textoPresente(verificoUsuarioCriadoEmGrid)){

            pesquisaUsuario.pesquisaUsuario();
        }else {
            criarUsuario.criarNovoUsuario();
            pesquisaUsuario.pesquisaUsuario();

        }
    }

    public boolean euVerificoUsuarioAdicionadoEmProjeto() {
        return Label.textoPresente(comandoRemover);
    }
}
