package Pages;

import Core.PropriedadesCampoPersonalizado;
import Core.PropriedadesProjeto;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestCampoPersonalizado.AdicionarCampoPersonalizadoEmProjetoTest;
import TestCampoPersonalizado.CriarCampoPersonalizadoTest;
import TestCampoPersonalizado.ExcluirCampoPersonalizadoTest;
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

    public CampoPersonalizadoPage() throws Exception {
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
        Tempo.aguardar(3, menuCampoPersonalizados);
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

    public void acionarCampoPersonalizadoEmGrid() throws InterruptedException {

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

    public Boolean verificarCampoPersonalizadoEmGrid() throws IOException {
        Tempo.aguardar(15, campoPersonalizadoEmGrid);
        ExtentTest test4;
        test4 = extent.createTest( "Criar Campo Personalizado Alterado" );
        try {
            Label.textoPresente(campoPersonalizadoEmGrid);
            campoPersonalizadoEmGrid.getSize();
            test4.log(Status.PASS, "Teste realizado com sucesso");
            test4.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioCampoPersonalizado"+ File.separator +"Criar Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
            extent.flush();
            return true;
        } catch (Exception e) {
            test4.log(Status.FAIL, "Ocorreu uma falha no teste");
            test4.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioCampoPersonalizado"+ File.separator +"Criar Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");

            extent.flush();
            return false;
        }
    }

    public Boolean verificarCampoPersonalizadoAlteradoEmGrid() throws IOException {

        ExtentTest test3;
        test3 = extent.createTest( "Alterar Campo Personalizado Em Projeto" );
        try {

            Label.textoPresente(campoPersonalizadoAlteradoEmGrid);
            campoPersonalizadoAlteradoEmGrid.getSize();
            test3.log(Status.PASS, "Teste realizado com sucesso");
            test3.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioCampoPersonalizado"+ File.separator +"Alterar Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
            extent.flush();
            return true;
        } catch (Exception e) {
            test3.log(Status.FAIL, "Ocorreu uma falha no teste");
            test3.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioCampoPersonalizado"+ File.separator +"Alterar Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");

            extent.flush();
            return false;
        }
    }

    public Boolean verificarCampoPersonalizadoExcluidoEmGrid() {
        ExtentTest test5;
        test5 = extent.createTest( "Verificar Campo Personalizado excluído" );
        try {

            if (Label.textoNaoPresente(campoPersonalizadoEmGrid)){
                campoPersonalizadoEmGrid.getSize();
                test5.log(Status.PASS, "Teste excluir campo personalizado com sucesso");
                test5.addScreenCaptureFromPath(
                        System.getProperty("user.dir") + File.separator +
                                "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioCampoPersonalizado"+ File.separator +"Excluir Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
                extent.flush();
            }else if(Label.textoNaoPresente(campoPersonalizadoAlteradoEmGrid)){
                campoPersonalizadoAlteradoEmGrid.getSize();
                test5.log(Status.PASS, "Teste excluir campo personalizado com sucesso");
                test5.addScreenCaptureFromPath(
                        System.getProperty("user.dir") + File.separator +
                                "src" + File.separator + "test" + File.separator + "java" +File.separator +"ArquivoCenarioCampoPersonalizado"+ File.separator +"Excluir Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
                extent.flush();
            }
            return false;
        } catch (Exception e) {
            test5.log(Status.FAIL, "Ocorreu uma falha no teste");
            extent.flush();
            return true;
        }
    }

    public void verificarSeExisteCampoPersonalidadoAExcluir() throws Exception {

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuCampoPersonalizados);
        ExcluirCampoPersonalizadoTest excluiCampoPersonalidado = new ExcluirCampoPersonalizadoTest();

        if(Label.textoPresente(campoPersonalizadoEmGrid)){
            excluiCampoPersonalidado.excluirCampoPersonalizado();
        }else {

        }
    }

    public void verificarSeExisteCampoPersonalidado() throws Exception {

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


    public Boolean verificarCampoVinculadoEmGrid() throws IOException {
        ExtentTest test1;
        test1 = extent.createTest( "Adicionar Campo Personalizado Em Projeto" );
        try {
            Label.textoPresente(comandoRemover);
            comandoRemover.getSize();
            test1.log( Status.PASS, "Teste realizado com sucesso");
            test1.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioCampoPersonalizado" + File.separator +"Add Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
            extent.flush();
            return true;
        } catch (Exception e) {
            test1.log(Status.FAIL, "Ocorreu uma falha no teste");
            test1.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioCampoPersonalizado" + File.separator +"Add Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");

            extent.flush();
            return false;
        }
    }

    public Boolean verificarRemocaoCampoVinculadoEmGrid() throws IOException {
        ExtentTest test6;
        test6 = extent.createTest( "Remover Campo Personalizado Em Projeto" );
        try {
            Label.textoPresente(comandoRemover);
            comandoRemover.getSize();
            test6.log(Status.FAIL, "Ocorreu uma falha no teste");
            test6.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioCampoPersonalizado" + File.separator +"Remover Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");

            extent.flush();
            return false;
        } catch (Exception e) {

            test6.log( Status.PASS, "Teste realizado com sucesso");

            test6.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" +  File.separator + "java" +File.separator + "ArquivoCenarioCampoPersonalizado" + File.separator +"Remover Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
            extent.flush();
            return true;
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

    public void verificarSeExisteCampoPersonalizadoAdicionado() throws Exception {

        AdicionarCampoPersonalizadoEmProjetoTest adicionar = new AdicionarCampoPersonalizadoEmProjetoTest();
        Comando.clicar(campoPersonalizadoEmGrid);

        if(Label.textoPresente(comandoRemover)){

        }else {
            adicionar.adicionaCampoPersonalizadoEmProjeto();
        }
    }

    public void excluirTodosCamposPersonalizados() throws Exception {

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

    public void registrarAddCampoPersonalizadoEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Add Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
    }

    public void registrarAlterarCampoPersonalizadoEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
    }

    public void registrarCriarCampoPersonalizadoEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
    }

    public void registrarExcluirCampoPersonalizadoEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Excluir Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
    }

    public void registrarRemoverCampoPersonalizadoEmProjeto() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Remover Campo Personalizado Em Projeto.png");//+ Generetor.dataHora()+".png");
    }
}
