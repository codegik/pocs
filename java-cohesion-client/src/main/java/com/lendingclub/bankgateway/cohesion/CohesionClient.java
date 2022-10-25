package com.lendingclub.bankgateway.cohesion;

import com.lendingclub.bankgateway.cohesion.soap.GetHostReply;
import com.lendingclub.bankgateway.cohesion.soap.GetHostReplyResponse;
import com.lendingclub.bankgateway.cohesion.soap.IsSessionPresent;
import com.lendingclub.bankgateway.cohesion.soap.IsSessionPresentResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import static com.lendingclub.bankgateway.cohesion.CohesionActionCallback.GET_HOST_REPLY;
import static com.lendingclub.bankgateway.cohesion.CohesionActionCallback.IS_SESSION_PRESENT;


public class CohesionClient extends WebServiceGatewaySupport {

    public GetHostReplyResponse getHostReply(GetHostReply hostReply) {
        return (GetHostReplyResponse) getWebServiceTemplate().marshalSendAndReceive(hostReply, GET_HOST_REPLY.callback());
    }


    public IsSessionPresentResponse isSessionPresent() {
        return (IsSessionPresentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(new IsSessionPresent(), IS_SESSION_PRESENT.callback());
    }

}
