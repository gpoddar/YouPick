package dto;

public class User {

    private double id;
    private int age;
    private String sex;
    private String fullName;
    private double areaID;
    private double schoolID;
    private String emailID;
    private String fb_userID;
    private String password;
    
    public User(){
        super();
    }
    
    public User(double id, int age, String sex, String fullName, double areaID, double schoolID) {
        super();
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.fullName = fullName;
        this.areaID = areaID;
        this.schoolID = schoolID;
    }
    
    public double getId() {
        return id;
    }
    public void setId(double id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public double getAreaID() {
        return areaID;
    }
    public void setAreaID(double areaID) {
        this.areaID = areaID;
    }
    public double getSchoolID() {
        return schoolID;
    }
    public void setSchoolID(double schoolID) {
        this.schoolID = schoolID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFb_userID() {
        return fb_userID;
    }

    public void setFb_userID(String fb_userID) {
        this.fb_userID = fb_userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
