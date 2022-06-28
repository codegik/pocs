
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
 *         &lt;element name="IsSessionPresentResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isSessionPresentResult"
})
@XmlRootElement(name = "IsSessionPresentResponse")
public class IsSessionPresentResponse {

    @XmlElement(name = "IsSessionPresentResult")
    protected boolean isSessionPresentResult;

    /**
     * Gets the value of the isSessionPresentResult property.
     * 
     */
    public boolean isIsSessionPresentResult() {
        return isSessionPresentResult;
    }

    /**
     * Sets the value of the isSessionPresentResult property.
     * 
     */
    public void setIsSessionPresentResult(boolean value) {
        this.isSessionPresentResult = value;
    }

}
