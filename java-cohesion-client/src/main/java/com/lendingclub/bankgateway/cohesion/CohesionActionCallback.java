package com.lendingclub.bankgateway.cohesion;

import org.springframework.ws.soap.client.core.SoapActionCallback;

public enum CohesionActionCallback {
    GET_HOST_REPLY(new SoapActionCallback("http://fidelityifs.com/webservices/GetHostReply")),
    IS_SESSION_PRESENT(new SoapActionCallback("http://fidelityifs.com/webservices/IsSessionPresent")),
    LOGON(new SoapActionCallback("http://fidelityifs.com/webservices/Logon"));

    private SoapActionCallback soapActionCallback;

    CohesionActionCallback(SoapActionCallback soapActionCallback) {
        this.soapActionCallback = soapActionCallback;
    }

    public SoapActionCallback callback() {
        return soapActionCallback;
    }
}
