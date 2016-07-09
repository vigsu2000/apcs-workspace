import processing.core.PApplet;
import processing.core.PImage;

public class Teacher extends Person {
	
	private String subject;
	private double salary;

	public Teacher(String name, int age, String gender, String subject, double salary) {
		super(name, age, gender);
		this.subject = subject;
		this.salary = salary;
	}
	
	public void draw(PApplet drawer, double x, double y, double width, double height) {
		PImage teach = drawer.loadImage("Teacher.png");
		super.draw(drawer, teach, x, y, width, height);
	}
	
	public String getSubject() {
		return subject;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSubject(String s) {
		subject = s;
	}
	
	public void setSalary(int s) {
		salary = s;
	}
	
	public String toString() {
		 return super.toString() +
		           ", subject: " + subject + ", salary: $" + salary;
	}

}
