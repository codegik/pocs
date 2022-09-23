
package com.codegik.poc.cohesion.segregated.tpsl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for MiserXMLReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MiserXMLReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}HeaderData"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FORMAT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/tpsl}FIELD"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MiserXMLReply", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/tpsl", propOrder = {
    "headerData",
    "format",
    "field"
})
public class MiserXMLReply {

    @XmlElement(name = "HeaderData", required = true)
    protected HeaderData headerData;
    @XmlElement(name = "FORMAT")
    protected List<FORMAT> format;
    @XmlElement(name = "FIELD", required = true)
    protected FIELD field;

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
     * Gets the value of the format property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the format property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFORMAT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FORMAT }
     * 
     * 
     */
    public List<FORMAT> getFORMAT() {
        if (format == null) {
            format = new ArrayList<FORMAT>();
        }
        return this.format;
    }

    /**
     * Gets the value of the field property.
     * 
     * @return
     *     possible object is
     *     {@link FIELD }
     *     
     */
    public FIELD getFIELD() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIELD }
     *     
     */
    public void setFIELD(FIELD value) {
        this.field = value;
    }

}
