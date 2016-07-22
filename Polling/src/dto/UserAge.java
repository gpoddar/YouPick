package dto;

public class UserAge {
	
	public UserAge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAge(int age, int number) {
		super();
		this.age = age;
		this.number = number;
	}
	private int age;
	private int number;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
