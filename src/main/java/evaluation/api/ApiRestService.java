package evaluation.api;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/rest")
public class ApiRestService {

	@GET
	@Path("/testFunc")
	public Response apiTestFunc() {

		return Response.status(Response.Status.OK).entity("Reached").build();
	}

	@GET
	@Path("/review/{sid}")
	public Response getReviewBySellerId(@PathParam("sid") int sid) {
		return Response.status(Response.Status.OK)
				.entity(SimpleClient.getReviewBySellerId(sid)).build();
	}

	@PUT
	@Path("/load")
	public Response loadData() {
		SimpleClient.loadData();
		return Response.status(Response.Status.OK).entity("Loaded").build();
	}
	
	@PUT					
	@Path("/loadsellers")
	public Response loadSellers() throws UnknownHostException {
		SellerMisc.loadSellers();
		return Response.status(Response.Status.OK).entity("Sellers loaded").build();
	}
	
	
}
