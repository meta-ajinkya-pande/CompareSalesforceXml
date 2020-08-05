package com.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlToObject<T> {

    private Unmarshaller jaxbUnmarshaller;
    private final Class<T> type;

    public XmlToObject(Class<T> type) {
        this.type = type;
    }

    private Class<T> getMyType() {
        return this.type;
    }

    @SuppressWarnings("unchecked")
    public Map<String, T> convertXMLsToObjects(String filesLocation) throws Exception {
        Map<String, T> objectMap = null;
        File file = new File(filesLocation);
        File[] fileContents = file.listFiles();
        if (fileContents != null) {
            objectMap = new TreeMap<String, T>();
            JAXBContext jaxbContext = JAXBContext.newInstance(getMyType());
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            for (int i = 0; i < fileContents.length; i++) {
                System.out.println(fileContents[i]);
                FileInputStream is = new FileInputStream(fileContents[i]);
                T object = (T) jaxbUnmarshaller.unmarshal(is);
                objectMap.put(fileContents[i].getName(), object);
            }
        } else {
            throw new Exception("List of Files not found");
        }
        return objectMap;
    }

    @SuppressWarnings("unchecked")
    public Object convertXMLToObject(String fileName) throws Exception {
        T object;
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(getMyType());
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        object = (T) jaxbUnmarshaller.unmarshal(file);
        return object;
    }
}