
package com.codegik.poc.cohesion.segregated.tpsl;

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
 *         &lt;element name="MiserXMLInput" type="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}MiserXMLInput" minOccurs="0"/&gt;
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
    "miserXMLInput"
})
public class STran {

    @XmlElement(name = "MiserXMLInput")
    protected MiserXMLInput miserXMLInput;

    /**
     * Gets the value of the miserXMLInput property.
     * 
     * @return
     *     possible object is
     *     {@link MiserXMLInput }
     *     
     */
    public MiserXMLInput getMiserXMLInput() {
        return miserXMLInput;
    }

    /**
     * Sets the value of the miserXMLInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiserXMLInput }
     *     
     */
    public void setMiserXMLInput(MiserXMLInput value) {
        this.miserXMLInput = value;
    }

}
