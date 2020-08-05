package com.main.util;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;

public class FileHandling {
    
    public void deleteFilesFromFolder(String dirPath) {
        File dir = new File(dirPath);
        for (File file: dir.listFiles()) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    public void emptyFolder(String dirPath) {
        File dir = new File(dirPath);
        for (File file: dir.listFiles()) {
            file.delete();
        }
    }

    public void createFolder(String dirPath, String folderName) throws FileAlreadyExistsException {
        File dir = new File(dirPath + "/" + folderName);
        if(!dir.exists()) {
            dir.mkdir();
        } else {
            throw new FileAlreadyExistsException("File/Folder Exits on given path" + dirPath);
        }
    }
}