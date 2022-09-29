package com.codegik.poc.cohesion.spring;

import com.codegik.poc.cohesion.segregated.tpsl.GetHostReply;
import com.codegik.poc.cohesion.segregated.tpsl.GetHostReplyResponse;
import com.codegik.poc.cohesion.segregated.tpsl.HeaderData;
import com.codegik.poc.cohesion.segregated.tpsl.InputField;
import com.codegik.poc.cohesion.segregated.tpsl.IsSessionPresentResponse;
import com.codegik.poc.cohesion.segregated.tpsl.Logon;
import com.codegik.poc.cohesion.segregated.tpsl.LogonResponse;
import com.codegik.poc.cohesion.segregated.tpsl.MiserXMLInput;
import com.codegik.poc.cohesion.segregated.tpsl.ObjectFactory;
import com.codegik.poc.cohesion.segregated.tpsl.STran;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TPSLCohesionClient extends WebServiceGatewaySupport {
    private final ObjectFactory objectFactory = new ObjectFactory();

    public GetHostReplyResponse getHostReply(String url) {
        final GetHostReply hostReply = objectFactory.createGetHostReply();
        final STran sTran = objectFactory.createSTran();
        final MiserXMLInput miserXMLInput = objectFactory.createMiserXMLInput();
        final HeaderData headerData = objectFactory.createHeaderData();

        headerData.setApplicationCode("MS");
        headerData.setTransactionCode("XT$");
        headerData.setPosition(1);

        miserXMLInput.setHeaderData(headerData);
        miserXMLInput.getInputField().add(buildInputField(00462001, "000122012346"));
        miserXMLInput.getInputField().add(buildInputField(00461001, "10"));
        miserXMLInput.getInputField().add(buildInputField(00463001, "000000000100"));
        miserXMLInput.getInputField().add(buildInputField(00464, null));
        miserXMLInput.getInputField().add(buildInputField(00462002, "000122012345"));
        miserXMLInput.getInputField().add(buildInputField(00461002, "10"));
        miserXMLInput.getInputField().add(buildInputField(00465001, null));
        miserXMLInput.getInputField().add(buildInputField(00466, "test test "));
        miserXMLInput.getInputField().add(buildInputField(00465002, null));
        miserXMLInput.getInputField().add(buildInputField(00467001, null));
        miserXMLInput.getInputField().add(buildInputField(00467002, null));

        sTran.setMiserXMLInput(miserXMLInput);

        hostReply.setSTran(sTran);

        return (GetHostReplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(url, hostReply, new SoapActionCallback(
                        "http://fidelityifs.com/webservices/GetHostReply"));
    }

    public IsSessionPresentResponse isSessionPresent(String url) {
        return (IsSessionPresentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(url, objectFactory.createIsSessionPresent(), new SoapActionCallback(
                        "http://fidelityifs.com/webservices/IsSessionPresent"));
    }

    public LogonResponse logon(String url) {
        Logon logon = objectFactory.createLogon();

        logon.setPin("pin");
        logon.setCashBoxNbr("32");
        logon.setStationName("myName");
        logon.setTellerNbr("343443");

        return (LogonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(url, logon, new SoapActionCallback(
                        "http://fidelityifs.com/webservices/Logon"));
    }

    private InputField buildInputField(int fieldNbr, String fieldData) {
        final InputField inputField = objectFactory.createInputField();

        inputField.setFieldNbr(fieldNbr);
        inputField.setFieldData(fieldData);

        return inputField;
    }
}