
package com.codegik.poc.cohesion.miser.tpsl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codegik.poc.cohesion.miser.tpsl package.
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

    private final static QName _FieldName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldName");
    private final static QName _FieldDesc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldDesc");
    private final static QName _Status_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "Status");
    private final static QName _Mode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "Mode");
    private final static QName _FieldData_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldData");
    private final static QName _Position_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "Position");
    private final static QName _ApplicationCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "ApplicationCode");
    private final static QName _FieldNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "FieldNbr");
    private final static QName _TransactionCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "TransactionCode");
    private final static QName _ReasonCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", "ReasonCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codegik.poc.cohesion.miser.tpsl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputField }
     * 
     */
    public InputField createInputField() {
        return new InputField();
    }

    /**
     * Create an instance of {@link FORMAT }
     * 
     */
    public FORMAT createFORMAT() {
        return new FORMAT();
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
     * Create an instance of {@link MiserXMLInput }
     * 
     */
    public MiserXMLInput createMiserXMLInput() {
        return new MiserXMLInput();
    }

    /**
     * Create an instance of {@link MiserXMLReply }
     * 
     */
    public MiserXMLReply createMiserXMLReply() {
        return new MiserXMLReply();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldName")
    public JAXBElement<String> createFieldName(String value) {
        return new JAXBElement<String>(_FieldName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldDesc")
    public JAXBElement<String> createFieldDesc(String value) {
        return new JAXBElement<String>(_FieldDesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "Mode")
    public JAXBElement<String> createMode(String value) {
        return new JAXBElement<String>(_Mode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldData")
    public JAXBElement<String> createFieldData(String value) {
        return new JAXBElement<String>(_FieldData_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "Position")
    public JAXBElement<Integer> createPosition(Integer value) {
        return new JAXBElement<Integer>(_Position_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "ApplicationCode")
    public JAXBElement<String> createApplicationCode(String value) {
        return new JAXBElement<String>(_ApplicationCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "FieldNbr")
    public JAXBElement<Integer> createFieldNbr(Integer value) {
        return new JAXBElement<Integer>(_FieldNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "TransactionCode")
    public JAXBElement<String> createTransactionCode(String value) {
        return new JAXBElement<String>(_TransactionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", name = "ReasonCode")
    public JAXBElement<String> createReasonCode(String value) {
        return new JAXBElement<String>(_ReasonCode_QNAME, String.class, null, value);
    }

}
