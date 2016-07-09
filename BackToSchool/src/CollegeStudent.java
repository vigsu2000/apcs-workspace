import processing.core.PApplet;
import processing.core.PImage;

public class CollegeStudent extends Student {
	
	private int year;
	private String major;

	public CollegeStudent(String name, int age, String gender, String idNum, double gpa, int year, String major, 
			double x, double y, double width, double height) {
		super(name, age, gender, idNum, gpa, x, y, width, height);
		this.year = year;
		this.major = major;
	}
	
	public void draw(PApplet drawer) {
		PImage CollStud = drawer.loadImage("CollegeStudent.png");
		super.draw(drawer, CollStud);
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	public void setMajor(String m) {
		major = m;
	}
	
	public String toString() {
		 return super.toString() +
		           ", year: " + year + ", major: " + major;
	}
		
}
