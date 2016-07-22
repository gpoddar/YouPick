package dto;

public class Area {
public Area(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
public Area() {
		super();
		// TODO Auto-generated constructor stub
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
