package au.edu.unsw.soacourse.rms.pinkslipprovider;

import java.io.IOException;
import java.io.InputStream;

import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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

	private final String XML_DATABASE = "PinkSlip_Database.xml";
	
	private Document doc;

	@Override
	public VehicleAgeResponse vehicleAge(VehicleAgeRequest parameters)
			throws DriverNotFoundFaultException, DataAccessFaultException {
		String expression = String
				.format("Customers/Entry/Driver/LastName[text()='%s']/../FirstName[text()='%s']/../../CarDetails/RegistrationNumber[text()='%s']/../ManufacturedYear/text()",
						parameters.getLastname(), parameters.getFirstname(), parameters.getRegoNumber());
		String age = readDatabase(expression);
		VehicleAgeResponse response = factory.createVehicleAgeResponse();
		response.setAge(Integer.parseInt(age));
		return response;
	}

	@Override
	public PSCheckResponse psCheck(PSCheckRequest parameters)
			throws DriverNotFoundFaultException, DataAccessFaultException {
		
		String expression = String
				.format("Customers/Entry/Driver/LastName[text()='%s']/../FirstName[text()='%s']/../../CarDetails/RegistrationNumber[text()='%s']/../../SafetyCheckUpToDate/text()",
						parameters.getLastname(), parameters.getFirstname(), parameters.getRegoNumber());
		String safetyCheckUpToDate = readDatabase(expression);
		boolean checked = safetyCheckUpToDate.equalsIgnoreCase("yes") ? true : false;
		
		PSCheckResponse response = factory.createPSCheckResponse();
		response.setFirstname(parameters.getFirstname());
		response.setLastname(parameters.getLastname());
		response.setRegoNumber(parameters.getRegoNumber());
		response.setCheckedFlag(checked);
		return response;
	}
	
	private String readDatabase(String query) throws DataAccessFaultException, DriverNotFoundFaultException {
		// Read XML file into memory
		if (doc == null) {
			InputStream file = getClass().getClassLoader().getResourceAsStream(
					"/" + XML_DATABASE);
			if (file == null) {
				throw new DataAccessFaultException("Cannot find " + XML_DATABASE);
			}
	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				doc = dBuilder.parse(file);
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
				throw new DataAccessFaultException(
						"Failed to read " + XML_DATABASE, e);
			}
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new DataAccessFaultException(
						"Failed to close " + XML_DATABASE, e);
			}
		}

		// Find the driver
		XPath xPath = XPathFactory.newInstance().newXPath();
		String result = null;
		try {
			result = xPath.compile(query).evaluate(doc);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			throw new DataAccessFaultException("Fail to search for "
					+ XML_DATABASE, e);
		}

		if (result.isEmpty()) {
			throw new DriverNotFoundFaultException("Cannot locate driver");
		}
		
		return result;
	}

}
