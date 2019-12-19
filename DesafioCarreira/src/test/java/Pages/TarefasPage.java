package Pages;

import Core.PropriedadesMarcador;
import Core.PropriedadesTarefas;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import TestTarefas.*;
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.extent;

public class TarefasPage {

    @FindBy(xpath = "//span[text()=\" Ver Tarefas \"]") private WebElement menuVerTarefas;
    @FindBy(xpath = "//span[text()=\" Criar Tarefa \"]") private WebElement menuCriarTarefas;
    @FindBy(id = "category_id")private WebElement categoriaBug;
    @FindBy(xpath = "//input[@value=\"Fechar\"]")private WebElement comandoFecharTarefa;
    @FindBy(xpath = "//input[@value=\"Fechar Tarefa\"]")private WebElement comandoDeConfirmaFecharTarefa;
    @FindBy(xpath = "//input[@value=\"OK\"]")private WebElement comandoOk;
    @FindBy(id = "bug_arr_all")private WebElement selectExclusao;
    @FindBy(id = "reproducibility")private WebElement frequenciaBug;
    @FindBy(id = "severity")private WebElement gravidadeBug;
    @FindBy(id = "priority")private WebElement prioridadeBug;
    @FindBy(id = "handler_id")private WebElement atribuicaoBug;
    @FindBy(id = "summary")private WebElement resumoBug;
    @FindBy(id = "description")private WebElement descriçãoBug;
    @FindBy(id = "steps_to_reproduce")private WebElement reproduzirBug;
    @FindBy(xpath = "//input[@value=\"Criar Nova Tarefa\"]")private WebElement comandoCriarNovaTarefa;
    @FindBy(xpath= "//td[@class=\"bug-id\"]")public WebElement confirmoCadastroTarefaRealizada;
    @FindBy(xpath= "//td[@class=\"bug-status\"]")public WebElement confirmoStatusFechado;
    @FindBy(xpath= "//input[@name=\"bug_id\"][@placeholder]")private WebElement campoPesquisaTarefa;
    @FindBy(className = "lbl")private WebElement selecionarTarefaParaAcao;
    @FindBy(xpath = "//input[@value=\"Apagar\"]") private WebElement comandoApagar;
    @FindBy(xpath = "//input[@value=\"Apagar Tarefas\"]") private WebElement comandoConfirmacaoApagar;
    @FindBy(xpath = "//div[@class='widget-main no-padding']//div[@class='widget-toolbox padding-8 clearfix']") private WebElement gridVazio;
    @FindBy(xpath = "//input[@value=\"Atualizar\"]") private WebElement comandoAtualizar;
    @FindBy(xpath = "//input[@value=\"Atualizar Informação\"]") private WebElement comandoAtualizacaoTarefaRealizada;
    @FindBy(xpath = "//td[@class=\"bug-category\"]")private WebElement informacaoCategoria;
    @FindBy(id = "bugnote_text")private WebElement campoAdicionarInformacaoTarefa;
    @FindBy(xpath = "//span[@class=\"lbl\"]")private WebElement atividadeGrid;
    @FindBy(name = "action") private WebElement comboApagar;
    @FindBy(xpath= "//input[@value=\"Criar Clone\"]")private WebElement comandoCriarCloneTarefa;
    @FindBy(xpath = "//td[@class='column-id']")private WebElement cliqueTarefaEmGrid;
    @FindBy(xpath = "//input[@value=\"Marcar como Pegajoso\"]")private WebElement comandoMarcarComoPegajosa;
    @FindBy(xpath = "//input[@value=\"Desmarcar como Pegajoso\"]")private WebElement comandoDesmarcarComoPegajosa;
    @FindBy(linkText = "Imprimir Tarefas")private WebElement comandoImprimirTarefa;
    @FindBy(xpath = "//td[@class='column-edit']")private WebElement iconeEditar;
    @FindBy(xpath = "//td[@class=\"bug-severity\"][text()=\""+ PropriedadesTarefas.gravidadeBugObstaculo+"\"]") private WebElement alteracaoStatusGravidade;
    @FindBy(name = "tag_select")private WebElement comboMarcador;
    @FindBy(xpath = "//input[@value=\"Aplicar\"]") private WebElement comandoAplicar;
    @FindBy(xpath = "//a[@class=\"btn btn-xs btn-primary btn-white btn-round\"][text()=\""+ PropriedadesMarcador.nomeMacador+"\"]") private WebElement macardorEmTarefa;
    @FindBy(xpath = "//a[@title=\"Remover 'Marcador em teste'\"]") private WebElement iconeExlusao;
    @FindBy(linkText = "Relator") private WebElement filtroRelator;
    @FindBy(id = "reporter_id_filter_target") private WebElement validarRedefinir;
    @FindBy(xpath= "//select[@class=\"input-xs\"]")private WebElement comboAdministrador;
    @FindBy(xpath= "//input[@value=\"Aplicar Filtro\"]")private WebElement comandoAplicarFiltro;
    @FindBy(linkText = "Redefinir") private WebElement comandoRedefinir;
    @FindBy(xpath = "//input[@value=\"Mover\"]")private WebElement comandoMover;
    @FindBy(xpath = "//input[@value=\"Mover Tarefas\"]")private WebElement comandoMoverTarefas;
    @FindBy(name = "project_id")private WebElement comboMoverProjeto;
    @FindBy(xpath = "//input[@value=\"Monitorar\"]")private WebElement comandoMonitorar;
    @FindBy(xpath = "//input[@value=\"Parar de Monitorar\"]")private WebElement comandoPararDeMonitorar;
    @FindBy(xpath = "//a[text()=\"Marcador em teste\"]") private WebElement marcadorPersente;
    @FindBy(xpath = "//div[@class='widget-main no-padding']//a[2]") private  WebElement iconeMarcadorPresente;

