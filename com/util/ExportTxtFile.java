package com.util;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExportTxtFile {
    FileOutputStream out;
    private final String OUTPUT_LOCATION = "Result/ProfileCompareTextFiles/";

    public void exportFile(String fileName, String content) throws IOException {
        out = new FileOutputStream(OUTPUT_LOCATION + fileName);
        byte[] bytesArray = content.getBytes();
        out.write(bytesArray);
        out.flush();
        out.close();
    }
}