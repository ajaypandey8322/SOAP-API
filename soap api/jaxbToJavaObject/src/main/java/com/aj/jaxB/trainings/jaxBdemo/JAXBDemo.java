package com.aj.jaxB.trainings.jaxBdemo;

import java.io.StringReader;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;


public class JAXBDemo {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			//JAXBElement<Patient> jaxbElement = new JAXBElement<Patient>(new QName("","patient"), Patient.class,patient);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	            
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Ajay");

			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);

			System.out.println(writer.toString());
			
			Unmarshaller unmarshaller= context.createUnmarshaller();
			Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.println(patientResult.getName());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
