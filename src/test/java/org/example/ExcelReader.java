package org.example;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException {
        String path ="";
        FileInputStream fis = null;
        File file = new File(path);
        try {
            fis = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
            int numberOfRows = sheet.getPhysicalNumberOfRows();
            int numberofColumns = sheet.getRow(0).getLastCellNum();
            Object[][] on = new Object[numberOfRows-1][numberofColumns];
            for(int i=0;i<numberOfRows;i++){
                for(int j=0;j<numberofColumns;j++){
                    DataFormatter df = new DataFormatter();
                    on[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fis.close();

        }


    }
}
