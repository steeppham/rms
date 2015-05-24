package au.edu.unsw.soacourse.rms.data;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/registration")
public class Registration {

	// Return list of all vehicle types
	@GET
	@Path("vehicletype")
	@Produces(MediaType.TEXT_XML)
	public String getVehicleType(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> vehicle type list " + sort + "</hello>";
	}
	
	// Return list of all fuel types
	@GET
	@Path("fueltype")
	@Produces(MediaType.TEXT_XML)
	public String getFuelType(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> fuel type list " + sort + "</hello>";
	}
	
	// Return list of all fuel types
	@GET
	@Path("postcode")
	@Produces(MediaType.TEXT_XML)
	public String getAllPostcode(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello>all postcode " + sort + "</hello>";
	}
	
	// Return list of all fuel types
	@GET
	@Path("postcode/{code}")
	@Produces(MediaType.TEXT_XML)
	public String getPostcode(@PathParam("code") String code, @QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> postcode " + code + " " + sort + "</hello>";

	}
	
	// Return list of all fuel types
	@GET
	@Path("fuel")
	@Produces(MediaType.TEXT_XML)
	public String getAllFuel(@QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> all fuel " + sort + "</hello>";
	}
	
	// Return list of all fuel types
	@GET
	@Path("fuel/{fueltype}")
	@Produces(MediaType.TEXT_XML)
	public String getFuel(@PathParam("fueltype") String fuelType, @QueryParam("sort") String sort) {
		return "<?xml version=\"1.0\"?>" + "<hello> fuel " + fuelType + " " + sort + "</hello>";
	}
}
