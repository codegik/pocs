
package com.codegik.poc.cohesion.miser.tpsl;

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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FieldNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FieldData"/>
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
    "fieldNbr",
    "fieldData"
})
@XmlRootElement(name = "FIELD")
public class FIELD {

    @XmlElement(name = "FieldNbr")
    protected int fieldNbr;
    @XmlElement(name = "FieldData", required = true)
    protected String fieldData;

    /**
     * Gets the value of the fieldNbr property.
     * 
     */
    public int getFieldNbr() {
        return fieldNbr;
    }

    /**
     * Sets the value of the fieldNbr property.
     * 
     */
    public void setFieldNbr(int value) {
        this.fieldNbr = value;
    }

    /**
     * Gets the value of the fieldData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldData() {
        return fieldData;
    }

    /**
     * Sets the value of the fieldData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldData(String value) {
        this.fieldData = value;
    }

}
