
package com.fidelityifs.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.fidelityinfoservices.schemas.webservices.miser.tpsl.MiserXMLReply;
import com.fidelityinfoservices.schemas.webservices.miser.vbtp.VBTPReply;


/**
 * <p>Java class for GetHostReplyResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetHostReplyResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VBTPReply" type="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}VBTPReply" minOccurs="0"/>
 *         &lt;element name="MiserXMLReply" type="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}MiserXMLReply" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHostReplyResult", propOrder = {
    "vbtpReply",
    "miserXMLReply"
})
public class GetHostReplyResult {

    @XmlElement(name = "VBTPReply")
    protected VBTPReply vbtpReply;
    @XmlElement(name = "MiserXMLReply")
    protected MiserXMLReply miserXMLReply;

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
