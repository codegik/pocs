package com.codegik.poc.cohesion.spring;

import com.codegik.poc.cohesion.segregated.vbtp.GetHostReply;
import com.codegik.poc.cohesion.segregated.vbtp.GetHostReplyResponse;
import com.codegik.poc.cohesion.segregated.vbtp.ObjectFactory;
import com.codegik.poc.cohesion.segregated.vbtp.STran;
import com.codegik.poc.cohesion.segregated.vbtp.VBTPRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class VBTPCohesionClient extends WebServiceGatewaySupport {

    public GetHostReplyResponse getHostReply(String url) {
        final ObjectFactory objectFactory = new ObjectFactory();
        final GetHostReply hostReply = objectFactory.createGetHostReply();
        final STran sTran = objectFactory.createSTran();
        final VBTPRequest vbtpRequest = objectFactory.createVBTPRequest();

        sTran.setVBTPRequest(vbtpRequest);
        hostReply.setSTran(sTran);

        return (GetHostReplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(url, hostReply, new SoapActionCallback(
                        "http://fidelityifs.com/webservices/GetHostReply"));
    }
}