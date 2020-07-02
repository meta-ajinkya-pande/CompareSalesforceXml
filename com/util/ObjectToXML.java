package com.util;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ObjectToXML {

    private Marshaller marshallerObj;
    private FileOutputStream fileOutputStream;

    public void convertObjecttoXml(Object xmlObj) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(xmlObj.getClass());
        marshallerObj = jaxbContext.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        if(fileOutputStream != null) {
            marshallerObj.marshal(xmlObj, fileOutputStream);
        } else {
            throw new Exception("Please set filOutputStream First");
        }
    }

    public FileOutputStream getFileOutputStream() {
        return fileOutputStream;
    }

    public void setFileOutputStream(String outputLocation) throws IOException {
        if(fileOutputStream != null) {
            fileOutputStream.close();
        }
        fileOutputStream = new FileOutputStream(outputLocation);
    }

}