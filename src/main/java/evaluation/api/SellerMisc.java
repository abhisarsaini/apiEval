package evaluation.api;

import java.net.UnknownHostException;
import java.util.Random;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class SellerMisc {
	static Random random = new Random();
	static String city[] = { "Bangalore", "Ambala", "Chennai", "Mumbai",
			"Mangalore", "Chandigarh" };

	public static void main(String[] args) throws UnknownHostException {
		loadSellers();
	}

	public static void loadSellers() throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("seller");
		DBCollection col = db.getCollection("sellers");

		for (int i = 201; i < 301; i++) {
			Seller seller = createSeller(i);
			DBObject doc = createDBObject(seller);
			WriteResult result = col.insert(doc);

		}
		/*
		 * System.out.println(result.getUpsertedId());
		 * System.out.println(result.getN());
		 * System.out.println(result.isUpdateOfExisting());
		 * System.out.println(result.getLastConcern()); DBObject query =
		 * BasicDBObjectBuilder.start().add("_id", 101) .get(); DBCursor cursor
		 * = col.find(query); while (cursor.hasNext()) {
		 * System.out.println(cursor.next()); } }
		 */
	}

	private static DBObject createDBObject(Seller user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", user.getId());
		docBuilder.append("name", user.getName());
		docBuilder.append("address", user.getAddress());
		docBuilder.append("city", user.getCity());
		docBuilder.append("pin", user.getPin());

		return docBuilder.get();
	}

	private static Seller createSeller(int i) {
		Seller s = new Seller();
		s.setId(i);
		s.setName("Jabran"+i);
		s.setAddress("Flat " + i + " Sun City" + " Snapdeal Village");
		s.setCity(city[random.nextInt(6)]);
		s.setPin(560000 + i);
		return s;
	}
}
