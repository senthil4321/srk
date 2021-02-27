package com.srk.demo.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshalMain {
    public static void main(String[] args) {
	NameModel nameObject = new NameModel();
	nameObject.setName("srk");

	try {

	    File file = new File("com.srk.demo.jaxb.name.xml");
	    JAXBContext jaxbContext = JAXBContext.newInstance(NameModel.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    jaxbMarshaller.marshal(nameObject, file);
	    jaxbMarshaller.marshal(nameObject, System.out);

	} catch (JAXBException e) {
	    e.printStackTrace();
	}

    }
}
