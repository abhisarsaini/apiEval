package evaluation.api;

import java.util.Random;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class SimpleClient {
	private static Cluster cluster;
	static Random ran = new Random();
	static Session session;

	public static void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node).build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n",
				metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}
	}

	public static void close() {
		cluster.close();
	}

	public static String getTitle() {
		connect("127.0.0.1");
		session = cluster.connect();
		String title = "";

		ResultSet results = session.execute("SELECT * FROM simplex.songs");
		for (Row row : results) {

			title = row.getString("review");
		}
		close();
		return title;
	}

	public static void loadData() {
		connect("127.0.0.1");
		session = cluster.connect();

		session.execute("CREATE KEYSPACE rrating WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':3};");

		session.execute("CREATE TABLE rrating.reviews (" + "id uuid,"
				+ "sellerid int," + "productid int," + "review text,"
				+ "rating int," + "PRIMARY KEY(sellerid, productid)," + ");");

		for (int i = 1; i < 10000; i++) {
			session.execute("INSERT INTO rrating.reviews (sellerid, productid, review, rating) "
					+ "VALUES ("

					+ ran.nextInt(101)
					+ ","
					+ ran.nextInt(10)
					+ ","
					+ "'This is a very good product"
					+ i
					+ "'"
					+ ","
					+ ran.nextInt(5) + ");");
		}

	}

	public static String getReviewBySellerId(int sid) {
		connect("127.0.0.1");
		session = cluster.connect();
		String title = "";

		ResultSet results = session.execute("SELECT * FROM rrating.reviews "
				+ "WHERE sellerid = " + sid + ";");
		for (Row row : results) {

			title = row.getString("review");
		}
		close();
		return title;
	}

	
	public static void main(String[] args) {

	}
}