
package com.fidelityifs.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fidelityifs.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuthHeader_QNAME = new QName("http://fidelityifs.com/webservices", "AuthHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fidelityifs.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Logon }
     * 
     */
    public Logon createLogon() {
        return new Logon();
    }

    /**
     * Create an instance of {@link GetHostReplyResponse }
     * 
     */
    public GetHostReplyResponse createGetHostReplyResponse() {
        return new GetHostReplyResponse();
    }

    /**
     * Create an instance of {@link SessionCreateResponse }
     * 
     */
    public SessionCreateResponse createSessionCreateResponse() {
        return new SessionCreateResponse();
    }

    /**
     * Create an instance of {@link LogonResult }
     * 
     */
    public LogonResult createLogonResult() {
        return new LogonResult();
    }

    /**
     * Create an instance of {@link SessionEndResponse }
     * 
     */
    public SessionEndResponse createSessionEndResponse() {
        return new SessionEndResponse();
    }

    /**
     * Create an instance of {@link AuthHeader }
     * 
     */
    public AuthHeader createAuthHeader() {
        return new AuthHeader();
    }

    /**
     * Create an instance of {@link AuthenticateStep2 }
     * 
     */
    public AuthenticateStep2 createAuthenticateStep2() {
        return new AuthenticateStep2();
    }

    /**
     * Create an instance of {@link LogonResponse }
     * 
     */
    public LogonResponse createLogonResponse() {
        return new LogonResponse();
    }

    /**
     * Create an instance of {@link SessionCreate }
     * 
     */
    public SessionCreate createSessionCreate() {
        return new SessionCreate();
    }

    /**
     * Create an instance of {@link MiserStation }
     * 
     */
    public MiserStation createMiserStation() {
        return new MiserStation();
    }

    /**
     * Create an instance of {@link SessionGetHostReplyResponse }
     * 
     */
    public SessionGetHostReplyResponse createSessionGetHostReplyResponse() {
        return new SessionGetHostReplyResponse();
    }

    /**
     * Create an instance of {@link AuthenticateStep1 }
     * 
     */
    public AuthenticateStep1 createAuthenticateStep1() {
        return new AuthenticateStep1();
    }

    /**
     * Create an instance of {@link AuthenticateStep1Response }
     * 
     */
    public AuthenticateStep1Response createAuthenticateStep1Response() {
        return new AuthenticateStep1Response();
    }

    /**
     * Create an instance of {@link PreAuthInfo }
     * 
     */
    public PreAuthInfo createPreAuthInfo() {
        return new PreAuthInfo();
    }

    /**
     * Create an instance of {@link AuthenticateStep2Response }
     * 
     */
    public AuthenticateStep2Response createAuthenticateStep2Response() {
        return new AuthenticateStep2Response();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link LogoffResponse }
     * 
     */
    public LogoffResponse createLogoffResponse() {
        return new LogoffResponse();
    }

    /**
     * Create an instance of {@link SessionGetHostReply }
     * 
     */
    public SessionGetHostReply createSessionGetHostReply() {
        return new SessionGetHostReply();
    }

    /**
     * Create an instance of {@link IsSessionPresent }
     * 
     */
    public IsSessionPresent createIsSessionPresent() {
        return new IsSessionPresent();
    }

    /**
     * Create an instance of {@link IsSessionPresentResponse }
     * 
     */
    public IsSessionPresentResponse createIsSessionPresentResponse() {
        return new IsSessionPresentResponse();
    }

    /**
     * Create an instance of {@link GetHostReply }
     * 
     */
    public GetHostReply createGetHostReply() {
        return new GetHostReply();
    }

    /**
     * Create an instance of {@link Logoff }
     * 
     */
    public Logoff createLogoff() {
        return new Logoff();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link SessionDisconnect }
     * 
     */
    public SessionDisconnect createSessionDisconnect() {
        return new SessionDisconnect();
    }

    /**
     * Create an instance of {@link SessionEnd }
     * 
     */
    public SessionEnd createSessionEnd() {
        return new SessionEnd();
    }

    /**
     * Create an instance of {@link SessionDisconnectResponse }
     * 
     */
    public SessionDisconnectResponse createSessionDisconnectResponse() {
        return new SessionDisconnectResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fidelityifs.com/webservices", name = "AuthHeader")
    public JAXBElement<AuthHeader> createAuthHeader(AuthHeader value) {
        return new JAXBElement<AuthHeader>(_AuthHeader_QNAME, AuthHeader.class, null, value);
    }

}
