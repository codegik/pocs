package com.codegik.poc.cohesion.spring;

import com.codegik.poc.cohesion.segregated.vbtp.GetHostReply;
import com.codegik.poc.cohesion.segregated.vbtp.GetHostReplyResponse;
import com.codegik.poc.cohesion.segregated.vbtp.ObjectFactory;
import com.codegik.poc.cohesion.segregated.vbtp.Parameters;
import com.codegik.poc.cohesion.segregated.vbtp.STran;
import com.codegik.poc.cohesion.segregated.vbtp.Transaction;
import com.codegik.poc.cohesion.segregated.vbtp.VBTPRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class VBTPCohesionClient extends WebServiceGatewaySupport {

    public GetHostReplyResponse getHostReply(String url) {
        final ObjectFactory objectFactory = new ObjectFactory();
        final GetHostReply hostReply = objectFactory.createGetHostReply();
        final STran sTran = objectFactory.createSTran();
        final VBTPRequest vbtpRequest = objectFactory.createVBTPRequest();
        final Transaction transaction = objectFactory.createTransaction();
        final Parameters parameters = objectFactory.createParameters();
        final String namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp";

        transaction.setApplCode("CF");
        transaction.setTranCode("CS2");
        transaction.setReasonCode(00);

        parameters.getContent().add(new JAXBElement(new QName(namespace, "CFMCustNbr"), JAXBElement.class, 3093723));
        parameters.getContent().add(new JAXBElement(new QName(namespace, "CFMCustNbrType"), JAXBElement.class, null));
        parameters.getContent().add(new JAXBElement(new QName(namespace, "ContinuationFlag"), JAXBElement.class, null));
        parameters.getContent().add(new JAXBElement(new QName(namespace, "EchoData"), JAXBElement.class, null));
        parameters.getContent().add(new JAXBElement(new QName(namespace, "TaxType"), JAXBElement.class, null));
        parameters.getContent().add(new JAXBElement(new QName(namespace, "VBRInd"), JAXBElement.class, null));

        vbtpRequest.setTransaction(transaction);
        vbtpRequest.setParameters(parameters);

        sTran.setVBTPRequest(vbtpRequest);

        hostReply.setSTran(sTran);

        return (GetHostReplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(url, hostReply, new SoapActionCallback(
                        "http://fidelityifs.com/webservices/GetHostReply"));
    }
}