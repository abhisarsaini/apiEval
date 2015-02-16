package evaluation.api;

import java.io.Serializable;

public class TestReview implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String review;
	private int reviewId;
	private int sellerId;
	private int userId;
	private int rating;
	
	
	public TestReview() {
		super();
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "{review: " + review + ", reviewId: " + reviewId
				+ ", sellerId: " + sellerId + ", userId: " + userId + ", rating: "
				+ rating + "}";
	}
	
	
	
}
