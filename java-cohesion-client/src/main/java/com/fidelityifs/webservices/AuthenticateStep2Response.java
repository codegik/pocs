
package com.fidelityifs.webservices;

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
 *         &lt;element name="AuthenticateStep2Result" type="{http://fidelityifs.com/webservices}LogonResult" minOccurs="0"/>
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
    "authenticateStep2Result"
})
@XmlRootElement(name = "AuthenticateStep2Response")
public class AuthenticateStep2Response {

    @XmlElement(name = "AuthenticateStep2Result")
    protected LogonResult authenticateStep2Result;

    /**
     * Gets the value of the authenticateStep2Result property.
     * 
     * @return
     *     possible object is
     *     {@link LogonResult }
     *     
     */
    public LogonResult getAuthenticateStep2Result() {
        return authenticateStep2Result;
    }

    /**
     * Sets the value of the authenticateStep2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogonResult }
     *     
     */
    public void setAuthenticateStep2Result(LogonResult value) {
        this.authenticateStep2Result = value;
    }

}
