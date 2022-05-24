
package com.fidelityifs.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.fidelityinfoservices.schemas.webservices.miser.tpsl.MiserXMLInput;
import com.fidelityinfoservices.schemas.webservices.miser.vbtp.VBTPRequest;


/**
 * <p>Java class for sTran complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sTran">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VBTPRequest" type="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}VBTPRequest" minOccurs="0"/>
 *         &lt;element name="MiserXMLInput" type="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}MiserXMLInput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sTran", propOrder = {
    "vbtpRequest",
    "miserXMLInput"
})
public class STran {

    @XmlElement(name = "VBTPRequest")
    protected VBTPRequest vbtpRequest;
    @XmlElement(name = "MiserXMLInput")
    protected MiserXMLInput miserXMLInput;

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
