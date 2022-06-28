
package com.codegik.poc.cohesion.webservices;

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
 *         &lt;element name="SessionCreateResult" type="{http://fidelityifs.com/webservices}LogonResult" minOccurs="0"/>
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
    "sessionCreateResult"
})
@XmlRootElement(name = "SessionCreateResponse")
public class SessionCreateResponse {

    @XmlElement(name = "SessionCreateResult")
    protected LogonResult sessionCreateResult;

    /**
     * Gets the value of the sessionCreateResult property.
     * 
     * @return
     *     possible object is
     *     {@link LogonResult }
     *     
     */
    public LogonResult getSessionCreateResult() {
        return sessionCreateResult;
    }

    /**
     * Sets the value of the sessionCreateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogonResult }
     *     
     */
    public void setSessionCreateResult(LogonResult value) {
        this.sessionCreateResult = value;
    }

}
