package Pages;

import Core.PropriedadesCategoria;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestCategoria.ApagarCategoriaTest;
import TestCategoria.CadastrarCategoriaTest;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;

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


    public CategoriaPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euAcionoMenuGerenciar()  {
        Comando.clicar(menuGerenciar);
    }


    public void euAcionoMenuGerenciarProjetos(){
        Comando.clicar(menuGerenciarProjetos);
    }

    public void euPreenchoCampoNomeCategoria(String texto){
        CampoTexto.limpar(campoNomeCategoria);
        CampoTexto.preencher(campoNomeCategoria, texto);
    }

    public void euAcionoComandoAdicionarCategoria(){
        Comando.clicar(comandoAdicionarCategoria);
    }

    public Boolean euVerificoCategoriaEmGrid(){
        Tempo.aguardar(5, menuGerenciarProjetos);
        if(Label.textoPresente(categoriaTesteEmGrid) || Label.textoPresente(categoriaAlteradaTesteEmGrid)){
            return true;
        }else return false;
    }

    public void euVerificoSeExisteCategoriaCriada(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);

        if(Label.textoPresente(categoriaTesteEmGrid)|| Label.textoPresente(categoriaAlteradaTesteEmGrid)){
            ApagarCategoriaTest apagarCategoria = new ApagarCategoriaTest();
            apagarCategoria.apagarCategoria();
        }else{

        }
    }
    public void euVerificoSeExisteCategoriaAExcluir(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarProjetos);

        if(Label.textoPresente(categoriaTesteEmGrid)|| Label.textoPresente(categoriaAlteradaTesteEmGrid)){

        }else{
            CadastrarCategoriaTest cadastrarCategoria = new CadastrarCategoriaTest();
            cadastrarCategoria.cadastraCategoria();
        }
    }
    public void euVerificoSeExisteCategoriaAAlterar(){

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

    public void euAcionoAlterarCategoria() {
        Comando.clicar(comandoAlterarCategoria);
    }

    public void euAcionoExcluirCategoria() {
        Comando.clicar(comandoApagarCategoria);
    }

    public void euConfirmoExcluirCategoria(){
        Comando.clicar(confirmarExclusao);
    }

    public void euAcionoComandoAtualizarCategoria() {
        Comando.clicar(comandoAtualizarCategoria);
    }
}
