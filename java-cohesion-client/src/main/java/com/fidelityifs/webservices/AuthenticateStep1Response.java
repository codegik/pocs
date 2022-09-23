
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
 *         &lt;element name="AuthenticateStep1Result" type="{http://fidelityifs.com/webservices}PreAuthInfo" minOccurs="0"/>
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
    "authenticateStep1Result"
})
@XmlRootElement(name = "AuthenticateStep1Response")
public class AuthenticateStep1Response {

    @XmlElement(name = "AuthenticateStep1Result")
    protected PreAuthInfo authenticateStep1Result;

    /**
     * Gets the value of the authenticateStep1Result property.
     * 
     * @return
     *     possible object is
     *     {@link PreAuthInfo }
     *     
     */
    public PreAuthInfo getAuthenticateStep1Result() {
        return authenticateStep1Result;
    }

    /**
     * Sets the value of the authenticateStep1Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreAuthInfo }
     *     
     */
    public void setAuthenticateStep1Result(PreAuthInfo value) {
        this.authenticateStep1Result = value;
    }

}
