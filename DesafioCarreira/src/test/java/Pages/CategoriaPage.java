package Pages;

import Core.PropriedadesCategoria;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestCategoria.ApagarCategoriaTest;
import TestCategoria.CadastrarCategoriaTest;
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

public class CategoriaPage {


    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(name = "name") private WebElement campoNomeCategoria;
    @FindBy(linkText = "Gerenciar Projetos") private WebElement menuGerenciarProjetos;
    @FindBy(xpath = "//input[@value=\"Adicionar Categoria\"]") private WebElement comandoAdicionarCategoria;
    @FindBy(xpath = "//td[contains(text(),'"+ PropriedadesCategoria.categoria+"')]") private WebElement categoriaTesteEmGrid;
    @FindBy(xpath = "//td[contains(text(),'"+ PropriedadesCategoria.categoriaAlterada+"')]") private WebElement categoriaAlteradaTesteEmGrid;
    @FindBy(xpath = "//tr[4]//td[3]//div[1]//div[1]//form[1]//fieldset[1]//button[1]") private WebElement comandoAlterarCategoria;
    @FindBy(xpath = "//tr[4]//td[3]//div[1]//div[2]//form[1]//fieldset[1]//button[1]") private WebElement comandoApagarCategoria;
    @FindBy(xpath = "//input[@value=\"Apagar Categoria\"]") private WebElement confirmarExclusao;
    @FindBy(xpath = "//input[@value=\"Atualizar Categoria\"]") private WebElement comandoAtualizarCategoria;

    public static ExtentTest test2=null;

    public CategoriaPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void acionarMenuGerenciar()  {
        Tempo.aguardar(2, menuGerenciar);
        Comando.clicar(menuGerenciar);
    }


    public void acionarMenuGerenciarProjetos(){
        Tempo.aguardar(2,menuGerenciarProjetos );
        Comando.clicar(menuGerenciarProjetos);
    }

    public void preencherCampoNomeCategoria(String texto){
        Tempo.aguardar(2, campoNomeCategoria);
        CampoTexto.limpar(campoNomeCategoria);
        CampoTexto.preencher(campoNomeCategoria, texto);
    }

    public void acionarComandoAdicionarCategoria(){
        Comando.clicar(comandoAdicionarCategoria);
    }

    public Boolean verificarCategoriaEmGrid() throws IOException, InterruptedException {
        //Tempo.aguardar(5, menuGerenciarProjetos);
        Thread.sleep( 2000 );
        test2 = extent.createTest( "Alterar Categoria" );
        if(Label.textoPresente(categoriaTesteEmGrid) || Label.textoPresente(categoriaAlteradaTesteEmGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Categoria.png");
            extent.flush();

            return true;
        }else {
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Categoria.png");
            extent.flush();
            return false;
        }
    }

    public Boolean verificarCategoriaCadastradaEmGrid() throws IOException {
        Tempo.aguardar(5, menuGerenciarProjetos);
        test2 = extent.createTest( "Cadastrar Categoria" );
        if(Label.textoPresente(categoriaTesteEmGrid) || Label.textoPresente(categoriaAlteradaTesteEmGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Cadastrar Categoria.png");
            extent.flush();

            return true;
        }else {
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Cadastrar Categoria.png");
            extent.flush();
            return false;
        }
    }

    public Boolean verificarCategoriaApagadaEmGrid() throws IOException {
        Tempo.aguardar(5, menuGerenciarProjetos);
        test2 = extent.createTest( "Apagar Categoria" );
        if(Label.textoPresente(categoriaTesteEmGrid) || Label.textoPresente(categoriaAlteradaTesteEmGrid)){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Apagar Categoria.png");
            extent.flush();

            return true;
        }else {
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Apagar Categoria.png");
            extent.flush();

            return false;
        }
    }

    public void verificarSeExisteCategoriaCriada() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);

        if(Label.textoPresente(categoriaTesteEmGrid)|| Label.textoPresente(categoriaAlteradaTesteEmGrid)){
            ApagarCategoriaTest apagarCategoria = new ApagarCategoriaTest();
            apagarCategoria.apagarCategoria();
        }else{

        }
    }
    public void verificarSeExisteCategoriaAExcluir() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);

        if(Label.textoPresente(categoriaTesteEmGrid)|| Label.textoPresente(categoriaAlteradaTesteEmGrid)){

        }else{
            CadastrarCategoriaTest cadastrarCategoria = new CadastrarCategoriaTest();
            cadastrarCategoria.cadastraCategoria();
        }
    }
    public void verificarSeExisteCategoriaAAlterar() throws Exception {

        ApagarCategoriaTest apagarCategoria = new ApagarCategoriaTest();
        CadastrarCategoriaTest cadastrarCategoria = new CadastrarCategoriaTest();

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);

        if(Label.textoPresente(categoriaTesteEmGrid)){

        }else if(Label.textoPresente(categoriaAlteradaTesteEmGrid)){

            apagarCategoria.apagarCategoria();
            cadastrarCategoria.cadastraCategoria();
        }else if(Label.textoNaoPresente(categoriaAlteradaTesteEmGrid)||Label.textoNaoPresente(categoriaTesteEmGrid)){
            cadastrarCategoria.cadastraCategoria();
        }
    }

    public void acionarAlterarCategoria() {
        Tempo.aguardar(2, comandoAlterarCategoria);
        Comando.clicar(comandoAlterarCategoria);
    }

    public void acionarExcluirCategoria() {
        Tempo.aguardar(2, comandoApagarCategoria);
        Comando.clicar(comandoApagarCategoria);
    }

    public void confirmarExcluirCategoria(){
        Tempo.aguardar(2, confirmarExclusao);
        Comando.clicar(confirmarExclusao);
    }

    public void acionarComandoAtualizarCategoria() {
        Tempo.aguardar(4, comandoAtualizarCategoria);
        Comando.clicar(comandoAtualizarCategoria);
    }

    public void registrarAlterarCategoria() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Categoria.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarCadastrarCategoria() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Cadastrar Categoria.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarApagarCategoria() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Apagar Categoria.png" );//+ Generetor.dataHora()+".png");
    }
}
