package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelFile {

    private final String OUTPUT_LOCATION = "Result/ProfileCompareExcelFiles";

    public void exportFile(String fileName, String sheetName, List<List<Object>> sheetData) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        int rowNum = 0;
        try {
            FileOutputStream outputStream = getFileOutputStream(fileName);
            workbook.write(outputStream);
            for(List<Object> rows : sheetData) {
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

    private FileOutputStream getFileOutputStream(String fileName) throws FileNotFoundException {
        File file = new File(OUTPUT_LOCATION + "/" + fileName);
        if(file.exists()) {
            return new FileOutputStream(OUTPUT_LOCATION + "/" + fileName, false);
        } else {
            return new FileOutputStream(OUTPUT_LOCATION + "/" + fileName);
        }

    }
}