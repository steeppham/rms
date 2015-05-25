package au.edu.unsw.soacourse.rms.data;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

@Path("/registration")
public class Registration {

	// Return list of all vehicle types
	@GET
	@Path("vehicletype")
	@Produces(MediaType.TEXT_XML)
	public String getVehicleType(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> vehicle type list " + sort
				+ "</hello>";
	}

	// Return list of all fuel types
	@GET
	@Path("fueltype")
	@Produces(MediaType.TEXT_XML)
	public String getFuelType(@QueryParam("sort") String sort) {
		try {
			 // Use XQJ to execute an XQuery with Saxon HE
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();

		    // InputStream for the XQuery
		    InputStream query = getClass().getClassLoader().getResourceAsStream(
		    		"/table126.xq");
		    
		    // Create a prepared expression ...
		    XQPreparedExpression exp = conn.prepareExpression(query);

		    // ... and bind the path to the input document to XQuery variable $input-document
		    String inputFile = getClass().getClassLoader().getResource("table126.xml").getPath();
		    exp.bindString(new QName("input-document"), inputFile, null);

		    // Execute the query and ...
		    XQSequence xqs = exp.executeQuery();

		    // ... print the resulting document to standard out.
		    xqs.writeSequence(System.out, null);

		    // Clean up (production code should do that in a finally clause!)
		    xqs.close();
		    conn.close();
		    query.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "<?xml version=\"1.0\"?>" + "<hello> fuel type list " + sort
				+ "</hello>";
	}

	// Return list of all fuel types
	@GET
	@Path("postcode")
	@Produces(MediaType.TEXT_XML)
	public String getAllPostcode(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello>all postcode " + sort
				+ "</hello>";
	}

	// Return list of all fuel types
	@GET
	@Path("postcode/{code}")
	@Produces(MediaType.TEXT_XML)
	public String getPostcode(@PathParam("code") String code,
			@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> postcode " + code + " "
				+ sort + "</hello>";

	}

	// Return list of all fuel types
	@GET
	@Path("fuel")
	@Produces(MediaType.TEXT_XML)
	public String getAllFuel(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> all fuel " + sort
				+ "</hello>";
	}

	// Return list of all fuel types
	@GET
	@Path("fuel/{fueltype}")
	@Produces(MediaType.TEXT_XML)
	public String getFuel(@PathParam("fueltype") String fuelType,
			@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> fuel " + fuelType + " "
				+ sort + "</hello>";
	}

	private void helloword() {

	}
}
