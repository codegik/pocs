
package com.fidelityinfoservices.schemas.webservices.miser.vbtp;

import java.math.BigDecimal;
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
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrderNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrderAmt1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrderAmt2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PlacedDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReleaseDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CheckNbr1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CheckNbr2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Payee"/>
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
    "orderNbr",
    "orderAmt1",
    "orderAmt2",
    "placedDt",
    "releaseDt",
    "checkNbr1",
    "checkNbr2",
    "payee"
})
@XmlRootElement(name = "Order")
public class Order {

    @XmlElement(name = "OrderNbr")
    protected int orderNbr;
    @XmlElement(name = "OrderAmt1", required = true)
    protected BigDecimal orderAmt1;
    @XmlElement(name = "OrderAmt2", required = true)
    protected BigDecimal orderAmt2;
    @XmlElement(name = "PlacedDt", required = true)
    protected String placedDt;
    @XmlElement(name = "ReleaseDt", required = true)
    protected String releaseDt;
    @XmlElement(name = "CheckNbr1")
    protected int checkNbr1;
    @XmlElement(name = "CheckNbr2")
    protected int checkNbr2;
    @XmlElement(name = "Payee", required = true)
    protected String payee;

    /**
     * Gets the value of the orderNbr property.
     * 
     */
    public int getOrderNbr() {
        return orderNbr;
    }

    /**
     * Sets the value of the orderNbr property.
     * 
     */
    public void setOrderNbr(int value) {
        this.orderNbr = value;
    }

    /**
     * Gets the value of the orderAmt1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderAmt1() {
        return orderAmt1;
    }

    /**
     * Sets the value of the orderAmt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderAmt1(BigDecimal value) {
        this.orderAmt1 = value;
    }

    /**
     * Gets the value of the orderAmt2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderAmt2() {
        return orderAmt2;
    }

    /**
     * Sets the value of the orderAmt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderAmt2(BigDecimal value) {
        this.orderAmt2 = value;
    }

    /**
     * Gets the value of the placedDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacedDt() {
        return placedDt;
    }

    /**
     * Sets the value of the placedDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacedDt(String value) {
        this.placedDt = value;
    }

    /**
     * Gets the value of the releaseDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseDt() {
        return releaseDt;
    }

    /**
     * Sets the value of the releaseDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseDt(String value) {
        this.releaseDt = value;
    }

    /**
     * Gets the value of the checkNbr1 property.
     * 
     */
    public int getCheckNbr1() {
        return checkNbr1;
    }

    /**
     * Sets the value of the checkNbr1 property.
     * 
     */
    public void setCheckNbr1(int value) {
        this.checkNbr1 = value;
    }

    /**
     * Gets the value of the checkNbr2 property.
     * 
     */
    public int getCheckNbr2() {
        return checkNbr2;
    }

    /**
     * Sets the value of the checkNbr2 property.
     * 
     */
    public void setCheckNbr2(int value) {
        this.checkNbr2 = value;
    }

    /**
     * Gets the value of the payee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayee() {
        return payee;
    }

    /**
     * Sets the value of the payee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayee(String value) {
        this.payee = value;
    }

}
