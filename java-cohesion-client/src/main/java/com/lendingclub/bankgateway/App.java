package com.lendingclub.bankgateway;

import com.lendingclub.bankgateway.cohesion.CohesionClient;
import com.lendingclub.bankgateway.cohesion.soap.GetHostReply;
import com.lendingclub.bankgateway.cohesion.soap.GetHostReplyResponse;
import com.lendingclub.bankgateway.cohesion.soap.HeaderData;
import com.lendingclub.bankgateway.cohesion.soap.IsSessionPresentResponse;
import com.lendingclub.bankgateway.cohesion.soap.MiserXMLInput;
import com.lendingclub.bankgateway.cohesion.soap.STran;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.lendingclub.bankgateway.cohesion.util.DataUtil.gimmeDefaultInputFieldList;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    private CohesionClient cohesionClient;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    public void getHostReplyTest() {
        final GetHostReply hostReply = new GetHostReply();
        final STran sTran = new STran();
        final MiserXMLInput miserXMLInput = new MiserXMLInput();
        final HeaderData headerData = new HeaderData();

        headerData.setApplicationCode("MS");
        headerData.setTransactionCode("XT$");
        headerData.setPosition(1);
        headerData.setFundType("7");
        miserXMLInput.setHeaderData(headerData);
        miserXMLInput.getInputField().addAll(gimmeDefaultInputFieldList());
        sTran.setMiserXMLInput(miserXMLInput);
        hostReply.setSTran(sTran);


        final GetHostReplyResponse getHostReplyResponse = cohesionClient.getHostReply(hostReply);
        logger.info("getHostReplyResponse: {}", getHostReplyResponse);
        logger.info("getHostReplyResponse.getHostReplyResult: {}", getHostReplyResponse.getGetHostReplyResult());
        logger.info("getHostReplyResponse.getHostReplyResult.getVbtpReply: {}", getHostReplyResponse.getGetHostReplyResult().getVBTPReply());
    }


    public void testIsSessionPresent() {
        final IsSessionPresentResponse isSessionPresentResponse = cohesionClient.isSessionPresent();
        logger.info("isSessionPresentResponse: {}", isSessionPresentResponse);
        logger.info("isSessionPresentResponse.isIsSessionPresentResult: {}", isSessionPresentResponse.isIsSessionPresentResult());
    }


    public void run(String... args) {
        getHostReplyTest();
        testIsSessionPresent();
    }

}
