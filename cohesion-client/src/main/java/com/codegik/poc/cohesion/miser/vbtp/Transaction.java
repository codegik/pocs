
package com.codegik.poc.cohesion.miser.vbtp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReasonCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FundsType"/>
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
    "applCode",
    "tranCode",
    "reasonCode",
    "fundsType"
})
@XmlRootElement(name = "Transaction")
public class Transaction {

    @XmlElement(name = "ApplCode", required = true)
    protected String applCode;
    @XmlElement(name = "TranCode", required = true)
    protected String tranCode;
    @XmlElement(name = "ReasonCode")
    protected int reasonCode;
    @XmlElement(name = "FundsType")
    protected int fundsType;

    /**
     * Gets the value of the applCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplCode() {
        return applCode;
    }

    /**
     * Sets the value of the applCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplCode(String value) {
        this.applCode = value;
    }

    /**
     * Gets the value of the tranCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranCode() {
        return tranCode;
    }

    /**
     * Sets the value of the tranCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranCode(String value) {
        this.tranCode = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     */
    public int getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     */
    public void setReasonCode(int value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the fundsType property.
     * 
     */
    public int getFundsType() {
        return fundsType;
    }

    /**
     * Sets the value of the fundsType property.
     * 
     */
    public void setFundsType(int value) {
        this.fundsType = value;
    }

}