    public static ExtentTest test2=null;

    public TarefasPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }


    public void acionarMenuVerTarefas(){
        Comando.clicar(menuVerTarefas);
    }

    public void acessarMenuCriarTarefas(){

        Comando.clicar(menuCriarTarefas);
    }

    public void acionarComandoAplicar(){
        Comando.clicar(comandoAplicar);
    }

    public void selecionarMarcador(String texto){

        Combo.selecionarCombo(comboMarcador, texto);
    }

    public Boolean verificarAlteracaoStatusEmAtividade() throws IOException {
        test2 = extent.createTest( "Alterar Status Em Tarefas" );

        if(Label.textoPresente(alteracaoStatusGravidade)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Status Tarefas.png");
            extent.flush();
            return true;
        }
        else {
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Status Tarefas.png");
            extent.flush();
            return false;
        }
    }

    public Boolean verificarMarcadorEmTarefa() throws IOException {

        test2 = extent.createTest( "Adicionar Marcador Em Tarefas" );

            if(Label.textoPresente(macardorEmTarefa)){
                test2.log( Status.PASS, "Teste realizado com sucesso");
                test2.addScreenCaptureFromPath(
                        System.getProperty("user.dir") + File.separator +
                                "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Marcador Tarefa.png");
                extent.flush();
                return true;
            }else {
                test2.log(Status.FAIL, "Ocorreu uma falha no teste");
                test2.addScreenCaptureFromPath(
                        System.getProperty("user.dir") + File.separator +
                                "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Marcador Tarefa.png");
                extent.flush();
                return false;
            }
    }

    public Boolean verificarApagarMarcadorEmTarefa() throws IOException {
        test2 = extent.createTest( "Apagar Marcador Em Tarefas" );

        if(Label.textoPresente(macardorEmTarefa)){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Marcador Tarefa.png");
            extent.flush();
            return true;
        }else {
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Marcador Tarefa.png");
            extent.flush();
            return false;
        }
    }

    public void acionarIconeEditar(){
        Comando.clicar(iconeEditar);
    }
    public void selecionarGravidadeObstaculoBug(String texto){
        Combo.selecionarCombo(gravidadeBug,texto );
    }
    public void acionarComandoCriarTarefa(){
        Comando.clicar(comandoCriarNovaTarefa);
    }


    public void acionarCategoriaTarefa(String tipo) throws InterruptedException {
        Tempo.aguardar(15, categoriaBug);
        Combo.selecionarCombo(categoriaBug, tipo);
    }


    public void acionarComandoFecharTarefa(){
        Comando.clicar(comandoFecharTarefa);
    }

    public void confirmarFechamentoComandoFecharTarefa(){
        Comando.clicar(comandoDeConfirmaFecharTarefa);
    }

    public void acessarFrequenciaTarefa(String tipo){
        Combo.selecionarCombo(frequenciaBug, tipo);
    }

    public void acessarGravidadeTarefa(String tipo){
        Combo.selecionarCombo(gravidadeBug, tipo);
    }

    public void acessarPrioridadeTarefa(String tipo){
        Combo.selecionarCombo(prioridadeBug, tipo);
    }

    public void acessarAtribuicaoTarefa(String tipo){
        Combo.selecionarCombo(atribuicaoBug, tipo);
    }

    public void informarResumoTarefa(String tipo){
        CampoTexto.preencher(resumoBug, tipo);
    }

    public void informarDescricaoBug(String tipo){
        CampoTexto.preencher(descriçãoBug, tipo);
    }

    public void informarReproducaoBug(String tipo){
        CampoTexto.preencher(reproduzirBug, tipo);
    }

    public Boolean confirmarCadastroComSucesso() throws IOException {
        //Tempo.aguardar(15, confirmoCadastroTarefaRealizada);

        test2 = extent.createTest( "Clonar Tarefas" );

        if (Label.textoPresente(confirmoCadastroTarefaRealizada)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Clonar Tarefa.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Clonar Tarefa.png");
            extent.flush();
            return false;
        }
    }

    public Boolean confirmarCriarTarefaComSucesso() throws IOException {
        //Tempo.aguardar(15, confirmoCadastroTarefaRealizada);

        test2 = extent.createTest( "Criar Tarefas" );

        if (Label.textoPresente(confirmoCadastroTarefaRealizada)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Tarefa.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Criar Tarefa.png");
            extent.flush();
            return false;
        }
    }

    public String verificarIdTarefaCriada(){
        Tempo.aguardar(15, confirmoCadastroTarefaRealizada);
        return Label.recuperaTexto(confirmoCadastroTarefaRealizada);
    }

    public Boolean verificarStatusFechado() throws IOException {
        //Tempo.aguardar(20, confirmoStatusFechado);
        test2 = extent.createTest( "Fechar Tarefas" );

        if (Label.textoPresente(confirmoStatusFechado)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Fechar Tarefa.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Fechar Tarefa.png");
            extent.flush();
            return false;
        }
    }

    public Boolean verificarPesquisaIdTarefaCriada() throws IOException {
       // Tempo.aguardar(20, confirmoCadastroTarefaRealizada);
        test2 = extent.createTest( "Pesquisar Tarefas" );
        if(Label.textoPresente(confirmoCadastroTarefaRealizada)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Pesquisar Tarefa.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Pesquisar Tarefa.png");
            extent.flush();
            return false;
        }
    }


    public void acionarIconeExluirMarcador(){
        Comando.clicar(iconeExlusao);
    }

    public void euPesquisoTarefa(String pesquisa){
        Tempo.aguardar(5,campoPesquisaTarefa);
        CampoTexto.preencher(campoPesquisaTarefa,pesquisa);
        campoPesquisaTarefa.sendKeys(Keys.ENTER);

    }

    public void acionarComandoApagarTarefas(){
        Comando.clicar(comandoApagar);
        Comando.clicar(comandoConfirmacaoApagar);
    }

    public void acionarComandoMarcarTarefasPegajosa(){
        Comando.clicar(comandoMarcarComoPegajosa);
    }
    public void acionarComandoDesmarcarTarefasPegajosa(){
        Comando.clicar(comandoDesmarcarComoPegajosa);
    }

    public Boolean verificarGridVazio() throws IOException {
        test2 = extent.createTest( "Apagar Tarefas" );
        try {
            Label.textoPresente(selecionarTarefaParaAcao);
            selecionarTarefaParaAcao.getSize();
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Apagar Tarefas.png");
            extent.flush();
            return false;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Apagar Tarefas.png");
            extent.flush();
            return true;
        }

    }

    public Boolean verificarTarefaMarcarda() throws IOException {
        test2 = extent.createTest( "Marcar Tarefa Pegajosa" );

        try {
            Label.textoPresente(comandoDesmarcarComoPegajosa);
            comandoDesmarcarComoPegajosa.getSize();
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Marcar Tarefa Pegajosa.png");
            extent.flush();
            return true;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Marcar Tarefa Pegajosa.png");
            extent.flush();
            return false;
        }

    }
    public Boolean verificarTarefaDesmarcarda() throws IOException {

        test2 = extent.createTest( "Desmarcar Tarefa Pegajosa" );
        try {
            Label.textoPresente(comandoMarcarComoPegajosa);
            comandoMarcarComoPegajosa.getSize();
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Desmarcar Tarefa Pegajosa.png");
            extent.flush();
            return true;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Desmarcar Tarefa Pegajosa.png");
            extent.flush();
            return false;
        }

    }

    public void acionarComandoAplicaFiltro(){
        Tempo.aguardar(3, comandoAplicarFiltro);
        Comando.clicar(comandoAplicarFiltro);
    }
    public boolean verificarAlteracaoCategoria() throws IOException {
        test2 = extent.createTest( "Alterar Categoria Em Tarefas" );

        if (Label.textoPresente(informacaoCategoria )){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Categoria Tarefas.png");
            extent.flush();
            return true;
        }else{
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Alterar Categoria Tarefas.png");
            extent.flush();
            return false;
        }
    }

    public void acionarComandoAtualizar(){
        Comando.clicar(comandoAtualizar);
    }

    public void acionarComandoAtualizacaoInformacaoEmTarefa(){
        Comando.clicar(comandoAtualizacaoTarefaRealizada);
    }

    public void adicionarInformacaoTarefa(String texto){
        CampoTexto.preencher(campoAdicionarInformacaoTarefa, texto);
    }


    public void excluirTodasTarefas(){

        Comando.clicar(menuVerTarefas);

        if(Label.textoPresente(atividadeGrid)) {
            while (Label.textoPresente(atividadeGrid)) {
                Tempo.aguardar(5, selecionarTarefaParaAcao);
                Comando.clicar(selecionarTarefaParaAcao);
                Tempo.aguardar(2, comboApagar);
                Combo.selecionarCombo(comboApagar, "Apagar");
                Tempo.aguardar(2, comandoOk);
                Comando.clicar(comandoOk);
                Comando.clicar(comandoConfirmacaoApagar);
            }
        }
    }

    public void verificaMarcadorJaAdicionado(){

        if(Label.textoPresente(marcadorPersente)){
            Comando.clicar( iconeMarcadorPresente );
        }
    }

    public void verificarSeExisteTarefa() throws Exception {

        acionarMenuVerTarefas();
        CriarTarefasTest criaTarefa = new CriarTarefasTest();

        if(Label.textoPresente(atividadeGrid)){
            Comando.clicar(cliqueTarefaEmGrid);
        }else {
            criaTarefa.criarNovaTarefa();
        }
    }

    public void verificarSeExisteTarefaParaImprimir() throws Exception {

        acionarMenuVerTarefas();
        CriarTarefasTest criaTarefa = new CriarTarefasTest();

        if(Label.textoPresente(atividadeGrid)){

        }else {
            criaTarefa.criarNovaTarefa();
            acionarMenuVerTarefas();

        }
    }

    public void verificarSeTarefaEstaMarcada() throws Exception {

        if(Label.textoPresente(comandoDesmarcarComoPegajosa)){

        }else {
            MarcarTarefaPegajosaTest marcarTarefa = new MarcarTarefaPegajosaTest();

            marcarTarefa.marcarTarefaPegajosa();

        }
    }

    public void verificarSeTarefaEstaDesmarcada() throws Exception {

        if(Label.textoPresente(comandoMarcarComoPegajosa)){

        }else {
            DesmarcarTarefaPegajosaTest desmarcarTarefa = new DesmarcarTarefaPegajosaTest();
            desmarcarTarefa.desmarcarTarefaPegajosa();
        }
    }

    public void acionarComandoCriarCloneTarefa(){
        Comando.clicar(comandoCriarCloneTarefa);
    }

    public void acionarComandoImprimirTarefa() {
        Comando.clicar(comandoImprimirTarefa);
    }

    public Boolean tarefaEmGriImprimir() throws IOException {
        test2 = extent.createTest( "Imprimir Tarefas" );
        try{
            Label.textoPresente(confirmoCadastroTarefaRealizada);
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Imprimir Tarefa Tarefa.png");
            extent.flush();
            return true;
        } catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Imprimir Tarefa.png");
            extent.flush();
            return false;
        }
    }

    public Boolean verificarTarefaEmGrid() throws IOException {

        test2 = extent.createTest( "Adicionar Filtro Tarefa" );

        if(Label.textoPresente(atividadeGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Filtro Tarefas.png");
            extent.flush();
            return true;
        }else {
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Adicionar Filtro Tarefas.png");
            extent.flush();
            return false;}
    }

    public Boolean verificarMoverTarefa() throws IOException {

        test2 = extent.createTest( "Mover Tarefas" );

        if(Label.textoPresente(atividadeGrid)){
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Mover Tarefa.png");
            extent.flush();
            return true;
        }else {
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Mover Tarefa.png");
            extent.flush();
            return false;}
    }


    public void retornarImpressao() throws Exception {
        getDriver().navigate().to("https://localhost/mantis/view_all_bug_page.php");
        getDriver().navigate().refresh();
    }

    public void verificarSeTarefaPossuiMarcador() throws Exception {

        AdicionarMarcadorEmTarefasTest adicionarMarcador = new AdicionarMarcadorEmTarefasTest();
        MarcadorPage marcador = new MarcadorPage();
        TarefasPage tarefa = new TarefasPage();

        marcador.verificarSeExisteMarcador();
        Comando.clicar(menuVerTarefas);
        tarefa.verificarSeExisteTarefa();

        if (Label.textoPresente(iconeExlusao)){
        }else{
            adicionarMarcador.adicionarMarcadorEmAtividade();
        }

    }

    public void acionarRelatorGrid(){
        Comando.clicar(filtroRelator);
    }

    public void selecionarRelator(String texto) {
        Tempo.aguardar(4, comboAdministrador);
        Combo.selecionarCombo(comboAdministrador, texto);
    }

    public void verificarSeExisteFiltroTarefa() throws Exception {

        acionarMenuVerTarefas();
        if (Label.textoPresente(validarRedefinir)){

            AdicionarFiltroTarefasTest adicionaFiltro = new AdicionarFiltroTarefasTest();

            adicionaFiltro.adicionarFiltroAtividade();

        }else{

        }

    }

    public void acionarComandoRedefinir(){
        Comando.clicar(comandoRedefinir);
    }

    public boolean verificarRedefinicaoTarefa() throws IOException {
        test2 = extent.createTest( "Redefinir Filtro Tarefas" );
        try {
                if(Label.textoPresente(validarRedefinir)){
                    test2.log( Status.PASS, "Teste realizado com sucesso");
                    test2.addScreenCaptureFromPath(
                            System.getProperty("user.dir") + File.separator +
                                    "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Redefinir Filtro Tarefa.png");
                    extent.flush();
                return true;
            }
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Redefinir Filtro Tarefa.png");
            extent.flush();
            return false;
        }
        return verificarRedefinicaoTarefa();
    }

    public void acionarComandoMoverAtividade() {
        Comando.clicar(comandoMover);
    }

    public void acionarComandoConfirmarMoverAtividade() {
        Comando.clicar(comandoMoverTarefas);
    }

    public void selecionarTarefaParaRemover(String texto){
        Tempo.aguardar(3, comboMoverProjeto);
        Combo.selecionarCombo(comboMoverProjeto, texto);
    }

    public void acionarComandoMonitorar() {
        if(Label.textoPresente(comandoMonitorar)){
            Comando.clicar(comandoMonitorar);
        }else{
            Comando.clicar(comandoPararDeMonitorar);
            Comando.clicar(comandoMonitorar);
        }
    }


    public void acionarComandoPararDeMonitorar() {

        if(Label.textoPresente(comandoPararDeMonitorar)){
            Comando.clicar(comandoPararDeMonitorar);
        }else{
            Comando.clicar(comandoMonitorar);
            Comando.clicar(comandoPararDeMonitorar);
        }
    }

    public boolean verificarTarefaMonitorada() throws IOException {
        test2 = extent.createTest( "Monitorar Tarefas" );

        try{
            Label.textoPresente(comandoPararDeMonitorar);
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Monitorar Tarefa.png");
            extent.flush();
            return true;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Monitorar Tarefa.png");
            extent.flush();
            return false;
        }
    }

    public boolean verificarTarefaSemEstarMonitorada() throws IOException {
        test2 = extent.createTest( "Parar De Monitorar Tarefas" );
        try{
            Label.textoPresente(comandoMonitorar);
            test2.log( Status.PASS, "Teste realizado com sucesso");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Parar Monitorar Tarefa.png");
            extent.flush();
            return true;
        }catch (Exception e){
            test2.log(Status.FAIL, "Ocorreu uma falha no teste");
            test2.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + File.separator +
                            "src" + File.separator + "test" + File.separator + "java" +File.separator +"Arquivo"+ File.separator +"Parar Monitorar Tarefa");
            extent.flush();
            return false;
        }
    }

    public void registrarAdicionarFiltroTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Adicionar Filtro Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarAdicionarMarcadorTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Adicionar Marcador Tarefa.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarAlterarCategotiaTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Categoria Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarAlterarStatusTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Alterar Status Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarApagarMarcadorTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Adicionar Filtro Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarApagarTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Apagar Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarClonarTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Clonar Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarCriarTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Criar Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarDesmarcarTarefaPegajosa() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Adicionar Filtro Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarFecharTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Fechar Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarImprimirTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Imprimir Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarMarcarTarefaPegajosa() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Marcar Tarefa Pegajosa.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarMonitorarTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Monitorar Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarMoverTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Mover Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarParaMonitorarTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Parar Monitorar Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registrarPesquisarTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Pesquisa Tarefas.png" );//+ Generetor.dataHora()+".png");
    }

    public void registraRedefinirTarefas() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator + "Arquivo" + File.separator +"Redefinir Filtro Tarefa.png" );//+ Generetor.dataHora()+".png");
    }
}
