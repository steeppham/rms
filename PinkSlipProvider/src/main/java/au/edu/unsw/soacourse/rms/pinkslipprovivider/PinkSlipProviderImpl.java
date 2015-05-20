package au.edu.unsw.soacourse.rms.pinkslipprovivider;

import javax.jws.WebService;

import au.edu.unsw.soacourse.rms.pinkslipprovider.DataAccessFaultException;
import au.edu.unsw.soacourse.rms.pinkslipprovider.DriverNotFoundFaultException;
import au.edu.unsw.soacourse.rms.pinkslipprovider.ObjectFactory;
import au.edu.unsw.soacourse.rms.pinkslipprovider.PSCheckRequest;
import au.edu.unsw.soacourse.rms.pinkslipprovider.PSCheckResponse;
import au.edu.unsw.soacourse.rms.pinkslipprovider.PinkSlipProvider;
import au.edu.unsw.soacourse.rms.pinkslipprovider.VehicleAgeRequest;
import au.edu.unsw.soacourse.rms.pinkslipprovider.VehicleAgeResponse;

@WebService(endpointInterface = "au.edu.unsw.soacourse.rms.pinkslipprovider.PinkSlipProvider")
public class PinkSlipProviderImpl implements PinkSlipProvider {

	private ObjectFactory factory = new ObjectFactory();
	
	@Override
	public VehicleAgeResponse vehicleAge(VehicleAgeRequest parameters)
			throws DriverNotFoundFaultException, DataAccessFaultException {
		// TODO dummy implementation
		VehicleAgeResponse response = factory.createVehicleAgeResponse();
		response.setAge(13);
		return response;
	}

	@Override
	public PSCheckResponse psCheck(PSCheckRequest parameters)
			throws DriverNotFoundFaultException, DataAccessFaultException {
		// TODO dummy implementation
		PSCheckResponse response = factory.createPSCheckResponse();
		response.setFirstname(parameters.getFirstname());
		response.setLastname(parameters.getLastname());
		response.setRegoNumber(parameters.getRegoNumber());
		response.setCheckedFlag(true);
		return response;
	}
}
