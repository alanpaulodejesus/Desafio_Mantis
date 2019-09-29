/*
package Utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UtilsExcel {



    @Test
    public void main () throws IOException, InvalidFormatException {



    String projectPath = System.getProperty("user.dir");
    File obj = new File(projectPath+File.separator +"src"+File.separator +"test" +File.separator +"resources"+ File.separator +"ArquivoExcel.xlsx");
        FileInputStream fis = new FileInputStream(obj);

       // Object[][] data = new Object[][]{};
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheet("arquivo");

        XSSFRow totalcol = sheet.getRow(1);

       for ( int i=0; i<= sheet.getLastRowNum(); i++) {

        XSSFRow objRow = sheet.getRow(1);
        XSSFCell objCell = objRow.getCell(1);


            System.out.println(objRow);
            System.out.println(objCell);

            objCell = objRow.getCell(0);
            System.out.println(objCell.getStringCellValue());
            fis.close();

        }


        /*
    int rowcount = sheet.getLastRowNum();
        System.out.println(rowcount);

    int colum = sheet.getRow(1).getLastCellNum();
        System.out.println(colum);

    for(int i=1; i<=rowcount; i++){
        XSSFCell cell = sheet.getRow(i).getCell(i);

        }
*/

     /*
    @DataProvider(name="ArquivoExcel")
    public static Object [][] dadoExcel() throws IOException, InvalidFormatException {




        Object[][] data = new Object[][]{};


        String projectPath = System.getProperty("user.dir");
        Workbook arquivo = new XSSFWorkbook(new File(projectPath+File.separator +"src"+File.separator +"test" +File.separator +"resources"+ File.separator +"ArquivoExcel.xlsx"));
        Sheet pagina =  arquivo.getSheet("arquivo");
        int count = pagina.getPhysicalNumberOfRows();
        System.out.println(count);


        for (int i=1; i<= pagina.getLastRowNum();i++){
            Row row = pagina.getRow(i);
            final String nome = row.getCell(0).getStringCellValue();
            final String senha= row.getCell(0).getStringCellValue();
            data = (Object[][]) ArrayUtils.add(data, new Object[]{nome, senha});

        }

        System.out.println(data);
        return data;

    }

    */
     /*
    }

}

*/
