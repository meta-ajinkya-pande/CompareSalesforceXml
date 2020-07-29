package com.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelFile {

    private final String OUTPUT_LOCATION = "Result/ProfileCompareExcelFiles";

    public void exportFile(String fileName, Map<String, List<List<Object>>> workbookMap) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(OUTPUT_LOCATION + "/" + fileName + ".xls");
        XSSFWorkbook workbook = new XSSFWorkbook();
        for(String sheetName : workbookMap.keySet()) {
            exportFile(workbook, sheetName, workbookMap.get(sheetName));
        }
        workbook.write(outputStream);
        workbook.close();
    }

    private void exportFile(XSSFWorkbook workbook, String sheetName, List<List<Object>> sheetData) throws IOException {
        List<List<Object>> transposeSheetData = transpose(sheetData);
        XSSFSheet sheet = workbook.createSheet(sheetName);
        int rowNum = 0;
        for(List<Object> rows : transposeSheetData) {
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
    }
    
    @SuppressWarnings("unchecked")
    private <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        int maxSize = 0;
        for(int i = 0; i < table.size(); i++) {
            if(maxSize < table.get(i).size()) {
                maxSize = table.get(i).size();
            }
        }
        for (int i = 0; i < maxSize; i++) {
            List<T> col = new ArrayList<T>();
            for (int j=0; j < table.size(); j++) {
                if(table.get(j).size() > i) {
                    col.add(table.get(j).get(i));
                } else {
                    col.add((T) "");
                }
            }
            ret.add(col);
        }
        return ret;
    }
}