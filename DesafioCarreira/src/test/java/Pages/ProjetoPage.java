package Pages;

import Core.PropriedadesProjeto;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import TestProjeto.CriarProjetoTest;
import TestProjeto.ExcluirProjetoTest;
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

    public static ExtentTest test2=null;

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

    public Boolean verificarProjetoEmGrid() throws IOException {
        test2 = extent.createTest( "Alterar Projeto" );

        Tempo.aguardar(5, projetoEmGrid);
        try {
            Label.textoPresente(projetoEmGrid);
            projetoEmGrid.getSize();
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Projeto.png");
            extent.flush();
            return true;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Projeto.png");
            extent.flush();
            return false;
        }

    }

    public Boolean verificarCriarProjetoEmGrid() throws IOException {
        test2 = extent.createTest( "Criar Projeto" );

        Tempo.aguardar(5, projetoEmGrid);
        try {
            Label.textoPresente(projetoEmGrid);
            projetoEmGrid.getSize();
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Projeto.png");
            extent.flush();
            return true;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Projeto.png");
            extent.flush();
            return false;
        }

    }

    public Boolean verificarProjetoNaoEstaEmGrid() throws IOException {
        test2 = extent.createTest( "Excluir Projeto" );

        try {
            Label.textoPresente(projetoEmGrid);
            projetoEmGrid.getSize();
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Excluir Projeto.png");
            extent.flush();
            return false;

        }catch (Exception e){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Excluir Projeto.png");
            extent.flush();
            return true;
        }

    }

    public Boolean verificarProjetoPrivadoEmGrid() throws IOException {

        test2 = extent.createTest( "Visibilidade Projeto Privado" );

        if (Label.textoPresente(projetoPublicoEmGrid) && Label.textoPresente(projetoPrivado)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Visibilidade Projeto Privado.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Visibilidade Projeto Privado.png");
            extent.flush();
            return false;
        }

    }

    public Boolean verificarProjetoPublicoEmGrid() throws IOException {

        test2 = extent.createTest( "Visibilidade Projeto Publico" );

        if (Label.textoPresente(projetoPrivadoEmGrid) && Label.textoPresente(projetoPublico)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Visibilidade Projeto Publico.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Visibilidade Projeto Publico.png");
            extent.flush();
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

    public void registrarAlterarProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Projeto.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarVisibilidadeProjetoPrivado() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Visibilidade Projeto Privado.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarVisibilidadeProjetoPublico() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Visibilidade Projeto Publico.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarExcluirProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Excluir Projeto.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarCriarProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Criar Projeto.png" );//+ Generetor.dataHora()+".png");
    }
}
