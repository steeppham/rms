
package au.edu.unsw.soacourse.rms.pinkslipprovider;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the au.edu.unsw.soacourse.rms.pinkslipprovider package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: au.edu.unsw.soacourse.rms.pinkslipprovider
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PSCheckRequest }
     * 
     */
    public PSCheckRequest createPSCheckRequest() {
        return new PSCheckRequest();
    }

    /**
     * Create an instance of {@link PSCheckResponse }
     * 
     */
    public PSCheckResponse createPSCheckResponse() {
        return new PSCheckResponse();
    }

    /**
     * Create an instance of {@link VehicleAgeResponse }
     * 
     */
    public VehicleAgeResponse createVehicleAgeResponse() {
        return new VehicleAgeResponse();
    }

    /**
     * Create an instance of {@link DriverNotFoundFault }
     * 
     */
    public DriverNotFoundFault createDriverNotFoundFault() {
        return new DriverNotFoundFault();
    }

    /**
     * Create an instance of {@link DataAccessFault }
     * 
     */
    public DataAccessFault createDataAccessFault() {
        return new DataAccessFault();
    }

    /**
     * Create an instance of {@link VehicleAgeRequest }
     * 
     */
    public VehicleAgeRequest createVehicleAgeRequest() {
        return new VehicleAgeRequest();
    }

}
