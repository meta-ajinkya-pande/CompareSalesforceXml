package com.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportExcelFile {

    private final String OUTPUT_LOCATION = 'Result/ProfileCompareExcelFiles'

    public void exportFile(String fileName, String sheetName, Object[][] sheetData) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        int rowNum = 0;
        try {
            FileOutputStream outputStream = getFileOutputStream(fileName);
            workbook.write(outputStream);
            for(Object[] rows : sheetData) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for(Object field : rows) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FileOutputStream getFileOutputStream(String fileName) {
        File file = new (OUTPUT_LOCATION + "/" + fileName);
        if(file.isExist()) {
            return new FileOutputStream(OUTPUT_LOCATION + "/" + fileName, false);
        } else {
            return new new FileOutputStream(OUTPUT_LOCATION + "/" + fileName);
        }

    }
}