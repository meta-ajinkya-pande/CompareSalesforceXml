package com.util;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExportTxtFile {
    FileOutputStream out;

    public void exportFile(String fileName, String content) throws IOException {
        out = new FileOutputStream(fileName);
        byte[] bytesArray = content.getBytes();
        out.write(bytesArray);
        out.flush();
        out.close();
    }
}