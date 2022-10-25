
package com.lendingclub.bankgateway.cohesion.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VBTPRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VBTPRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Transaction"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Parameters"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VBTPRequest", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", propOrder = {
    "transaction",
    "parameters"
})
public class VBTPRequest {

    @XmlElement(name = "Transaction", required = true)
    protected Transaction transaction;
    @XmlElement(name = "Parameters", required = true)
    protected Parameters parameters;

    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link Transaction }
     *     
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transaction }
     *     
     */
    public void setTransaction(Transaction value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link Parameters }
     *     
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *     
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

}
