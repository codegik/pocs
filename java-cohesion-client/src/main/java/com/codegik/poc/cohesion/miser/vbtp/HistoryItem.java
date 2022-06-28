
package com.codegik.poc.cohesion.miser.vbtp;

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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PostDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranSource"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffectiveDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PostingDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RunningBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DescPart1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DescPart2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DescPart3"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DescPart4"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DescPart5"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistTranType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffHistDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranOpt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DescCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TellerNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrincipalAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}InterestAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LateCharge"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OtherCharge"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}InsCharge"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UnappliedAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MiscCharge"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RunningBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UnappliedBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranHistKey"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranDesc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranPAN"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranTime"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReceiptNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DenialCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ProcessCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}XderAppl"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}XferAcct"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TraceNbr1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}XferCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetItemFee"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DVAdjust"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PostAdjust"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RefType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OtherAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NonBalAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ACHSeqNbr"/>
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
@XmlRootElement(name = "HistoryItem")
public class HistoryItem {

    @XmlElementRefs({
        @XmlElementRef(name = "TranType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DVAdjust", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DescPart4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranPAN", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NonBalAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffectiveDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OtherAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ProcessCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranDesc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetItemFee", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "XferCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InterestAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "XferAcct", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OtherCharge", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DescPart2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrincipalAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DescPart5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranHistKey", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReceiptNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranOpt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ACHSeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UnappliedAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DescPart1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TraceNbr1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranSource", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranTime", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RunningBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffHistDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DueDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistTranType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TellerNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "XderAppl", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PostAdjust", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DenialCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MiscCharge", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LateCharge", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DescCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PostingDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RefType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DescPart3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UnappliedBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InsCharge", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends Serializable>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "TranAmt" is used by two different parts of a schema. See: 
     * line 1077 of file:/Users/iklassman/sources/pocs/cohesion-client/src/main/resources/vbtp_types.xsd
     * line 1072 of file:/Users/iklassman/sources/pocs/cohesion-client/src/main/resources/vbtp_types.xsd
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
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
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
