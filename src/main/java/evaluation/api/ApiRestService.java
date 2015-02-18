package evaluation.api;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
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
		TestReview review = new TestReview();
		review.setSellerId(sid);
		review.setReview(SimpleClient.getReviewBySellerId(sid));
		review.setReviewId(RandomDataGenerator.generateRandomNumber(1000));
		review.setUserId(RandomDataGenerator.generateRandomNumber(1000));
		review.setRating(RandomDataGenerator.generateRandomNumber(5));
		return Response.status(Response.Status.OK).entity(review.toString())
				.build();
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

	@GET
	@Path("/reviewByUserId/{uid}")
	public Response getReviewByUserId(@PathParam("uid") int uid) {
		TestReview review = new TestReview();
		review.setSellerId(RandomDataGenerator.generateRandomNumber(1000));
		review.setReview(RandomDataGenerator.generateRandomReview());
		review.setReviewId(RandomDataGenerator.generateRandomNumber(1000));
		review.setUserId(uid);
		review.setRating(RandomDataGenerator.generateRandomNumber(5));
		return Response.status(Response.Status.OK).entity(review.toString())
				.build();
	}

	@GET
	@Path("/reviewByReviewID/{rid}")
	public Response getReviewByReviewId(@PathParam("rid") int rid) {
		TestReview review = new TestReview();
		review.setSellerId(RandomDataGenerator.generateRandomNumber(1000));
		review.setReview(RandomDataGenerator.generateRandomReview());
		review.setReviewId(rid);
		review.setUserId(RandomDataGenerator.generateRandomNumber(1000));
		review.setRating(RandomDataGenerator.generateRandomNumber(5));
		return Response.status(Response.Status.OK).entity(review.toString())
				.build();
	}
}
