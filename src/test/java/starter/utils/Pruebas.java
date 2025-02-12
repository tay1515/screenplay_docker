package starter.utils;

//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Pruebas {


    public static DataPool pool;

    public static void main(String[] args) throws IOException {

        pool = new DataPool("Personas.xlsx", 0);
        pool.ReadSpecificExcelData("3");
        //System.out.println("pruebas " + pool.getResult().get(0));
        //String[] datos = pool.getValueIndex(6).split(",");
        //System.out.println("datoss " + datos[0] + " " + datos[2]);
        //System.out.println("pruebas " + pool.getValueName(0, "Susana"));
         //System.out.println("data " + pool.ReadAllExcelData());
        //System.out.println("Column index " + pool.getColumnIndex("PO"));
        //System.out.println("Column " + pool.FindSpecificColumnExcel("Analista"));
        //pool.ReadAllExcelData2("Nombre");
        System.out.println("prueba" + pool.getResult());
    }


}


/*
   cell = cellIterator.next();

                    if (cell.getCellType() == CellType.STRING) {
                        String value = cell.getStringCellValue();
                        System.out.println("string " + value);
                    }

                    if (cell.getCellType() == CellType.NUMERIC) {
                        double value = cell.getNumericCellValue();
                        System.out.println("int " + value);
                    }

                    if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = cell.getDateCellValue();
                        System.out.println("int " + format.format(date));
                    }

                       DataFormatter formatter = new DataFormatter();

            for (Row row : sheet) { // For each Row.
                Cell cell = row.getCell(0).; // Get the Cell at the Index / Column you want.
                if(formatter.formatCellValue(cell).equalsIgnoreCase("Santiago")) {
                    System.out.println(cell.getRow().getLastCellNum());
                    for(int i=0;i<=cell.getRow().getLastCellNum()-1;i++) {
                        System.out.println(cell.getRow().getCell(i));
                    }
                }
            }

            //SOLO CON CRITERIO
              for (Row row : sheet) {
                for (Cell cell : row) {
                    if (formatter.formatCellValue(cell).equalsIgnoreCase("4")) {
                        System.out.println(cell.getRow().getLastCellNum());
                        for (int i = 0; i <= cell.getRow().getLastCellNum() - 1; i++) {
                            System.out.println(cell.getRow().getCell(i));
                        }

                    }
                }

*
* */