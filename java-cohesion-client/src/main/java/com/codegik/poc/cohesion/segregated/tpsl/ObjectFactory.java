
package com.codegik.poc.cohesion.segregated.tpsl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lendingclub.cohesion.tpsl package. 
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

    private final static QName _Mode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "Mode");
    private final static QName _Status_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "Status");
    private final static QName _FieldNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldNbr");
    private final static QName _FieldData_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldData");
    private final static QName _ApplicationCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "ApplicationCode");
    private final static QName _TransactionCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "TransactionCode");
    private final static QName _Position_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "Position");
    private final static QName _ReasonCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "ReasonCode");
    private final static QName _FieldName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldName");
    private final static QName _FieldDesc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldDesc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lendingclub.cohesion.tpsl
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
     * Create an instance of {@link LogonResponse }
     * 
     */
    public LogonResponse createLogonResponse() {
        return new LogonResponse();
    }

    /**
     * Create an instance of {@link Logoff }
     * 
     */
    public Logoff createLogoff() {
        return new Logoff();
    }

    /**
     * Create an instance of {@link LogoffResponse }
     * 
     */
    public LogoffResponse createLogoffResponse() {
        return new LogoffResponse();
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
     * Create an instance of {@link STran }
     * 
     */
    public STran createSTran() {
        return new STran();
    }

    /**
     * Create an instance of {@link GetHostReplyResponse }
     * 
     */
    public GetHostReplyResponse createGetHostReplyResponse() {
        return new GetHostReplyResponse();
    }

    /**
     * Create an instance of {@link GetHostReplyResult }
     * 
     */
    public GetHostReplyResult createGetHostReplyResult() {
        return new GetHostReplyResult();
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
     * Create an instance of {@link SessionEnd }
     * 
     */
    public SessionEnd createSessionEnd() {
        return new SessionEnd();
    }

    /**
     * Create an instance of {@link SessionEndResponse }
     * 
     */
    public SessionEndResponse createSessionEndResponse() {
        return new SessionEndResponse();
    }

    /**
     * Create an instance of {@link SessionDisconnect }
     * 
     */
    public SessionDisconnect createSessionDisconnect() {
        return new SessionDisconnect();
    }

    /**
     * Create an instance of {@link SessionDisconnectResponse }
     * 
     */
    public SessionDisconnectResponse createSessionDisconnectResponse() {
        return new SessionDisconnectResponse();
    }

    /**
     * Create an instance of {@link SessionGetHostReply }
     * 
     */
    public SessionGetHostReply createSessionGetHostReply() {
        return new SessionGetHostReply();
    }

    /**
     * Create an instance of {@link SessionGetHostReplyResponse }
     * 
     */
    public SessionGetHostReplyResponse createSessionGetHostReplyResponse() {
        return new SessionGetHostReplyResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link FIELD }
     * 
     */
    public FIELD createFIELD() {
        return new FIELD();
    }

    /**
     * Create an instance of {@link HeaderData }
     * 
     */
    public HeaderData createHeaderData() {
        return new HeaderData();
    }

    /**
     * Create an instance of {@link FORMAT }
     * 
     */
    public FORMAT createFORMAT() {
        return new FORMAT();
    }

    /**
     * Create an instance of {@link InputField }
     * 
     */
    public InputField createInputField() {
        return new InputField();
    }

    /**
     * Create an instance of {@link MiserXMLReply }
     * 
     */
    public MiserXMLReply createMiserXMLReply() {
        return new MiserXMLReply();
    }

    /**
     * Create an instance of {@link MiserXMLInput }
     * 
     */
    public MiserXMLInput createMiserXMLInput() {
        return new MiserXMLInput();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "Mode")
    public JAXBElement<String> createMode(String value) {
        return new JAXBElement<String>(_Mode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldNbr")
    public JAXBElement<Integer> createFieldNbr(Integer value) {
        return new JAXBElement<Integer>(_FieldNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldData")
    public JAXBElement<String> createFieldData(String value) {
        return new JAXBElement<String>(_FieldData_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "ApplicationCode")
    public JAXBElement<String> createApplicationCode(String value) {
        return new JAXBElement<String>(_ApplicationCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "TransactionCode")
    public JAXBElement<String> createTransactionCode(String value) {
        return new JAXBElement<String>(_TransactionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "Position")
    public JAXBElement<Integer> createPosition(Integer value) {
        return new JAXBElement<Integer>(_Position_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "ReasonCode")
    public JAXBElement<String> createReasonCode(String value) {
        return new JAXBElement<String>(_ReasonCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldName")
    public JAXBElement<String> createFieldName(String value) {
        return new JAXBElement<String>(_FieldName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldDesc")
    public JAXBElement<String> createFieldDesc(String value) {
        return new JAXBElement<String>(_FieldDesc_QNAME, String.class, null, value);
    }

}
