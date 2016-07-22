package dto;

public class University {
public University() {
		super();
		// TODO Auto-generated constructor stub
	}
public University(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
long id;
String name;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
