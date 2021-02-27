package com.srk.demo.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnmarshalMain {

    private static final Logger LOGGER = LogManager.getLogger(UnmarshalMain.class);

    public static void main(String[] args) {

	try {

	    File file = new File("com.srk.demo.jaxb.name.input.xml");
	    JAXBContext jaxbContext = JAXBContext.newInstance(NameModel.class);

	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    NameModel nameModel = (NameModel) jaxbUnmarshaller.unmarshal(file);
	    System.out.println(nameModel.getName());

	} catch (JAXBException e) {
	    e.printStackTrace();
	}
    }
}
