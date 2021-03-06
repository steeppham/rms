
package au.edu.unsw.soacourse.rms.pinkslipprovider;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-05-23T11:10:28.306+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "DataAccessFault", targetNamespace = "http://rms.soacourse.unsw.edu.au/PinkSlipProvider/")
public class DataAccessFaultException extends Exception {
    
    private au.edu.unsw.soacourse.rms.pinkslipprovider.DataAccessFault dataAccessFault;

    public DataAccessFaultException() {
        super();
    }
    
    public DataAccessFaultException(String message) {
        super(message);
    }
    
    public DataAccessFaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessFaultException(String message, au.edu.unsw.soacourse.rms.pinkslipprovider.DataAccessFault dataAccessFault) {
        super(message);
        this.dataAccessFault = dataAccessFault;
    }

    public DataAccessFaultException(String message, au.edu.unsw.soacourse.rms.pinkslipprovider.DataAccessFault dataAccessFault, Throwable cause) {
        super(message, cause);
        this.dataAccessFault = dataAccessFault;
    }

    public au.edu.unsw.soacourse.rms.pinkslipprovider.DataAccessFault getFaultInfo() {
        return this.dataAccessFault;
    }
}
