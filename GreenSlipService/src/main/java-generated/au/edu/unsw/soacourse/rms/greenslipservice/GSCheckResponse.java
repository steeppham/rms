
package au.edu.unsw.soacourse.rms.greenslipservice;

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
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="regoNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="paidFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "lastname",
    "firstname",
    "regoNumber",
    "paidFlag"
})
@XmlRootElement(name = "GSCheckResponse")
public class GSCheckResponse {

    @XmlElement(required = true)
    protected String lastname;
    @XmlElement(required = true)
    protected String firstname;
    protected int regoNumber;
    protected boolean paidFlag;

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the regoNumber property.
     * 
     */
    public int getRegoNumber() {
        return regoNumber;
    }

    /**
     * Sets the value of the regoNumber property.
     * 
     */
    public void setRegoNumber(int value) {
        this.regoNumber = value;
    }

    /**
     * Gets the value of the paidFlag property.
     * 
     */
    public boolean isPaidFlag() {
        return paidFlag;
    }

    /**
     * Sets the value of the paidFlag property.
     * 
     */
    public void setPaidFlag(boolean value) {
        this.paidFlag = value;
    }

}