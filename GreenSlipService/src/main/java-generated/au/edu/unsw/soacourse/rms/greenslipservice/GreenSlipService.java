package au.edu.unsw.soacourse.rms.greenslipservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-05-23T09:23:40.530+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://rms.soacourse.unsw.edu.au/GreenSlipService/", name = "GreenSlipService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface GreenSlipService {

    @WebResult(name = "GSCheckResponse", targetNamespace = "http://rms.soacourse.unsw.edu.au/GreenSlipService/", partName = "parameters")
    @WebMethod(operationName = "GSCheck", action = "http://rms.soacourse.unsw.edu.au/GreenSlipService/GSCheck")
    public GSCheckResponse gsCheck(
        @WebParam(partName = "parameters", name = "GSCheckRequest", targetNamespace = "http://rms.soacourse.unsw.edu.au/GreenSlipService/")
        GSCheckRequest parameters
    ) throws DataAccessFaultException, DriverNotFoundFaultException;
}
