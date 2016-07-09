import processing.core.PApplet;
import processing.core.PImage;

public class Teacher extends Person {
	
	private String subject;
	private int salary;
	private double x, y, width, height;

	public Teacher(String name, int age, String gender, String subject, int salary, double x, double y, double width, double height) {
		super(name, age, gender, x, y, width, height);
		this.subject = subject;
		this.salary = salary;
	}
	
	public void draw(PApplet drawer) {
		PImage teach = drawer.loadImage("Teacher.png");
		super.draw(drawer, teach);
	}
	
	public String getSubject() {
		return subject;
	}
	
	public int getSalary() {
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
