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
        final ObjectFactory objectFactory = new ObjectFactory();
        final GetHostReply hostReply = objectFactory.createGetHostReply();
        final STran sTran = objectFactory.createSTran();
        final MiserXMLInput miserXMLInput = objectFactory.createMiserXMLInput();
        final HeaderData headerData = objectFactory.createHeaderData();

        headerData.setApplicationCode("MS");
        headerData.setTransactionCode("XT$");
        headerData.setPosition(1);
        headerData.setReasonCode("4");
        headerData.setMode("any");
        headerData.setStatus("any");

        miserXMLInput.setHeaderData(headerData);
        miserXMLInput.getInputField().add(createInputField(00462001, "000122012346", "IMT-ACCT-NBR", "Donor Account"));
        miserXMLInput.getInputField().add(createInputField(00461001, "10", "IMT-APPL-CODE", "Donor Application"));
        miserXMLInput.getInputField().add(createInputField(00463001, "000000000100", "IMT-TRAN-AMT", "Transaction Amount"));
        miserXMLInput.getInputField().add(createInputField(00464, null, "IMT-EFF-DT", "Effective Date"));
        miserXMLInput.getInputField().add(createInputField(00462002, "000122012345", "IMT-ACCT-NBR", "Recipient Account"));
        miserXMLInput.getInputField().add(createInputField(00461002, "10", "IMT-APPL-CODE", "Recipient Application"));
        miserXMLInput.getInputField().add(createInputField(00465001, null, "IMT-MISC-ID", "Miscellaneous ID (debit)"));
        miserXMLInput.getInputField().add(createInputField(00466, "test test ", "IMT-DESC", "Description"));
        miserXMLInput.getInputField().add(createInputField(00465002, null, "IMT-MISC-ID", "Miscellaneous ID (credit)"));
        miserXMLInput.getInputField().add(createInputField(00467001, "TFR", "IMT-TRCD-OVR", "Tran Code Indicator 1"));
        miserXMLInput.getInputField().add(createInputField(00467002, "TFR", "IMT-TRCD-OVR", "Tran Code Indicator 2"));
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

    private InputField createInputField(int fieldNbr, String fieldData, String fieldName, String fieldDesc) {
        final ObjectFactory objectFactory = new ObjectFactory();
        final InputField inputField = objectFactory.createInputField();

        inputField.setFieldNbr(fieldNbr);
        inputField.setFieldData(fieldData);
        inputField.setFieldName(fieldName);
        inputField.setFieldDesc(fieldDesc);

        return inputField;
    }
}