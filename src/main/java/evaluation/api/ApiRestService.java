package evaluation.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/rest")
public class ApiRestService {

	@GET
	@Path("/testFunc")
	public Response apiTestFunc() {
		return Response.status(Response.Status.OK).entity("Reached").build();
	}

}
