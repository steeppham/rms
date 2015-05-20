
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
 *         &lt;element name="DriverAccessFault" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "driverAccessFault"
})
@XmlRootElement(name = "DriverAccessFault")
public class DriverAccessFault {

    @XmlElement(name = "DriverAccessFault", required = true)
    protected String driverAccessFault;

    /**
     * Gets the value of the driverAccessFault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverAccessFault() {
        return driverAccessFault;
    }

    /**
     * Sets the value of the driverAccessFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverAccessFault(String value) {
        this.driverAccessFault = value;
    }

}
