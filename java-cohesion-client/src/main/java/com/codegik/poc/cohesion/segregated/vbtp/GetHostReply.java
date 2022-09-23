
package com.codegik.poc.cohesion.segregated.vbtp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="sTran" type="{http://fidelityifs.com/webservices}sTran" minOccurs="0"/&gt;
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
    "sTran"
})
@XmlRootElement(name = "GetHostReply")
public class GetHostReply {

    protected STran sTran;

    /**
     * Gets the value of the sTran property.
     * 
     * @return
     *     possible object is
     *     {@link STran }
     *     
     */
    public STran getSTran() {
        return sTran;
    }

    /**
     * Sets the value of the sTran property.
     * 
     * @param value
     *     allowed object is
     *     {@link STran }
     *     
     */
    public void setSTran(STran value) {
        this.sTran = value;
    }

}
