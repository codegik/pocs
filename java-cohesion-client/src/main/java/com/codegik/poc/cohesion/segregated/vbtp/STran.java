
package com.codegik.poc.cohesion.segregated.vbtp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sTran complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sTran"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VBTPRequest" type="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}VBTPRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sTran", propOrder = {
    "vbtpRequest"
})
public class STran {

    @XmlElement(name = "VBTPRequest")
    protected VBTPRequest vbtpRequest;

    /**
     * Gets the value of the vbtpRequest property.
     * 
     * @return
     *     possible object is
     *     {@link VBTPRequest }
     *     
     */
    public VBTPRequest getVBTPRequest() {
        return vbtpRequest;
    }

    /**
     * Sets the value of the vbtpRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link VBTPRequest }
     *     
     */
    public void setVBTPRequest(VBTPRequest value) {
        this.vbtpRequest = value;
    }

}
