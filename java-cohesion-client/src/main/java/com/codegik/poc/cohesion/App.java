package com.codegik.poc.cohesion;

import com.codegik.poc.cohesion.miser.tpsl.MiserXMLInput;
import com.codegik.poc.cohesion.miser.vbtp.Transaction;
import com.codegik.poc.cohesion.miser.vbtp.VBTPRequest;
import com.codegik.poc.cohesion.segregated.tpsl.GetHostReplyResponse;
import com.codegik.poc.cohesion.segregated.tpsl.IsSessionPresentResponse;
import com.codegik.poc.cohesion.segregated.tpsl.LogonResponse;
import com.codegik.poc.cohesion.spring.TPSLCohesionClient;
import com.codegik.poc.cohesion.spring.VBTPCohesionClient;
import com.codegik.poc.cohesion.webservices.CohesionConnect;
import com.codegik.poc.cohesion.webservices.STran;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    private TPSLCohesionClient tpslCohesionClient;

    @Autowired
    private VBTPCohesionClient vbtpCohesionClient;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public void connectOriginal() {
        try {
            final URL url = new URL("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("Requesting Cohesion with WSDL from repository");
            final CohesionConnect cohesionConnect = new CohesionConnect(url);
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


    public void connectWithWSDLFromServer() {
        try {
            logger.info("Requesting Cohesion WSDL downloaded from server");
            final URL url = new URL("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");

            com.fidelityifs.webservices.CohesionConnect cohesionConnect = new com.fidelityifs.webservices.CohesionConnect(url);
            final String response = cohesionConnect.getCohesionConnectSoap().ping();

            logger.info("Success " + response);
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public void connectTPSLSegregatedGetHostReply() {
        try {
            logger.info("Requesting connectTPSLSegregatedGetHostReply");

            GetHostReplyResponse response = tpslCohesionClient.getHostReply("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("Success");
            logger.info("result -> " + response.getGetHostReplyResult());
            logger.info("MiserXMLReply -> " + response.getGetHostReplyResult().getMiserXMLReply());
            logger.info("HeaderData -> " + response.getGetHostReplyResult().getMiserXMLReply().getHeaderData());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public void connectVBTPSegregadtedGetHostReply() {
        try {
            logger.info("Requesting connectVBTPSegregadtedGetHostReply");

            com.codegik.poc.cohesion.segregated.vbtp.GetHostReplyResponse response = vbtpCohesionClient.getHostReply("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("Success");
            logger.info("result -> " + response.getGetHostReplyResult());
            logger.info("VBTPReply -> " + response.getGetHostReplyResult().getVBTPReply());
            logger.info("Content -> " + response.getGetHostReplyResult().getVBTPReply().getContent());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public void connectTPSLSegregatedIsSessionPresent() {
        try {
            logger.info("Requesting connectSegregatedIsSessionPresent");

            IsSessionPresentResponse result = tpslCohesionClient.isSessionPresent("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("success? " + result.isIsSessionPresentResult());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public void connectSegregatedLogon() {
        try {
            logger.info("Requesting connectSegregatedLogon");

            LogonResponse result = tpslCohesionClient.logon("https://cohesion2.fisglobal.com/LendingClubNarmiAWSTest/cohesionconnect.asmx?wsdl");
            logger.info("success? " + result.getLogonResult());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }


    public void run(String... args) {
        connectOriginal();
        connectWithWSDLFromServer();
        connectTPSLSegregatedGetHostReply();
//        connectVBTPSegregadtedGetHostReply();
//        connectTPSLSegregatedIsSessionPresent();
//        connectSegregatedLogon();
    }

}
