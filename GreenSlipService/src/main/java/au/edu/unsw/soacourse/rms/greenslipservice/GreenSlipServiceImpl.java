package au.edu.unsw.soacourse.rms.greenslipservice;

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

@WebService(endpointInterface = "au.edu.unsw.soacourse.rms.greenslipservice.GreenSlipService")
public class GreenSlipServiceImpl implements GreenSlipService {

	private ObjectFactory factory = new ObjectFactory();
	
	private final String XML_DATABASE = "GreenSlip_Database.xml";
	
	private Document doc;
	
	@Override
	public GSCheckResponse gsCheck(GSCheckRequest parameters)
			throws DataAccessFaultException, DriverNotFoundFaultException {
		String expression = String.format("Customers/Entry/Driver/LastName[text()='%s']/../FirstName[text()='%s']/../../RegistrationNumber[text()='%s']/../CTPDetails/CurrentlyValid/text()", 
				parameters.lastname, parameters.firstname, parameters.getRegoNumber());
		String currentlyValid = readDatabase(expression);
		boolean paid = currentlyValid.equalsIgnoreCase("yes") ? true : false;
		
		GSCheckResponse response = factory.createGSCheckResponse();
		response.setFirstname(parameters.getFirstname());
		response.setLastname(parameters.getLastname());
		response.setRegoNumber(parameters.getRegoNumber());
		response.setPaidFlag(paid);
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
