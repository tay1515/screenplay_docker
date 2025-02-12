package starter.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataPool {

    private final FileInputStream inputStream;
    private final XSSFWorkbook workbook;

    private XSSFSheet sheet;

    private List<String> datatestcase;

    private List<String[]> filterList;


    public DataPool(String filename, int sheetIndex) throws IOException {
        File file = new File(String.valueOf(Paths.get(filename)));
        this.inputStream = new FileInputStream(file);
        this.workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheetAt(sheetIndex);
    }

    public DataPool(String filename, String sheetName) throws IOException {
        File file = new File(String.valueOf(Paths.get(filename)));
        this.inputStream = new FileInputStream(file);
        this.workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public List<String> ReadAllExcelData() throws IOException {

        try {
            Cell cell;
            Row row;
            ArrayList<String> data = new ArrayList<>();

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    data.add(cell.toString());
                }
            }

            return data;

        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            workbook.close();
        }
        return null;
    }

    public void ReadAllExcelData2(String testcase) throws IOException {

       try {

           DataFormatter formatter = new DataFormatter();
           Iterator<Row> rowIterator = sheet.iterator();
           while (rowIterator.hasNext())
           {
               Row row = rowIterator.next();
               //For each row, iterate through all the columns
               Iterator<Cell> cellIterator = row.cellIterator();
               ArrayList<String> data = new ArrayList<>();

               while (cellIterator.hasNext()) {
                   Cell cell = cellIterator.next();

                   if (formatter.formatCellValue(cell).equalsIgnoreCase(testcase)) {

                       //Check the cell type and format accordingly
                       switch (cell.getCellType()) {
                           case NUMERIC:


                               if (DateUtil.isCellDateFormatted(cell)) {
                                   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                   Date date = cell.getDateCellValue();
                                   String cellValue = format.format(date);
                                   System.out.print(" " + cellValue);
                               } else {
                                   double cellValue = cell.getNumericCellValue();
                                   System.out.println(" " + cellValue);
                               }


                               break;
                           case STRING:
                               System.out.print(" " + cell.getStringCellValue());
                               break;
                       }

                       data.add(String.valueOf(cell));
                   }
               }
               this.datatestcase=data;
               System.out.println("Reading File Completed.");
           }
           inputStream.close();
           workbook.close();
       }
       catch (Exception ex)
       {
           ex.printStackTrace();
       }

    }


    public DataPool ReadSpecificExcelData(String testcase) throws IOException {

        try {

            DataFormatter formatter = new DataFormatter();
            List<String> data = new ArrayList<>();

            for (Row row : sheet) { // For each Row.
                Cell cell = row.getCell(0); // Get the Cell at the Index / Column you want.
                if (formatter.formatCellValue(cell).equalsIgnoreCase(testcase)) {
                    //System.out.println(cell.getRow().getLastCellNum());
                    for (int i = 0; i <= cell.getRow().getLastCellNum() - 1; i++) {
                        data.add(String.valueOf(cell.getRow().getCell(i)));
                        //System.out.println(cell.getRow().getCell(i));
                    }
                }
            }

            this.datatestcase = data;
            return this;

        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            workbook.close();
        }
        return null;
    }

    public List<String> getResult() {
        return this.datatestcase;
    }

    public int getColumnIndex(String indexColumn) {
        try {
            return this.getResult().indexOf(indexColumn);
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public String getValueIndex(int indexColumn) {
        try {
            return this.getResult().get(indexColumn);
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    public String getValueName(int index, String valueName) {
        try {
            return this.getResult().set(index, valueName);
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }


}
