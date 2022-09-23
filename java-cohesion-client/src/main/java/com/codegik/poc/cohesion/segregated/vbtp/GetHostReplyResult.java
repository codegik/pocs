
package com.codegik.poc.cohesion.segregated.vbtp;

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
 *         &lt;element name="VBTPReply" type="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}VBTPReply" minOccurs="0"/&gt;
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
    "vbtpReply"
})
public class GetHostReplyResult {

    @XmlElement(name = "VBTPReply")
    protected VBTPReply vbtpReply;

    /**
     * Gets the value of the vbtpReply property.
     * 
     * @return
     *     possible object is
     *     {@link VBTPReply }
     *     
     */
    public VBTPReply getVBTPReply() {
        return vbtpReply;
    }

    /**
     * Sets the value of the vbtpReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link VBTPReply }
     *     
     */
    public void setVBTPReply(VBTPReply value) {
        this.vbtpReply = value;
    }

}
