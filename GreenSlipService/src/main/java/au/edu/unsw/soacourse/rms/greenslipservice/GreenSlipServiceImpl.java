package au.edu.unsw.soacourse.rms.greenslipservice;

import javax.jws.WebService;

@WebService(endpointInterface = "au.edu.unsw.soacourse.rms.greenslipservice.GreenSlipService")
public class GreenSlipServiceImpl implements GreenSlipService {

	private ObjectFactory factory = new ObjectFactory();
	
	@Override
	public GSCheckResponse gsCheck(GSCheckRequest parameters)
			throws DataAccessFaultException, DriverNotFoundFaultException {
		// TODO dummy implementation
		GSCheckResponse response = factory.createGSCheckResponse();
		response.setFirstname(parameters.getFirstname());
		response.setLastname(parameters.getLastname());
		response.setRegoNumber(parameters.getRegoNumber());
		response.setPaidFlag(true);
		return response;
	}

}
