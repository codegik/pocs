package com.codegik.poc.cohesion.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TPSLCohesionConfig {

    @Bean("tpslMarshaller")
    public Jaxb2Marshaller tpslMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.codegik.poc.cohesion.segregated.tpsl");
        return marshaller;
    }


    @Bean("tpslCohesionClient")
    public TPSLCohesionClient tpslCohesionClient(@Qualifier("tpslMarshaller") Jaxb2Marshaller marshaller) {
        TPSLCohesionClient client = new TPSLCohesionClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
