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

    public void run(String... args) {
        try {
            logger.info("Requesting Cohesion");
            final URL url = new URL("https://cohesion2.fisglobal.com/");
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
}
