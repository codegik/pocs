
package com.lendingclub.bankgateway.cohesion.soap;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailAddr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SeqNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FailDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FailCount"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserDefDate"/&gt;
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
    "emailAddr",
    "seqNbr",
    "failDate",
    "failCount",
    "userDefDate"
})
@XmlRootElement(name = "EmailItem", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
public class EmailItem {

    @XmlElement(name = "EmailAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String emailAddr;
    @XmlElement(name = "SeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int seqNbr;
    @XmlElement(name = "FailDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String failDate;
    @XmlElement(name = "FailCount", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int failCount;
    @XmlElement(name = "UserDefDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
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
