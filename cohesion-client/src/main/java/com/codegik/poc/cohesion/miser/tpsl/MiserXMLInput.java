
package com.codegik.poc.cohesion.miser.tpsl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MiserXMLInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MiserXMLInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}HeaderData"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}InputField" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MiserXMLInput", propOrder = {
    "headerData",
    "inputField"
})
public class MiserXMLInput {

    @XmlElement(name = "HeaderData", required = true)
    protected HeaderData headerData;
    @XmlElement(name = "InputField")
    protected List<InputField> inputField;

    /**
     * Gets the value of the headerData property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderData }
     *     
     */
    public HeaderData getHeaderData() {
        return headerData;
    }

    /**
     * Sets the value of the headerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderData }
     *     
     */
    public void setHeaderData(HeaderData value) {
        this.headerData = value;
    }

    /**
     * Gets the value of the inputField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputField }
     * 
     * 
     */
    public List<InputField> getInputField() {
        if (inputField == null) {
            inputField = new ArrayList<InputField>();
        }
        return this.inputField;
    }

}
