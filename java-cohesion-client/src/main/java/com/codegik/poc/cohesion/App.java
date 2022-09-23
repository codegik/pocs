package com.codegik.poc.cohesion;

import com.codegik.poc.cohesion.miser.tpsl.MiserXMLInput;
import com.codegik.poc.cohesion.miser.vbtp.Transaction;
import com.codegik.poc.cohesion.miser.vbtp.VBTPRequest;
import com.codegik.poc.cohesion.webservices.CohesionConnect;
import com.codegik.poc.cohesion.webservices.STran;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public void connectOriginal() {
        try {
            final URL url = new URL("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("Requesting Cohesion to " + url);
            final CohesionConnect cohesionConnect = new CohesionConnect();
            final STran sTran = new STran();
            final MiserXMLInput miserXMLInput = new MiserXMLInput();
            final VBTPRequest vbtpRequest = new VBTPRequest();
            final Transaction transaction = new Transaction();

            vbtpRequest.setTransaction(transaction);
            sTran.setMiserXMLInput(miserXMLInput);
            sTran.setVBTPRequest(vbtpRequest);
            cohesionConnect.getCohesionConnectSoap().getHostReply(sTran);
            logger.info("Success");
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public void connectSegregated() {
        try {
            final URL url = new URL("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("Requesting Cohesion");
            final com.codegik.poc.cohesion.segregated.vbtp.CohesionConnect cohesionConnect = new com.codegik.poc.cohesion.segregated.vbtp.CohesionConnect(url);
            final com.codegik.poc.cohesion.segregated.vbtp.STran sTran = new com.codegik.poc.cohesion.segregated.vbtp.STran();
            final com.codegik.poc.cohesion.segregated.vbtp.VBTPRequest vbtpRequest = new com.codegik.poc.cohesion.segregated.vbtp.VBTPRequest();
            final com.codegik.poc.cohesion.segregated.vbtp.Transaction transaction = new com.codegik.poc.cohesion.segregated.vbtp.Transaction();

            vbtpRequest.setTransaction(transaction);
            sTran.setVBTPRequest(vbtpRequest);
            cohesionConnect.getCohesionConnectSoap().getHostReply(sTran);
            logger.info("Success");
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public void connect() {
        logger.info("Requesting Cohesion from wsimport");

        com.fidelityifs.webservices.CohesionConnect cohesionConnect = new com.fidelityifs.webservices.CohesionConnect();
        final String response = cohesionConnect.getCohesionConnectSoap().ping();

        logger.info("Success " + response);
    }


    public void run(String... args) {
//        connectOriginal();
        connectSegregated();
//        connect();
    }
}
