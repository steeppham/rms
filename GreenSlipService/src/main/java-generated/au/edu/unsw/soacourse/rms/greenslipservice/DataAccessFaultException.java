
package au.edu.unsw.soacourse.rms.greenslipservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-05-23T09:23:40.493+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "DriverAccessFault", targetNamespace = "http://rms.soacourse.unsw.edu.au/GreenSlipService/")
public class DataAccessFaultException extends Exception {
    
    private au.edu.unsw.soacourse.rms.greenslipservice.DriverAccessFault driverAccessFault;

    public DataAccessFaultException() {
        super();
    }
    
    public DataAccessFaultException(String message) {
        super(message);
    }
    
    public DataAccessFaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessFaultException(String message, au.edu.unsw.soacourse.rms.greenslipservice.DriverAccessFault driverAccessFault) {
        super(message);
        this.driverAccessFault = driverAccessFault;
    }

    public DataAccessFaultException(String message, au.edu.unsw.soacourse.rms.greenslipservice.DriverAccessFault driverAccessFault, Throwable cause) {
        super(message, cause);
        this.driverAccessFault = driverAccessFault;
    }

    public au.edu.unsw.soacourse.rms.greenslipservice.DriverAccessFault getFaultInfo() {
        return this.driverAccessFault;
    }
}
