
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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailItem"/>
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
    "emailItem"
})
@XmlRootElement(name = "EmailItems")
public class EmailItems {

    @XmlElement(name = "EmailItem", required = true)
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
