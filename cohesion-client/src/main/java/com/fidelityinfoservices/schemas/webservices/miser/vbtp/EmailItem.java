
package com.fidelityinfoservices.schemas.webservices.miser.vbtp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SeqNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FailDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FailCount"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserDefDate"/>
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
    "emailAddr",
    "seqNbr",
    "failDate",
    "failCount",
    "userDefDate"
})
@XmlRootElement(name = "EmailItem")
public class EmailItem {

    @XmlElement(name = "EmailAddr", required = true)
    protected String emailAddr;
    @XmlElement(name = "SeqNbr")
    protected int seqNbr;
    @XmlElement(name = "FailDate", required = true)
    protected String failDate;
    @XmlElement(name = "FailCount")
    protected int failCount;
    @XmlElement(name = "UserDefDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar userDefDate;

    /**
     * Gets the value of the emailAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddr() {
        return emailAddr;
    }

    /**
     * Sets the value of the emailAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddr(String value) {
        this.emailAddr = value;
    }

    /**
     * Gets the value of the seqNbr property.
     * 
     */
    public int getSeqNbr() {
        return seqNbr;
    }

    /**
     * Sets the value of the seqNbr property.
     * 
     */
    public void setSeqNbr(int value) {
        this.seqNbr = value;
    }

    /**
     * Gets the value of the failDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailDate() {
        return failDate;
    }

    /**
     * Sets the value of the failDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailDate(String value) {
        this.failDate = value;
    }

    /**
     * Gets the value of the failCount property.
     * 
     */
    public int getFailCount() {
        return failCount;
    }

    /**
     * Sets the value of the failCount property.
     * 
     */
    public void setFailCount(int value) {
        this.failCount = value;
    }

    /**
     * Gets the value of the userDefDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUserDefDate() {
        return userDefDate;
    }

    /**
     * Sets the value of the userDefDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUserDefDate(XMLGregorianCalendar value) {
        this.userDefDate = value;
    }

}
