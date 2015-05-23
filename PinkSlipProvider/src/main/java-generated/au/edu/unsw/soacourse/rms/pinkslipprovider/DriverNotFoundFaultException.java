
package au.edu.unsw.soacourse.rms.pinkslipprovider;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-05-23T11:10:28.276+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "DriverNotFoundFault", targetNamespace = "http://rms.soacourse.unsw.edu.au/PinkSlipProvider/")
public class DriverNotFoundFaultException extends Exception {
    
    private au.edu.unsw.soacourse.rms.pinkslipprovider.DriverNotFoundFault driverNotFoundFault;

    public DriverNotFoundFaultException() {
        super();
    }
    
    public DriverNotFoundFaultException(String message) {
        super(message);
    }
    
    public DriverNotFoundFaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverNotFoundFaultException(String message, au.edu.unsw.soacourse.rms.pinkslipprovider.DriverNotFoundFault driverNotFoundFault) {
        super(message);
        this.driverNotFoundFault = driverNotFoundFault;
    }

    public DriverNotFoundFaultException(String message, au.edu.unsw.soacourse.rms.pinkslipprovider.DriverNotFoundFault driverNotFoundFault, Throwable cause) {
        super(message, cause);
        this.driverNotFoundFault = driverNotFoundFault;
    }

    public au.edu.unsw.soacourse.rms.pinkslipprovider.DriverNotFoundFault getFaultInfo() {
        return this.driverNotFoundFault;
    }
}
