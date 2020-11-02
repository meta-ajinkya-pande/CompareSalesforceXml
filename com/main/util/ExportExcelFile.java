package com.main.util;

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

    private Boolean isSingleLine = true;
    private Boolean isTransposeRequired = true;
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
        List<List<Object>> modifiedSheetData;
        if(!isSingleLine && isTransposeRequired) {
            modifiedSheetData = transpose(sheetData);
        } else if(isTransposeRequired){
            List<List<Object>> singleLineSheetData = singleLine(sheetData);
            modifiedSheetData = transpose(singleLineSheetData);
        } else {
            modifiedSheetData = sheetData;
        }
        XSSFSheet sheet = workbook.createSheet(sheetName);
        Integer rowNum = 0;
        for(List<Object> rows : modifiedSheetData) {
            Row row = sheet.createRow(rowNum++);
            Integer colNum = 0;
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
    private <T> List<List<T>> singleLine(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        List<T> ret1 = new ArrayList<T>();
        for(Integer i=0;i<table.size();i++) {
            for(Integer j=0;j<table.get(i).size(); j++) {
                ret1.add(table.get(i).get(j));
            }
            ret1.add((T) "");
        }
        ret.add(ret1);
        List<T> arr1 = new ArrayList<T>();
        arr1.add((T) "Module");
        List<T> arr2 = new ArrayList<T>();
        arr2.add((T) "Resolution Status");
        ret.add(arr1);
        ret.add(arr2);
        return ret;
    }
    
    @SuppressWarnings("unchecked")
    private <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        Integer maxSize = 0;
        for(Integer i = 0; i < table.size(); i++) {
            if(maxSize < table.get(i).size()) {
                maxSize = table.get(i).size();
            }
        }
        for (Integer i = 0; i < maxSize; i++) {
            List<T> col = new ArrayList<T>();
            for (Integer j=0; j < table.size(); j++) {
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

    public Boolean getIsSingleLine() {
        return isSingleLine;
    }

    public void setIsSingleLine(Boolean isSingleLine) {
        this.isSingleLine = isSingleLine;
    }

    public Boolean getIsTransposeRequired() {
        return isTransposeRequired;
    }

    public void setIsTransposeRequired(Boolean isTransposeRequired) {
        this.isTransposeRequired = isTransposeRequired;
    }
}