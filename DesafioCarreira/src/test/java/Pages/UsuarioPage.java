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
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.extent;

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

    public static ExtentTest test2=null;

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

    public Boolean verificarUsuarioPesquisadoEmGrid() throws IOException {
        test2 = extent.createTest( "Pesquisar Usuario Em Projeto" );

        if(Label.textoPresente(verificoUsuarioCriadoEmGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Pesquisar Usuario Em Projeto.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Pesquisar Usuario Em Projeto.png");
            extent.flush();
            return false;
        }

    }

    public Boolean verificarUsuarioCriadoEmGrid() throws IOException {
        test2 = extent.createTest( "Criar Usuario Em Projeto" );

        if(Label.textoPresente(verificoUsuarioCriadoEmGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Usuario Em Projeto.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Usuario Em Projeto.png");
            extent.flush();
            return false;
        }

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

    public Boolean verificarQueNomeUsuarioNaoEstaEmGrid() throws IOException {

        test2 = extent.createTest( "Alterar Usuario Em Projeto" );

            if(Label.textoPresente(nomeUsuarioEmGrid)){
                test2.log( Status.PASS, "Teste realizado com sucesso");
                test2.addScreenCaptureFromPath(
                        System.getProperty("user.dir") + File.separator +
                                "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Usuario Em Projeto.png");
                extent.flush();
                return true;
        }else{

                nomeUsuarioEmGrid.getSize();
                test2.log(Status.FAIL, "Ocorreu uma falha no teste");
                test2.addScreenCaptureFromPath(
                        System.getProperty("user.dir") + File.separator +
                                "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Usuario Em Projeto.png");
                extent.flush();
                return false;

        }

    }

    public Boolean verificarNomeUsuarioApagadoEmGrid() throws IOException {

        test2 = extent.createTest( "Apagar Usuario Em Projeto" );

        if(Label.textoPresente(nomeUsuarioEmGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Apagar Usuario Em Projeto.png");
            extent.flush();
            return true;
        }else{

            nomeUsuarioEmGrid.getSize();
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Apagar Usuario Em Projeto.png");
            extent.flush();
            return false;

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
        Tempo.aguardar( 5, menuGerenciarUsuario );
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

    public boolean verificarUsuarioRemovidoEmProjeto() throws IOException {
        test2 = extent.createTest( "Remover Usuario Em Projeto" );

        if(Label.textoPresente(comandoRemover)){

            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Remover Usuario Em Projeto.png");
            extent.flush();
            return true;
        }else {
            test2.log( Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Remover Usuario Em Projeto.png");
            extent.flush();

            return false;
        }
    }

    public boolean verificarUsuarioAdicionadoEmProjeto() throws IOException {
        test2 = extent.createTest( "Adicionar Usuario Em Projeto" );
        //return Label.textoPresente(comandoRemover);
        if(Label.textoPresente(comandoRemover)){

            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Usuario Em Projeto.png");
            extent.flush();
            return true;
        }else {
            test2.log( Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Usuario Em Projeto.png");
            extent.flush();

            return false;
        }
    }

    public void acionarSelectParaUsuarioDesabilitado() {
        Tempo.aguardar(2, campoSelectHabilitado);
        Comando.clicar(campoSelectHabilitado);
    }

    public boolean verificarUsuarioAtivoEmGrid() throws IOException {
        test2 = extent.createTest( "Usuario Ativo Em Projeto" );
        if (Label.textoPresente(validacaoUsuarioAtivo)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Usuario Ativo Em Projeto.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Usuario Ativo Em Projeto.png");
            extent.flush();
            return false;
        }
    }

    public boolean verificarUsuarioNaoAtivoEmGrid() throws IOException {
        test2 = extent.createTest( "Usuario Não Ativo Em Projeto" );

        if (Label.textoPresente(validacaoUsuarioNaoAtivo)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Usuario Não Ativo Em Projeto.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Usuario Não Ativo Em Projeto.png");
            extent.flush();
            return false;
        }
    }

    public void acionarSelectPesquisaUsuarioDesabilitado() {
        Comando.clicar(selectPesquisaUsuarioDesabilitado);
    }

    public void acionarComandoRedefinirSenha() {
        Comando.clicar(comandoRedefinirSenha);
    }

    public boolean verificarMensagemValidacaoEnvioEmail() throws IOException {
        Tempo.aguardar(10, mensagemEnvio);
        test2 = extent.createTest( "Validação Envio Email" );
        if(Label.textoPresente(mensagemEnvio)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Validação Envio Email.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Validação Envio Email.png");
            extent.flush();
            return false;
        }
    }

    public boolean verificarMensagemRepresentacaoRealizada() throws IOException {
        Tempo.aguardar(10, mensagemRepresentacaoUsuario);
        test2 = extent.createTest( "Representar Usuario" );

        if(Label.textoPresente(mensagemRepresentacaoUsuario)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Representar Usuario.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Representar Usuario.png");
            extent.flush();
            return false;
        }

    }


    public void acionarComandoRepresentarUsuario(){
        Comando.clicar(comandoRepresentarUsuario);
    }

    public void acionarComandoProsseguir(){
        Comando.clicar(comandoProsseguir);
    }

    public void registrarAdicionarUsuarioEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Adicionar Usuario Em Projeto.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarAlterarUsuarioEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Usuario Em Projeto.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarApagarUsuarioEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Apagar Usuario Em Projeto.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarCriarUsuarioEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Criar Usuario Em Projeto.png" );//+ Generetor.dataHora()+".png");
    }
}
