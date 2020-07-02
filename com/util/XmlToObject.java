package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
                T object = (T) jaxbUnmarshaller.unmarshal(fileContents[i]);
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