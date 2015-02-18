package evaluation.api;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomDataGenerator {
	private static List<String> reviews = new ArrayList<String>();
	private static Random randomGenerator = new Random();
	static {
		reviews.add("Satified with the product. Snapdeal service was great");
		reviews.add("Awesome product!! Must have.");
		reviews.add("Didnt like the product, but service was good.");
		reviews.add("Build quality not that great.");
		reviews.add("quick delivery but average product.");
		reviews.add("Bought it during sale, got best price");
		reviews.add("gifted it to parents they loved it.");
		reviews.add("Go for sony instead.");
		reviews.add("Color is different from what is shown in the image.");
		reviews.add("OMG!! working better than i expected.");
		reviews.add("Just close your eyes and go for it.");
		reviews.add("Lot of basic functionality missing.");
		reviews.add("Great product but skeptical about after sales service.");
		reviews.add("Soft fabric, feels really good.");
		reviews.add("Satisfied upptil now. Will update the review later.");
		reviews.add("Broken product, but snapdeal replaced it without any hussle.");
		reviews.add("Average product but I think value for money.");
	}

	public static String generateRandomReview() {
		int index = randomGenerator.nextInt(reviews.size());
		return reviews.get(index);
	}

	public static int generateRandomNumber(int max) {
		return randomGenerator.nextInt(max);
	}
}
