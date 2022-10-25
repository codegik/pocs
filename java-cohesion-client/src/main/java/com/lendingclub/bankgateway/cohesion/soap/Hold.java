
package com.lendingclub.bankgateway.cohesion.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ExpireDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PlacedDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Reasoncode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Branch"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Teller"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PlacedTime"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PlacedTranDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LocationCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TraceNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HoldType"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HoldName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReceiptNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Merchant"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}City"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StateCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CountryCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PAN"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PreauthOrDebitHld"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AddtlInfo"/&gt;
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
    "holdAmt",
    "expireDate",
    "placedDate",
    "reasoncode",
    "branch",
    "teller",
    "placedTime",
    "placedTranDate",
    "locationCode",
    "traceNbr",
    "holdType",
    "holdName",
    "receiptNbr",
    "merchant",
    "city",
    "stateCode",
    "countryCode",
    "pan",
    "preauthOrDebitHld",
    "addtlInfo"
})
@XmlRootElement(name = "Hold", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
public class Hold {

    @XmlElement(name = "HoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected BigDecimal holdAmt;
    @XmlElement(name = "ExpireDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String expireDate;
    @XmlElement(name = "PlacedDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String placedDate;
    @XmlElement(name = "Reasoncode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int reasoncode;
    @XmlElement(name = "Branch", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int branch;
    @XmlElement(name = "Teller", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int teller;
    @XmlElement(name = "PlacedTime", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String placedTime;
    @XmlElement(name = "PlacedTranDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String placedTranDate;
    @XmlElement(name = "LocationCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String locationCode;
    @XmlElement(name = "TraceNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String traceNbr;
    @XmlElement(name = "HoldType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp")
    protected int holdType;
    @XmlElement(name = "HoldName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String holdName;
    @XmlElement(name = "ReceiptNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String receiptNbr;
    @XmlElement(name = "Merchant", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String merchant;
    @XmlElement(name = "City", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String city;
    @XmlElement(name = "StateCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String stateCode;
    @XmlElement(name = "CountryCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String countryCode;
    @XmlElement(name = "PAN", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String pan;
    @XmlElement(name = "PreauthOrDebitHld", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String preauthOrDebitHld;
    @XmlElement(name = "AddtlInfo", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", required = true)
    protected String addtlInfo;

    /**
     * Gets the value of the holdAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHoldAmt() {
        return holdAmt;
    }

    /**
     * Sets the value of the holdAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHoldAmt(BigDecimal value) {
        this.holdAmt = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpireDate(String value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the placedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacedDate() {
        return placedDate;
    }

    /**
     * Sets the value of the placedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacedDate(String value) {
        this.placedDate = value;
    }

    /**
     * Gets the value of the reasoncode property.
     * 
     */
    public int getReasoncode() {
        return reasoncode;
    }

    /**
     * Sets the value of the reasoncode property.
     * 
     */
    public void setReasoncode(int value) {
        this.reasoncode = value;
    }

    /**
     * Gets the value of the branch property.
     * 
     */
    public int getBranch() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     */
    public void setBranch(int value) {
        this.branch = value;
    }

    /**
     * Gets the value of the teller property.
     * 
     */
    public int getTeller() {
        return teller;
    }

    /**
     * Sets the value of the teller property.
     * 
     */
    public void setTeller(int value) {
        this.teller = value;
    }

    /**
     * Gets the value of the placedTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacedTime() {
        return placedTime;
    }

    /**
     * Sets the value of the placedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacedTime(String value) {
        this.placedTime = value;
    }

    /**
     * Gets the value of the placedTranDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacedTranDate() {
        return placedTranDate;
    }

    /**
     * Sets the value of the placedTranDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacedTranDate(String value) {
        this.placedTranDate = value;
    }

    /**
     * Gets the value of the locationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * Sets the value of the locationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCode(String value) {
        this.locationCode = value;
    }

    /**
     * Gets the value of the traceNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraceNbr() {
        return traceNbr;
    }

    /**
     * Sets the value of the traceNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraceNbr(String value) {
        this.traceNbr = value;
    }

    /**
     * Gets the value of the holdType property.
     * 
     */
    public int getHoldType() {
        return holdType;
    }

    /**
     * Sets the value of the holdType property.
     * 
     */
    public void setHoldType(int value) {
        this.holdType = value;
    }

    /**
     * Gets the value of the holdName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldName() {
        return holdName;
    }

    /**
     * Sets the value of the holdName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldName(String value) {
        this.holdName = value;
    }

    /**
     * Gets the value of the receiptNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNbr() {
        return receiptNbr;
    }

    /**
     * Sets the value of the receiptNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNbr(String value) {
        this.receiptNbr = value;
    }

    /**
     * Gets the value of the merchant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchant() {
        return merchant;
    }

    /**
     * Sets the value of the merchant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchant(String value) {
        this.merchant = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the stateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the value of the stateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateCode(String value) {
        this.stateCode = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the preauthOrDebitHld property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreauthOrDebitHld() {
        return preauthOrDebitHld;
    }

    /**
     * Sets the value of the preauthOrDebitHld property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreauthOrDebitHld(String value) {
        this.preauthOrDebitHld = value;
    }

    /**
     * Gets the value of the addtlInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlInfo() {
        return addtlInfo;
    }

    /**
     * Sets the value of the addtlInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlInfo(String value) {
        this.addtlInfo = value;
    }

}
