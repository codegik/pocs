package com.codegik.poc.cohesion.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class VBTPCohesionConfig {

    @Bean("vbtpMarshaller")
    public Jaxb2Marshaller vbtpMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.codegik.poc.cohesion.segregated.vbtp");
        return marshaller;
    }


    @Bean("vbtpCohesionClient")
    public VBTPCohesionClient vbtpCohesionClient(@Qualifier("vbtpMarshaller") Jaxb2Marshaller marshaller) {
        VBTPCohesionClient client = new VBTPCohesionClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
