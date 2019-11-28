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
    @FindBy(xpath = "//span[@class=\"lbl\"]") private WebElement campoSelectHabilitado;
    @FindBy(xpath = "//i[@class=\"fa fa-check fa-lg\"]")private WebElement validacaoUsuarioAtivo;
    @FindBy(xpath = "//tr[2]//td[5]")private WebElement validacaoUsuarioNaoAtivo;
    @FindBy(xpath = "//input[@value=\"Redefinir Senha\"]") private WebElement comandoRedefinirSenha;
    @FindBy(xpath = "//span[text()=\"Mostrar desativados\"]")private WebElement selectPesquisaUsuarioDesabilitado;
    @FindBy(xpath = "//div[@class=\"alert alert-success center\"]") private WebElement mensagemEnvio;
    @FindBy(xpath = "//p[text()=\"Operação realizada com sucesso.\"]") private WebElement mensagemRepresentacaoUsuario;
    @FindBy(xpath = "//a[text()=\"Clique aqui para prosseguir\"]") private WebElement comandoProsseguir;
    @FindBy(xpath = "//input[@value=\"Representar Usuário\"]")private WebElement comandoRepresentarUsuario;

    public UsuarioPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void acionarComandoConvidarUsuario()  {
        Comando.clicar(comandoConvidarUsuario);
    }

    public void preencherCampoNomeUsuario(String texto){
        CampoTexto.preencher(campoNomeDeUsuario, texto);
    }

    public void preencherCampoNomeVerdadeiro(String texto){
        CampoTexto.preencher(campoNomeVerdadeiro, texto);
    }

    public void preencherCampoEmail(String texto){
        CampoTexto.preencher(campoEmail, texto);
    }

    public void acionarComandoAdicionarUsuario(){
        Comando.clicar(comandoAdicionarUsuario);
    }
    public void selecionarNivelAcesso(String texto){
        Combo.selecionarCombo(campoNivelAcesso, texto);
    }

    public void selecionarProjetoAUsuario(){
        Comando.clicar(projetoCombo);
    }

    public void acionarComandoRemover(){
        Comando.clicar(comandoRemover);
    }

    public void acionarComandoCriarUsuario(){
        Comando.clicar(comandoCriarUsuario);
    }
    public void acionarMenuGerenciarUsuario(){
        Tempo.aguardar(30, menuGerenciarUsuario);
        Comando.clicar(menuGerenciarUsuario);
    }

    public Boolean verificarUsuarioCriadoEmGrid(){
        return Label.textoPresente(verificoUsuarioCriadoEmGrid);
    }

    public Boolean verificarUsuarioCriadoEmGridAlterado(){
        return Label.textoPresente(nomeUsuarioEmGridAlterado);
    }

    public void acionarMenuGerenciar(){
        Comando.clicar(menuGerenciar);
    }

    public void preencherFiltroUsuario(String texto){
        CampoTexto.preencher(campoFiltroUsuario, texto);
    }

    public void acionarComandoPesquisa(){
        Comando.clicar(comandoFiltroPesquisa);
    }

    public void acionarNomeDeUsuarioEmGrid(){
        Comando.clicar(nomeUsuarioEmGrid);
    }

    public void euAcionoNomeDeUsuarioEmGridAlterado(){
        Comando.clicar(nomeUsuarioEmGridAlterado);
    }

    public void acionarComandoApagarUsuario(){
        Comando.clicar(comandoApagarUsuario);
    }


    public void acionarComandoApagarConta(){
        Comando.clicar(comandoApagarConta);
    }

    public Boolean verificarQueNomeUsuarioNaoEstaEmGrid(){

        try {
            Label.textoPresente(nomeUsuarioEmGrid);
            nomeUsuarioEmGrid.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void preencherAlteracaoNomeUsuario(String texto){
        CampoTexto.preencher(campoNomeDeUsuarioEditar, texto);
    }

    public void preencherAlteracaoNomeVerdadeiro(String texto){
        CampoTexto.preencher(campoNomeVerdadeiroEditar, texto);
    }

    public void limparCamposDeDadosUsuarios(){
        CampoTexto.limpar(campoNomeDeUsuarioEditar);
        CampoTexto.limpar(campoNomeVerdadeiroEditar);
    }

    public void acionarComandoAtualizarUsuario() throws Exception {
        Comando.clicar(comandoAtualizarUsuario);
        DriverFactory.getDriver().navigate().refresh();
    }

    public void excluirTodosUsuarios() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarUsuario);

        if(Label.textoPresente(nomeUsuarioEmGrid)){
            ApagarUsuarioTest excluiUsuarios = new ApagarUsuarioTest();
            excluiUsuarios.excluirUsuario();
        }else if(Label.textoPresente(nomeUsuarioEmGridAlterado)){
            euAcionoNomeDeUsuarioEmGridAlterado();
            acionarComandoApagarUsuario();
            acionarComandoApagarConta();
        }

    }


    public void verificarSeExisteUsuarioCriado() throws Exception {
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

    public boolean verificarUsuarioAdicionadoEmProjeto() {
        return Label.textoPresente(comandoRemover);
    }

    public void acionarSelectParaUsuarioDesabilitado() {
        Tempo.aguardar(2, campoSelectHabilitado);
        Comando.clicar(campoSelectHabilitado);
    }

    public boolean verificarUsuarioAtivoEmGrid() {
        return Label.textoPresente(validacaoUsuarioAtivo);
    }

    public boolean verificarUsuarioNaoAtivoEmGrid() {
        return Label.textoPresente(validacaoUsuarioNaoAtivo);
    }

    public void acionarSelectPesquisaUsuarioDesabilitado() {
        Comando.clicar(selectPesquisaUsuarioDesabilitado);
    }

    public void acionarComandoRedefinirSenha() {
        Comando.clicar(comandoRedefinirSenha);
    }

    public boolean verificarMensagemValidacaoEnvioEmail() {
        Tempo.aguardar(10, mensagemEnvio);
        try {
            Label.textoPresente(mensagemEnvio);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean verificarMensagemRepresentacaoRealizada() {
        Tempo.aguardar(10, mensagemRepresentacaoUsuario);
        try {
            Label.textoPresente(mensagemRepresentacaoUsuario);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public void acionarComandoRepresentarUsuario(){
        Comando.clicar(comandoRepresentarUsuario);
    }

    public void acionarComandoProsseguir(){
        Comando.clicar(comandoProsseguir);
    }
}
