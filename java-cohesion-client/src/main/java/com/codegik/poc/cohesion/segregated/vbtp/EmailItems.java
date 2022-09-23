
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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailItem"/&gt;
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
    "emailItem"
})
@XmlRootElement(name = "EmailItems", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
public class EmailItems {

    @XmlElement(name = "EmailItem", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected EmailItem emailItem;

    /**
     * Gets the value of the emailItem property.
     * 
     * @return
     *     possible object is
     *     {@link EmailItem }
     *     
     */
    public EmailItem getEmailItem() {
        return emailItem;
    }

    /**
     * Sets the value of the emailItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailItem }
     *     
     */
    public void setEmailItem(EmailItem value) {
        this.emailItem = value;
    }

}
