
package com.codegik.poc.cohesion.segregated.vbtp;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReasonCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FundsType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
@XmlRootElement(name = "Transaction", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
public class Transaction {

    @XmlElement(name = "ApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String applCode;
    @XmlElement(name = "TranCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String tranCode;
    @XmlElement(name = "ReasonCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int reasonCode;
    @XmlElement(name = "FundsType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
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
