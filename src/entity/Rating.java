package entity;

public class Rating {
	
	private int ratingId;
	private String ratingScale;
	
	public Rating (int ratingId, String ratingScale) {
		this.setRatingId(ratingId);
		this.setRatingScale(ratingScale);


}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}


	public String getRatingScale() {
		return ratingScale;
	}

	public void setRatingScale(String ratingScale) {
		this.ratingScale = ratingScale;
	}
}