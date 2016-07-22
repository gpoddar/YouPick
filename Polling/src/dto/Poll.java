package dto;

import java.sql.Date;

public class Poll {
	public Poll(double pollId, String title, String description, String imgSrc, String tagged, String optionOne,
			String optiontwo, String optionThree, String optionFour, String fbCommentId, int binary, long category,
			int userAnswer, double score, Date createdAt, long votes, String categoryName) {
		super();
		this.pollId = pollId;
		this.title = title;
		this.description = description;
		this.imgSrc = imgSrc;
		this.tagged = tagged;
		this.optionOne = optionOne;
		this.optiontwo = optiontwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.fbCommentId = fbCommentId;
		this.binary = binary;
		this.category = category;
		this.userAnswer = userAnswer;
		this.score = score;
		this.createdAt = createdAt;
		this.votes = votes;
		this.categoryName = categoryName;
	}
	public Poll(double pollId, String title, String description, String imgSrc, String tagged, String optionOne,
			String optiontwo, String optionThree, String optionFour, String fbCommentId, int binary, long category,
			int userAnswer) {
		super();
		this.pollId = pollId;
		this.title = title;
		this.description = description;
		this.imgSrc = imgSrc;
		this.tagged = tagged;
		this.optionOne = optionOne;
		this.optiontwo = optiontwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.fbCommentId = fbCommentId;
		this.binary = binary;
		this.category = category;
		this.userAnswer = userAnswer;
	}
	public Poll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Poll(double pollId, String title, String description, String imgSrc, String tagged, String optionOne,
			String optiontwo, String optionThree, String optionFour, String fbCommentId) {
		super();
		this.pollId = pollId;
		this.title = title;
		this.description = description;
		this.imgSrc = imgSrc;
		this.tagged = tagged;
		this.optionOne = optionOne;
		this.optiontwo = optiontwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.fbCommentId = fbCommentId;
		
	}
	private double pollId;
	private String title;
	private String description;
	private String imgSrc;
	private String tagged;
	private String optionOne;
	private String optiontwo;
	private String optionThree;
	private String optionFour;
	private String fbCommentId;
	private int binary;
	private long category; 
	private int userAnswer;
	private double score;
	private Date createdAt;
	private long votes;
	private String categoryName;
	
	public double getPollId() {
		return pollId;
	}
	public void setPollId(double pollId) {
		this.pollId = pollId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getTagged() {
		return tagged;
	}
	public void setTagged(String tagged) {
		this.tagged = tagged;
	}
	public String getOptionOne() {
		return optionOne;
	}
	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}
	public String getOptiontwo() {
		return optiontwo;
	}
	public void setOptiontwo(String optiontwo) {
		this.optiontwo = optiontwo;
	}
	public String getOptionThree() {
		return optionThree;
	}
	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}
	public String getOptionFour() {
		return optionFour;
	}
	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}
	public String getFbCommentId() {
		return fbCommentId;
	}
	public void setFbCommentId(String fbCommentId) {
		this.fbCommentId = fbCommentId;
	}
	public int getBinary() {
		return binary;
	}
	public void setBinary(int binary) {
		this.binary = binary;
	}
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public int getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public long getVotes() {
		return votes;
	}
	public void setVotes(long votes) {
		this.votes = votes;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
