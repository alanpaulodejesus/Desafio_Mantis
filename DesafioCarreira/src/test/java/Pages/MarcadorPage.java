package Pages;

import Core.PropriedadesMarcador;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import TestMarcador.CriarMarcadorTest;
import TestMarcador.ExcluirMarcadorTest;
import Utils.Tempo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static Core.DriverFactory.getDriver;

public class MarcadorPage {

    @FindBy(xpath = "//span[text()=\" Gerenciar \"]") private WebElement menuGerenciar;
    @FindBy(linkText = "Gerenciar Marcadores") private WebElement menuGerenciarMarcadores;
    @FindBy(xpath = "//*[contains(text(),'"+ PropriedadesMarcador.nomeMacador+"')]") private WebElement marcadorEmGrid;
    @FindBy(xpath = "//*[contains(text(),'"+ PropriedadesMarcador.nomeMacador1+"')]") private WebElement marcadorEmGrid1;
    @FindBy(xpath = "//*[contains(text(),'"+ PropriedadesMarcador.nomeMacador2+"')]") private WebElement marcadorEmGrid2;
    @FindBy(xpath = "//*[contains(text(),'"+ PropriedadesMarcador.nomeMacador3+"')]") private WebElement marcadorEmGrid3;
    @FindBy(xpath = "//*[contains(text(),'"+ PropriedadesMarcador.nomeMacador4+"')]") private WebElement marcadorEmGrid4;
    @FindBy(id = "tag-name")private WebElement campoNomeMarcador;
    @FindBy(id = "tag-description")private WebElement campoDescricaoMarcador;
    @FindBy(name = "config_set") private WebElement comandoCriarMarcador;
    @FindBy(xpath = "//input[@value=\"Apagar Marcador\"]") private WebElement comandoApagarMarcador;
    @FindBy(xpath = "//input[@value=\"Atualizar Marcador\"]") private WebElement comandoAtualizarMarcador;


    public MarcadorPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void acionarMenuGerenciar()  {
        Comando.clicar(menuGerenciar);
    }

    public void acionarMenuGerenciaMarcador()  {
        Comando.clicar(menuGerenciarMarcadores);
    }

    public void acionarComandoAtualizarMarcador()  {
        Comando.clicar(comandoAtualizarMarcador);
    }

    public void acionarMarcadorEmGrid()  {
        if (Label.textoPresente( marcadorEmGrid )){
            Comando.clicar(marcadorEmGrid);
        }else if( Label.textoPresente( marcadorEmGrid1 )){
            Comando.clicar(marcadorEmGrid1);
        } else if(Label.textoPresente( marcadorEmGrid2 )){
            Comando.clicar(marcadorEmGrid2);
        }else if(Label.textoPresente( marcadorEmGrid3 )){
            Comando.clicar(marcadorEmGrid3);
        }else if (Label.textoPresente( marcadorEmGrid4 )){
            Comando.clicar(marcadorEmGrid4);
        }
    }

    public void acionarComandoApagarMarcador()  {
        Comando.clicar(comandoApagarMarcador);
    }

    public void preencherCampoNomeMarcador(String texto){
        CampoTexto.preencher(campoNomeMarcador,texto );
    }

    public void preencherCampoDescricaoMarcador(String texto){
        CampoTexto.limpar(campoDescricaoMarcador);
        CampoTexto.preencher(campoDescricaoMarcador, texto);
    }

    public void preencherMarcadorTDD() throws IOException {

        String projectPath = System.getProperty("user.dir");
        File src=new File(projectPath+File.separator +"src"+File.separator +"test" +File.separator +"resources"+ File.separator +"ArquivoExcel.xlsx");
        FileInputStream finput = new FileInputStream(src);

        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFCell cell;

        workbook = new XSSFWorkbook(finput);
        sheet= workbook.getSheetAt(0);

        for(int i=1; i<=sheet.getLastRowNum(); i++)
            {
                cell = sheet.getRow( i ).getCell( 0);
                cell.setCellType( Cell.CELL_TYPE_STRING );

                CampoTexto.preencher( campoNomeMarcador, cell.getStringCellValue() );

                cell = sheet.getRow( i ).getCell( 1);

                cell.setCellType( Cell.CELL_TYPE_STRING );

                CampoTexto.preencher( campoDescricaoMarcador, cell.getStringCellValue() );

                FileOutputStream fileOutput = new FileOutputStream( src );

                workbook.write( fileOutput );

                fileOutput.close();
                acionarComandoCriarMarcador();
        }
    }


    public void acionarComandoCriarMarcador(){
        Comando.clicar(comandoCriarMarcador);
    }

    public void verificarSeExisteMarcadorAExcluir(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarMarcadores);
        ExcluirMarcadorTest exluirMarcador = new ExcluirMarcadorTest();

        if(Label.textoPresente(marcadorEmGrid)){
            exluirMarcador.excluirMarcador();
        }else {

        }
    }

    public Boolean verificarMarcadorEmGrid(){
        Tempo.aguardar(5, marcadorEmGrid);
        try {
            Label.textoPresente(marcadorEmGrid);
            marcadorEmGrid.getSize();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Boolean verificarMarcadoresTDDEmGrid(){

        if(Label.textoPresente( marcadorEmGrid )|| Label.textoPresente( marcadorEmGrid1 )
                || Label.textoPresente( marcadorEmGrid2 )|| Label.textoPresente( marcadorEmGrid3 )||
                Label.textoPresente( marcadorEmGrid4 )){

        }
        return true;
    }

    public boolean excluirMarcadores(){
        ExcluirMarcadorTest excluirMarcadores = new ExcluirMarcadorTest();

            while(Label.textoPresente( marcadorEmGrid )|| Label.textoPresente( marcadorEmGrid1 )
                    || Label.textoPresente( marcadorEmGrid2 )|| Label.textoPresente( marcadorEmGrid3 )||
                    Label.textoPresente( marcadorEmGrid4 )) {
                excluirMarcadores.excluirMarcador();
            }
                return true;

    }

    public Boolean verificarMarcadorNaoEstaEmGrid(){

        try {
            Label.textoPresente(marcadorEmGrid);
            marcadorEmGrid.getSize();
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void verificarSeExisteMarcador(){

        Comando.clicar(menuGerenciar);
        Comando.clicar(menuGerenciarMarcadores);
        CriarMarcadorTest criarMarcador = new CriarMarcadorTest();

        if(Label.textoPresente(marcadorEmGrid)){

        }else {
            criarMarcador.criarMarcador();

        }
    }


}
