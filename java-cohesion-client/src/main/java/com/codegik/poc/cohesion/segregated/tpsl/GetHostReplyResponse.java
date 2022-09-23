
package com.codegik.poc.cohesion.segregated.tpsl;

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
 *         &lt;element name="GetHostReplyResult" type="{http://fidelityifs.com/webservices}GetHostReplyResult" minOccurs="0"/&gt;
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
    "getHostReplyResult"
})
@XmlRootElement(name = "GetHostReplyResponse")
public class GetHostReplyResponse {

    @XmlElement(name = "GetHostReplyResult")
    protected GetHostReplyResult getHostReplyResult;

    /**
     * Gets the value of the getHostReplyResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetHostReplyResult }
     *     
     */
    public GetHostReplyResult getGetHostReplyResult() {
        return getHostReplyResult;
    }

    /**
     * Sets the value of the getHostReplyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetHostReplyResult }
     *     
     */
    public void setGetHostReplyResult(GetHostReplyResult value) {
        this.getHostReplyResult = value;
    }

}
