package dto;

public class Answer {
	
	public Answer(double optionA, double optionB, double optionC, double optionD, double poll_id, boolean binary,
			int useranswer) {
		super();
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.poll_id = poll_id;
		this.binary = binary;
		this.useranswer = useranswer;
	}
	public Answer(double optionA, double optionB, double optionC, double optionD, double poll_id, boolean binary) {
		super();
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.poll_id = poll_id;
		this.binary = binary;
	}
	public Answer() {
		super();
		
	}
	private double optionA;
	private double optionB;
	private double optionC;
	private double optionD;
	private double poll_id;
	private boolean binary;
	private int useranswer;
	public double getOptionA() {
		return optionA;
	}
	public void setOptionA(double optionA) {
		this.optionA = optionA;
	}
	public double getOptionB() {
		return optionB;
	}
	public void setOptionB(double optionB) {
		this.optionB = optionB;
	}
	public double getOptionC() {
		return optionC;
	}
	public void setOptionC(double optionC) {
		this.optionC = optionC;
	}
	public double getOptionD() {
		return optionD;
	}
	public void setOptionD(double optionD) {
		this.optionD = optionD;
	}
	public double getPoll_id() {
		return poll_id;
	}
	public void setPoll_id(double poll_id) {
		this.poll_id = poll_id;
	}
	public boolean isbinary() {
		return binary;
	}
	public void setbinary(boolean binary) {
		this.binary = binary;
	}
	public boolean isBinary() {
		return binary;
	}
	public void setBinary(boolean binary) {
		this.binary = binary;
	}
	public int getUseranswer() {
		return useranswer;
	}
	public void setUseranswer(int useranswer) {
		this.useranswer = useranswer;
	}

}
