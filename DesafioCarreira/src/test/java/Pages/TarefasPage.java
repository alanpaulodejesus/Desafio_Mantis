package Pages;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
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


    public TarefasPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public void euAcessoMenuVerTarefas(){
        Comando.clicar(menuVerTarefas);
    }

    public void euAcessoMenuCriarTarefas(){

        Comando.clicar(menuCriarTarefas);
    }

    public void euAcionoComandoCriarTarefa(){
        Comando.clicar(comandoCriarNovaTarefa);
    }

    public void euAcessoCategoriaTarefa(String tipo){
        Combo.selecionarCombo(categoriaBug, tipo);
    }

    public void euAcionoComandoFecharTarefa(){
        Comando.clicar(comandoFecharTarefa);
    }

    public void euConfirmoFechamentoComandoFecharTarefa(){
        Comando.clicar(comandoDeConfirmaFecharTarefa);
    }

    public void euAcessoFrequenciaTarefa(String tipo){
        Combo.selecionarCombo(frequenciaBug, tipo);
    }

    public void euAcessoGravidadeTarefa(String tipo){
        Combo.selecionarCombo(gravidadeBug, tipo);
    }

    public void euAcessoPrioridadeTarefa(String tipo){
        Combo.selecionarCombo(prioridadeBug, tipo);
    }

    public void euAcessoAtribuicaoTarefa(String tipo){
        Combo.selecionarCombo(atribuicaoBug, tipo);
    }

    public void euInformoResumoTarefa(String tipo){
        CampoTexto.preencher(resumoBug, tipo);
    }

    public void euInformoDescricaoBug(String tipo){
        CampoTexto.preencher(descriçãoBug, tipo);
    }

    public void euInformoReproducaoBug(String tipo){
        CampoTexto.preencher(reproduzirBug, tipo);
    }

    public Boolean euConfirmoCadastroComSucesso(){
        Tempo.aguardar(15, confirmoCadastroTarefaRealizada);
        return  Label.textoPresente(confirmoCadastroTarefaRealizada);
    }
    public String euVerificoIdTarefaCriada(){
        Tempo.aguardar(20, confirmoCadastroTarefaRealizada);
        return Label.recuperaTexto(confirmoCadastroTarefaRealizada);
    }

    public Boolean euVerificoStatusFechado(){
        Tempo.aguardar(20, confirmoStatusFechado);
        return Label.textoPresente(confirmoStatusFechado);
    }

    public Boolean euVerificoPesquisaIdTarefaCriada(){
        Tempo.aguardar(20, confirmoCadastroTarefaRealizada);
        return Label.textoPresente(confirmoCadastroTarefaRealizada);
    }


    public void euPesquisoTarefa(String pesquisa){
        Tempo.aguardar(20,campoPesquisaTarefa);
        CampoTexto.preencher(campoPesquisaTarefa,pesquisa);
        campoPesquisaTarefa.sendKeys(Keys.ENTER);

    }

    public void euAcionoComandoApagarTarefas(){
        Comando.clicar(comandoApagar);
        Comando.clicar(comandoConfirmacaoApagar);
    }

    public Boolean euVerificoGridVazio(){

        try {
            Label.textoPresente(selecionarTarefaParaAcao);
            selecionarTarefaParaAcao.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public String euVerificoAlteracaoCategoria(){
        return Label.recuperaTexto(informacaoCategoria);
    }

    public void euAcionoComandoAtualizar(){
        Comando.clicar(comandoAtualizar);
    }

    public void euAcionoComandoAtualizacaoInformacaoEmTarefa(){
        Comando.clicar(comandoAtualizacaoTarefaRealizada);
    }

    public void euAdicionoInformacaoTarefa(String texto){
        CampoTexto.preencher(campoAdicionarInformacaoTarefa, texto);
    }

    public void euVerificoTarefaParaExclusaoEmLote(){

        /*
        List<WebElement> lista= DriverFactory.getDriver().findElements(By.className(selecionarTarefaParaAcao));
        for (int i = 1; i <= lista.size(); i++) {

            selecionarTarefaParaAcao.click();
        }
        Label.tarefaPresenteExcluida(selecionarTarefaParaAcao);

        */
    }
}
