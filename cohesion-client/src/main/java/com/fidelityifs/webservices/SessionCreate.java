
package com.fidelityifs.webservices;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="station" type="{http://fidelityifs.com/webservices}MiserStation" minOccurs="0"/>
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
    "station"
})
@XmlRootElement(name = "SessionCreate")
public class SessionCreate {

    protected MiserStation station;

    /**
     * Gets the value of the station property.
     * 
     * @return
     *     possible object is
     *     {@link MiserStation }
     *     
     */
    public MiserStation getStation() {
        return station;
    }

    /**
     * Sets the value of the station property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiserStation }
     *     
     */
    public void setStation(MiserStation value) {
        this.station = value;
    }

}
