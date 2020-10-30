package com.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    public Map<String, List<Object>> readObjectExcelFile(String fileName) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            Map<String, List<Object>> sheetRowDataMap = new TreeMap<String, List<Object>>();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                int i = 0;
                String objectName = "";
                List<Object> objectValues = new ArrayList<Object>();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                        if(i == 0) {
                            objectName = currentCell.getStringCellValue();
                            sheetRowDataMap.put(objectName, objectValues);
                        } else {
                            objectValues.add(currentCell.getStringCellValue());
                        }
                        i++;
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                        objectValues.add(currentCell.getNumericCellValue());
                        i++;
                    } else if(currentCell.getCellType() == CellType.BOOLEAN) {
                        System.out.print(currentCell.getBooleanCellValue() + "--");
                        objectValues.add(currentCell.getBooleanCellValue());
                        i++;
                    }
                }
                System.out.println();
            }
            workbook.close();
            return sheetRowDataMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
}
