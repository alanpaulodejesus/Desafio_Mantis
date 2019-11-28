package Pages;

import Core.PropriedadesMarcador;
import Core.PropriedadesTarefas;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import TestTarefas.*;
import Utils.Tempo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

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

    public Boolean verificarAlteracaoStatusEmAtividade(){
        return Label.textoPresente(alteracaoStatusGravidade);
    }

    public Boolean verificarMarcadorEmTarefa(){
            if(Label.textoPresente(macardorEmTarefa)){
                return true;
            }else return false;
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

    public void acionarCategoriaTarefa(String tipo){
        Tempo.aguardar(6, categoriaBug);
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

    public Boolean confirmarCadastroComSucesso(){
        Tempo.aguardar(15, confirmoCadastroTarefaRealizada);
        return  Label.textoPresente(confirmoCadastroTarefaRealizada);
    }
    public String verificarIdTarefaCriada(){
        Tempo.aguardar(15, confirmoCadastroTarefaRealizada);
        return Label.recuperaTexto(confirmoCadastroTarefaRealizada);
    }

    public Boolean verificarStatusFechado(){
        Tempo.aguardar(20, confirmoStatusFechado);
        return Label.textoPresente(confirmoStatusFechado);
    }

    public Boolean verificarPesquisaIdTarefaCriada(){
        Tempo.aguardar(20, confirmoCadastroTarefaRealizada);
        return Label.textoPresente(confirmoCadastroTarefaRealizada);
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

    public Boolean verificarGridVazio(){

        try {
            Label.textoPresente(selecionarTarefaParaAcao);
            selecionarTarefaParaAcao.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public Boolean verificarTarefaMarcarda(){

        try {
            Label.textoPresente(comandoDesmarcarComoPegajosa);
            comandoDesmarcarComoPegajosa.getSize();
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public Boolean verificarTarefaDesmarcarda(){

        try {
            Label.textoPresente(comandoMarcarComoPegajosa);
            comandoMarcarComoPegajosa.getSize();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public void acionarComandoAplicaFiltro(){
        Tempo.aguardar(3, comandoAplicarFiltro);
        Comando.clicar(comandoAplicarFiltro);
    }
    public String verificarAlteracaoCategoria(){
        return Label.recuperaTexto(informacaoCategoria);
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

    public Boolean tarefaEmGriImprimir(){
        try{
            Label.textoPresente(confirmoCadastroTarefaRealizada);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Boolean verificarTarefaEmGrid(){
        return Label.textoPresente(atividadeGrid);
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
        Tempo.aguardar(2, comboAdministrador);
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

    public boolean verificarRedefinicaoTarefa() {

        try {
            if(Label.textoPresente(validarRedefinir)){
                return true;
            }
        }catch (Exception e){
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

    public boolean verificarTarefaMonitorada() {

        try{
            Label.textoPresente(comandoPararDeMonitorar);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean verificarTarefaSemEstarMonitorada() {

        try{
            Label.textoPresente(comandoMonitorar);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
