
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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FieldNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FieldData"/&gt;
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
    "fieldNbr",
    "fieldData"
})
@XmlRootElement(name = "FIELD", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl")
public class FIELD {

    @XmlElement(name = "FieldNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl")
    protected int fieldNbr;
    @XmlElement(name = "FieldData", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", required = true)
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
