package evaluation.api;

import java.util.Random;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class APIClientService {
	static Random ran = new Random();
    static String input;
    static ClientResponse response;
	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://api.usergrid.com/daivik.gangwar/sdsbox/reviews");
			
			for(int i=0;i<10000;i++)
			{
			input = "{"
					+ "\"id\":"+"\""+i+"\","
					+ "\"sellerid\":"+"\""+ran.nextInt(100)+"\","
					+ "\"productid\":"+"\""+ran.nextInt(10000)+"\","
					+ "\"review\":"+"\"This is a very good product"+i+"\","
					+ "\"rating\":"+"\""+ran.nextInt(5) +"\""
					+ "}";
			System.out.println(input);
			response = webResource.type("application/json")
					.post(ClientResponse.class, input);
			System.out.println(response);

			}
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
