package com.metadata.Object.objectUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.main.util.ExportExcelFile;
import com.metadata.Object.CustomObject;

public class ObjectFileExport {
    
    public void exportExternalSharingExcelFile(Map<String, CustomObject> ObjectNameMap) throws IOException {
        String outputFileName = "Object External Access";
        String SheetName = "External Access";
        Map<String, List<List<Object>>> workbookMap = new TreeMap<>();
        List<List<Object>> sheetData = new ArrayList<>();
        List<Object> col = new ArrayList<>();
        col.add("Object Name");
        col.add("External Object Access");
        col.add("OWD");
        col.add("Comment");
        sheetData.add(col);
        for(String objectName : ObjectNameMap.keySet()) {
            List<Object> col1 = new ArrayList<>();
            col1.add(objectName);
            col1.add(ObjectNameMap.get(objectName).getExternalSharingModel());
            col1.add(ObjectNameMap.get(objectName).getSharingModel());
            sheetData.add(col1);
        }
        workbookMap.put(SheetName, sheetData);
        ExportExcelFile exportExcelFile = new ExportExcelFile();
        exportExcelFile.setIsSingleLine(false);
        exportExcelFile.setIsTransposeRequired(false);
        exportExcelFile.exportFile(outputFileName, workbookMap);
    }
}
