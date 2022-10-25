
package com.lendingclub.bankgateway.cohesion.soap;

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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}Mode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}Status"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}ApplicationCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}TransactionCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}Position"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}ReasonCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FundType"/&gt;
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
    "mode",
    "status",
    "applicationCode",
    "transactionCode",
    "position",
    "reasonCode",
    "fundType"
})
@XmlRootElement(name = "HeaderData", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl")
public class HeaderData {

    @XmlElement(name = "Mode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
    protected String mode;
    @XmlElement(name = "Status", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
    protected String status;
    @XmlElement(name = "ApplicationCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
    protected String applicationCode;
    @XmlElement(name = "TransactionCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
    protected String transactionCode;
    @XmlElement(name = "Position", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl")
    protected int position;
    @XmlElement(name = "ReasonCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
    protected String reasonCode;
    @XmlElement(name = "FundType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
    protected String fundType;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the applicationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     * Sets the value of the applicationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationCode(String value) {
        this.applicationCode = value;
    }

    /**
     * Gets the value of the transactionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionCode() {
        return transactionCode;
    }

    /**
     * Sets the value of the transactionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionCode(String value) {
        this.transactionCode = value;
    }

    /**
     * Gets the value of the position property.
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     */
    public void setPosition(int value) {
        this.position = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }



    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }
}
