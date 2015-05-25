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
		if (sort == null)
			sort = "none";
		return xquery("table127.xml", "table127.xq", sort, null);
	}

	// Return list of all fuel types
	@GET
	@Path("fueltype")
	@Produces(MediaType.TEXT_XML)
	public String getFuelType(@QueryParam("sort") String sort) {
		if (sort == null)
			sort = "none";
		return xquery("table126.xml", "table126.xq", sort, null);
	}

	// Return new registrations by postcodes
	@GET
	@Path("postcode")
	@Produces(MediaType.TEXT_XML)
	public String getAllPostcode(@QueryParam("sort") String sort) {
		if (sort == null)
			sort = "none";
		return xquery("table127.xml", "table127a.xq", sort, ".*");
	}

	// Return new registrations by postcodes
	@GET
	@Path("postcode/{code}")
	@Produces(MediaType.TEXT_XML)
	public String getPostcode(@PathParam("code") String code,
			@QueryParam("sort") String sort) {
		if (sort == null)
			sort = "none";
		return xquery("table127.xml", "table127a.xq", sort, code);
	}

	// Return new registrations by fuel type
	@GET
	@Path("fuel")
	@Produces(MediaType.TEXT_XML)
	public String getAllFuel(@QueryParam("sort") String sort) {
		if (sort == null)
			sort = "none";
		return xquery("table126.xml", "table126_reg.xq", sort, ".*");
	}

	// Return new registrations by fuel type
	@GET
	@Path("fuel/{fueltype}")
	@Produces(MediaType.TEXT_XML)
	public String getFuel(@PathParam("fueltype") String fuelType,
			@QueryParam("sort") String sort) {
		if (sort == null)
			sort = "none";
		return xquery("table126.xml", "table126_reg.xq", sort, fuelType);
	}

	private String xquery(String source, String template, String sort, String pattern) {
		String output = null;
		try {
			 // Use XQJ to execute an XQuery with Saxon HE
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();

		    // InputStream for the XQuery
		    InputStream query = getClass().getClassLoader().getResourceAsStream(template);
		    
		    // Create a prepared expression ...
		    XQPreparedExpression exp = conn.prepareExpression(query);

		    // ... and bind the path to the input document to XQuery variable $input-document
		    String inputFile = getClass().getClassLoader().getResource(source).getPath();
		    exp.bindString(new QName("input-document"), inputFile, null);
		    if (sort != null && !sort.isEmpty()) 
		    	exp.bindString(new QName("sort"), sort, null);
		    if (pattern != null && !pattern.isEmpty())
		    	exp.bindString(new QName("pattern"), pattern, null);

		    // Execute the query and ...
		    XQSequence xqs = exp.executeQuery();

		    // ... print the resulting document to standard out.
		    //xqs.writeSequence(System.out, null);
		    output = xqs.getSequenceAsString(null);

		    // Clean up (production code should do that in a finally clause!)
		    xqs.close();
		    conn.close();
		    query.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return output;
	}
}
