
package com.fidelityinfoservices.schemas.webservices.miser.vbtp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CFMCustNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CFMCustNbrType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccountNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SelectionOpt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaxHistReply"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumHistTran"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranTypeOpt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ContinuationFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoData"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailSeq"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistorySeqNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EditAction"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ContactType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PhoneNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PhoneType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ConsentCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NoSolInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StartDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EndDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DateSelection"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetSeqInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReturnSeq"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}VBRInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranOptCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ServicerNumber1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplicationCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ServicerAccountNumber1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Amount"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplicationCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ServicerAccountNumber2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Description"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ActionCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DeliveryAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AddtlAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}City"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}State"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ZipCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Country"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ServicerNbr1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccountNbr1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ServicerNbr2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccountNbr2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Description"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCode2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReasonCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReasonCode2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DepositYearInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ContributionCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CheckNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CheckNbrorAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SelectionInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Reason"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Payee"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PAN"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PANType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "Parameters")
public class Parameters {

    @XmlElementRefs({
        @XmlElementRef(name = "Amount", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContactType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PhoneType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TaxType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ActionCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EndDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReasonCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DepositYearInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailSeq", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Country", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccountNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumHistTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EditAction", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServicerAccountNumber1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranTypeOpt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Reason", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AddtlAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Description", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Payee", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DateSelection", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServicerNbr2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServicerAccountNumber2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoData", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ZipCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccountNbr2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContributionCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CheckNbrorAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "State", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaxHistReply", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplicationCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeliveryAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReasonCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranOptCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PANType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CFMCustNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VBRInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SelectionInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplicationCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NoSolInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistorySeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CFMCustNbrType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReturnSeq", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServicerNbr1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetSeqInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PAN", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SelectionOpt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "City", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccountNbr1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CheckNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PhoneNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContinuationFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServicerNumber1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends Serializable>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Description" is used by two different parts of a schema. See: 
     * line 693 of file:/Users/iklassman/sources/pocs/cohesion-client/src/main/resources/vbtp_types.xsd
     * line 673 of file:/Users/iklassman/sources/pocs/cohesion-client/src/main/resources/vbtp_types.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Serializable>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<? extends Serializable>>();
        }
        return this.content;
    }

}
