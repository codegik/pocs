
package com.codegik.poc.cohesion.segregated.tpsl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetHostReplyResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetHostReplyResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MiserXMLReply" type="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}MiserXMLReply" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHostReplyResult", propOrder = {
    "miserXMLReply"
})
public class GetHostReplyResult {

    @XmlElement(name = "MiserXMLReply")
    protected MiserXMLReply miserXMLReply;

    /**
     * Gets the value of the miserXMLReply property.
     * 
     * @return
     *     possible object is
     *     {@link MiserXMLReply }
     *     
     */
    public MiserXMLReply getMiserXMLReply() {
        return miserXMLReply;
    }

    /**
     * Sets the value of the miserXMLReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiserXMLReply }
     *     
     */
    public void setMiserXMLReply(MiserXMLReply value) {
        this.miserXMLReply = value;
    }

}
