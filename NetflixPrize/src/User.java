import java.util.ArrayList;

public class User {
	
	private long ID;
	private int age; 
	private char gender;
	private String occupation;
	private String zipCode;
	
	// Constructor
	public User(long ID, int age, char gender, String occupation, String zipCode) {
		this.ID = ID;
		this.age = age; 
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}
	
	public String toString() {
		return ID+" "+age+" "+gender+" "+occupation+" "+zipCode;
	}
	public long getID() {
		return ID;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getOccupation() {
		return occupation;
	}

}
