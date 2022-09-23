
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
 *         &lt;element name="SessionGetHostReplyResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "sessionGetHostReplyResult"
})
@XmlRootElement(name = "SessionGetHostReplyResponse")
public class SessionGetHostReplyResponse {

    @XmlElement(name = "SessionGetHostReplyResult")
    protected String sessionGetHostReplyResult;

    /**
     * Gets the value of the sessionGetHostReplyResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionGetHostReplyResult() {
        return sessionGetHostReplyResult;
    }

    /**
     * Sets the value of the sessionGetHostReplyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionGetHostReplyResult(String value) {
        this.sessionGetHostReplyResult = value;
    }

}
