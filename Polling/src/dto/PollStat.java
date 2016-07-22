package dto;

import java.util.ArrayList;

public class PollStat {
	
	public PollStat(long votes, String option, String college, String area, ArrayList<UserAge> ages, long optionA,
			long optionB, long optionC, long optionD, long male, long female) {
		super();
		this.votes = votes;
		this.option = option;
		this.college = college;
		this.area = area;
		this.ages = ages;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.male = male;
		this.female = female;
	}
	public PollStat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PollStat(long votes, String option, String college, String area) {
		super();
		this.votes = votes;
		this.option = option;
		this.college = college;
		this.area = area;
	}
	private long votes;
	private String option;
	private String college;
	private String area;
	
	private ArrayList<UserAge> ages;
	private long optionA;
	private long optionB;
	private long optionC;
	private long optionD;
	
	private long male;
	private long female;
	
	
	
	public long getVotes() {
		return votes;
	}
	public void setVotes(long votes) {
		this.votes = votes;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public ArrayList<UserAge> getAges() {
		return ages;
	}
	public void setAges(ArrayList<UserAge> ages) {
		this.ages = ages;
	}
	public long getOptionA() {
		return optionA;
	}
	public void setOptionA(long optionA) {
		this.optionA = optionA;
	}
	public long getOptionB() {
		return optionB;
	}
	public void setOptionB(long optionB) {
		this.optionB = optionB;
	}
	public long getOptionC() {
		return optionC;
	}
	public void setOptionC(long optionC) {
		this.optionC = optionC;
	}
	public long getOptionD() {
		return optionD;
	}
	public void setOptionD(long optionD) {
		this.optionD = optionD;
	}
	public long getMale() {
		return male;
	}
	public void setMale(long male) {
		this.male = male;
	}
	public long getFemale() {
		return female;
	}
	public void setFemale(long female) {
		this.female = female;
	}

}
