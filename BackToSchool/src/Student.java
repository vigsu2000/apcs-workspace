import processing.core.PApplet;
import processing.core.PImage;

/**
 * L.A.11.1
 *
 * A student, is a Person with an id number and
 * a grade point average
 */

class Student extends Person
{
  private String myIdNum;    // Student Id Number
  private double myGPA;      // grade point average

  // constructor
  public Student(String name, int age, String gender, String idNum, double gpa, double x, double y, double width, double height)
  {
    // use the super class' constructor
    super(name, age, gender, x, y, width, height);

    // initialize what's new to Student
    myIdNum = idNum;
    myGPA = gpa;
  }
  
  public void draw(PApplet drawer) {
		PImage stud = drawer.loadImage("Student.png");
		super.draw(drawer, stud);
	}

  public String getIdNum()
  {
    return myIdNum;
  }

  public double getGPA()
  {
    return myGPA;
  }

  public void setIdNum(String idNum)
  {
    myIdNum = idNum;
  }

  public void setGPA(double gpa)
  {
    myGPA = gpa;
  }

  public String toString()
  {
    return super.toString() +
           ", student id: " + myIdNum + ", gpa: " + myGPA;
  }
}
