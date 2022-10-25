package com.lendingclub.bankgateway.cohesion.config;

import com.lendingclub.bankgateway.cohesion.CohesionClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CohesionConfig {

    @Value("${COHESION_WSDL:https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl}")
    private String cohesionUrl;


    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.lendingclub.bankgateway.cohesion.soap");
        return marshaller;
    }

    @Bean
    public CohesionClient cohesionClient(Jaxb2Marshaller marshaller) {
        final CohesionClient client = new CohesionClient();
        client.setDefaultUri(cohesionUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
