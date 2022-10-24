package com.dotcomtirocinio.esercizio040;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@EnableWebMvc  //usado para habilitar o Spring MVC
@Configuration
public class AppMarshaller {


    @Bean("xmlMarshaller")
    public Jaxb2Marshaller getMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Parametri.class);

        return marshaller;
    }

    @Bean
    public Parametri getParametri() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext   = JAXBContext.newInstance(Parametri.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream is = Parametri.class.getResourceAsStream("/web.xml"); //meto um fluxo de entrada de bytes = InputStream + classe + ottieni risorse come flusso >> Metodo getResoruseAsStrem busca com arquivo local
//        InputStream is = new FileInputStream("/home/patricia/Documenti/07.10/esercizio05.10/esercizio04.10/src/main/resources/web.xml");
        Parametri param = (Parametri) jaxbUnmarshaller.unmarshal(is);
        return param;
    }

//    @Bean
//    public Parametri getParametri() throws JAXBException, FileNotFoundException {
//        JAXBContext jaxbContext   = JAXBContext.newInstance(Parametri.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        InputStream is = new FileInputStream("/home/patricia/Documenti/07.10/esercizio05.10/esercizio04.10/src/main/resources/web.xml");
//        Parametri param = (Parametri) jaxbUnmarshaller.unmarshal(is);
//        return param;
//    }


//    @Bean
//    public Unmarshaller getUnmarshaller() throws JAXBException {
//        JAXBContext jaxbContext   = JAXBContext.newInstance(Parametri.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//        return jaxbUnmarshaller;
//    }
}



