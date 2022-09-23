
package com.codegik.poc.cohesion.segregated.tpsl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MiserStation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MiserStation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TellerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PostingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DailyVariableDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Pin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CashBoxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeginningCash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MiserStation", propOrder = {
    "stationName",
    "tellerNumber",
    "postingDate",
    "dailyVariableDate",
    "pin",
    "cashBoxNumber",
    "beginningCash"
})
public class MiserStation {

    @XmlElement(name = "StationName")
    protected String stationName;
    @XmlElement(name = "TellerNumber")
    protected String tellerNumber;
    @XmlElement(name = "PostingDate")
    protected String postingDate;
    @XmlElement(name = "DailyVariableDate")
    protected String dailyVariableDate;
    @XmlElement(name = "Pin")
    protected String pin;
    @XmlElement(name = "CashBoxNumber")
    protected String cashBoxNumber;
    @XmlElement(name = "BeginningCash")
    protected String beginningCash;

    /**
     * Gets the value of the stationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Sets the value of the stationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationName(String value) {
        this.stationName = value;
    }

    /**
     * Gets the value of the tellerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTellerNumber() {
        return tellerNumber;
    }

    /**
     * Sets the value of the tellerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTellerNumber(String value) {
        this.tellerNumber = value;
    }

    /**
     * Gets the value of the postingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingDate() {
        return postingDate;
    }

    /**
     * Sets the value of the postingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingDate(String value) {
        this.postingDate = value;
    }

    /**
     * Gets the value of the dailyVariableDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDailyVariableDate() {
        return dailyVariableDate;
    }

    /**
     * Sets the value of the dailyVariableDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDailyVariableDate(String value) {
        this.dailyVariableDate = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin(String value) {
        this.pin = value;
    }

    /**
     * Gets the value of the cashBoxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashBoxNumber() {
        return cashBoxNumber;
    }

    /**
     * Sets the value of the cashBoxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashBoxNumber(String value) {
        this.cashBoxNumber = value;
    }

    /**
     * Gets the value of the beginningCash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginningCash() {
        return beginningCash;
    }

    /**
     * Sets the value of the beginningCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginningCash(String value) {
        this.beginningCash = value;
    }

}
